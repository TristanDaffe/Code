#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define FI_MODEL_PATH "../fimodel.csv"
#define TRAIN_SET_PATH "../../phase1/trainSet.csv"

#define TIME_FOR_A_MIN 600

typedef struct dataDixiemeSeconde DataDixiemeSeconde;
struct dataDixiemeSeconde{
    double totVacc;
    double totSquareVacc;
    int nbVacc;
};

void initFiModel(FILE* fiModel);
void writeData(FILE* file, char mouvement[], DataDixiemeSeconde data[], double totVacc, int nbVacc);

void main(void){
    FILE* fiModel;
    FILE* trainSet;

    fopen_s(&trainSet, TRAIN_SET_PATH, "r");
    fopen_s(&fiModel, FI_MODEL_PATH, "w+");
    initFiModel(fiModel);

    if(trainSet == NULL || fiModel == NULL){
        printf("erreur ouverture des fichier\n");
    }
    else{
        char movementType[20];
        char currentMovement[20];
        double vacc;
        char line[10000];
        char* token;
        char* nextToken;

        //contient les Vacc d'un mouvement pour chaque dixieme de seconde
        DataDixiemeSeconde data[TIME_FOR_A_MIN];
        for(int i = 0; i < TIME_FOR_A_MIN; i++){
            data[i].totVacc = 0;
            data[i].totSquareVacc = 0;
            data[i].nbVacc = 0;
        }

        //supprime la ligne des titres
        fgets(line, sizeof(line), trainSet);
        //récupere la première ligne de données
        fgets(line, sizeof(line), trainSet);

        while(!feof(trainSet)){         
            //lis le titre du mouvement en cours
            token = strtok_s(line, ";", &nextToken);
            strcpy(currentMovement, token);

            //utilisé pour la moyenne global
            //nombre de ligne pour le mouvement
            int totalNbVacc = 0;
            //somme des vacc pour ce mouvement
            double totAllVacc = 0;

printf("%s\n\t[", currentMovement);
            do{
printf("|");
                //passe la colonne d'index et du genre
                token = strtok_s(NULL, ";", &nextToken);
                token = strtok_s(NULL, ";", &nextToken);

                int iColumn = 0;
                //récupere les Vacc de la ligne
                token = strtok_s(NULL, ";", &nextToken);
                //traite les Vacc de la lignes dans line
                while(iColumn < TIME_FOR_A_MIN && token != NULL){
                    sscanf_s(token, "%lf", &vacc);
                    data[iColumn].totVacc += vacc;
                    data[iColumn].totSquareVacc += vacc * vacc;
                    data[iColumn].nbVacc++;
                    totAllVacc += vacc;
                    totalNbVacc++; 
                    iColumn++;
                    token = strtok_s(NULL, ";", &nextToken);
                }
            //passe a la ligne suivante
                fgets(line, sizeof(line), trainSet);
            //récupère le type de mouvement
                token = strtok_s(line, ";", &nextToken);
                strcpy(movementType, token);
            }while(strcmp(movementType, currentMovement) == 0 && !feof(trainSet));

printf("]\n");
            //ecrit les données dans fiModel
            writeData(fiModel, currentMovement, data, totAllVacc, totalNbVacc);
            //passe a la ligne suivante d'un nouveau mouvement
            fgets(line, sizeof(line), trainSet);
        }
        fclose(trainSet);
        fclose(fiModel);
    }
}

void initFiModel(FILE* fiModel){
    fprintf(fiModel, "%s;", "mouvement");
    for(int i = 0; i < TIME_FOR_A_MIN; i++)
        fprintf(fiModel, "%s;", "Vacc");
    fprintf(fiModel, "%s", "\n");
}

void writeData(FILE* file, char mouvement[], DataDixiemeSeconde data[], double totVacc, int nbVacc){
    //ecriture des moyennes
    fprintf(file, "%s;", mouvement);
    for(int i = 0; i < TIME_FOR_A_MIN; i++)
        fprintf(file, "%lf;", data[i].totVacc / data[i].nbVacc);
    fprintf(file, "%c", '\n');  

    //ecriture des ecart types
    fprintf(file, "%s;", mouvement);
    for(int i = 0; i < TIME_FOR_A_MIN; i++){
        double standartDeviation = sqrt(data[i].totSquareVacc / data[i].nbVacc - pow(data[i].totVacc / data[i].nbVacc, 2));
        fprintf(file, "%lf;", standartDeviation);
    }
    fprintf(file, "%c", '\n');

    //écriture de la moyenne générale
    fprintf(file, "%s;", mouvement);
    fprintf(file, "%lf;", totVacc / nbVacc);
    fprintf(file, "%c", '\n');
}