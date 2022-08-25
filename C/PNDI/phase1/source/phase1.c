#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

#define DATA_SUBJECT "../data/data_subjects_info.csv"
#define DATA "../data/A_DeviceMotion_data/A_DeviceMotion_data/"
#define TRAIN_SET "../trainSet.csv"
#define TEST_SET "../testSet.csv"

#define NB_SUBJECTS  24
#define NB_FOLDERS 15
#define NB_TEST_SUBJECTS 3
#define TIME_FOR_A_MIN 600

typedef struct data Data;
struct data {
    double userAccX;
    double userAccY;
    double userAccZ;
};

typedef struct subject Subject;
struct subject {
    int code;
    int gender;
};

//prototypes
Subject readSubject(FILE* file);
Data readDataBase(FILE* file);
void writeTilteVacc(FILE* file);
void defineMouvement(char typeMouvement[], char mouvement[]);

void main() {

    char* dir[] = {
        "dws_1/","dws_2/","dws_11/",
        "jog_9/", "jog_16/",
        "sit_5/", "sit_13/",
        "std_6/", "std_14/",
        "ups_3/", "ups_4/", "ups_12/",
        "wlk_7/", "wlk_8/", "wlk_15/",
    };
    char trash[50];

    Subject subjects[NB_SUBJECTS];
    FILE* dataSubject;
    fopen_s(&dataSubject, DATA_SUBJECT, "r");

    FILE* trainSet;
    FILE* testSet;

    if (dataSubject == NULL)
        printf("erreur ouverture file Subject");
    else {
        //retire les titres de colonne
        fgets(trash, sizeof(trash), dataSubject);

        //lit les info des Subject et les sauvegarde
        for (int i = 0; i < NB_SUBJECTS; i++) {
            subjects[i] = readSubject(dataSubject);
        }

        fopen_s(&trainSet, TRAIN_SET, "w");
        fopen_s(&testSet, TEST_SET, "w");
        if (trainSet == NULL || testSet == NULL)
            printf("erreur création file trainset / testset");
        else {
            fprintf(trainSet, "%s; %s; %s", "mouvement", "gender", "index");
            fprintf(testSet, "%s; %s; %s", "mouvement", "gender", "index");

            writeTilteVacc(trainSet);
            writeTilteVacc(testSet);

            int index = 1;
            //permet la repartition entre trainSet et testSet (+- 90 - 10 %)
            int iSubjectForTest = 0;

            //boucle de parcours de chaque folder
            int iFolder = 0;
            while (iFolder < NB_FOLDERS) {
                char folder[100] = "";
                char mouvement[10] = "";
                char typeMouvement[5] = "";

                //contient le chemin vers le fichier de data en cours de traitement
                strcat_s(folder, sizeof(folder), DATA);
                strcat_s(folder, sizeof(folder), dir[iFolder]);

                //gestion de la colonne du type de mouvement
                strncpy_s(typeMouvement, sizeof(typeMouvement), dir[iFolder], 3);
                defineMouvement(typeMouvement, mouvement);

                FILE* fileToWrite;

                //parcours des Subjects
                int nbTestSubjects = 0;
                int iSubject = 0;

                while (iSubject < NB_SUBJECTS) {
                    //choisit si met dans le test ou dans le train
                    if (nbTestSubjects < NB_TEST_SUBJECTS && iSubject == iSubjectForTest + nbTestSubjects) {
                        fileToWrite = testSet;
                        nbTestSubjects++;
                    }
                    else
                        fileToWrite = trainSet;

                    //passe a la ligne pour le Subject
                    fprintf(fileToWrite, "%s", "\n");

                    //ecrit le type de mouvement
                    fprintf(fileToWrite, "%s;", mouvement);

                    //colonne genre
                    fprintf(fileToWrite, "%d;", subjects[iSubject].gender);
                    //colonne index
                    fprintf(fileToWrite, "%d;", index);

                    FILE* dataFile;

                    //cree le chemin vers le file contenant les donnees
                    char code[3];
                    sprintf_s(code, sizeof(code), "%d", subjects[iSubject].code);
                    char pathDataFile[100] = "";

                    strcat_s(pathDataFile, 100, folder);
                    strcat_s(pathDataFile, 100, "sub_");
                    strcat_s(pathDataFile, 100, code);
                    strcat_s(pathDataFile, 100, ".csv");

                    fopen_s(&dataFile, pathDataFile, "r");
                    if (dataFile == NULL)
                        printf("erreur ouverture du fichier de données");
                    else {
                        int i = 0;
                        Data data = readDataBase(dataFile);
                        while (i < TIME_FOR_A_MIN && !feof(dataFile)) {

                            double Vacc = sqrt(data.userAccX * data.userAccX + data.userAccY * data.userAccY + data.userAccZ * data.userAccZ);
                            fprintf(fileToWrite, "%lf;", Vacc);
                            data = readDataBase(dataFile);
                            i++;
                        }
                        fclose(dataFile);
                        iSubject++;
                        index++;
                    }
                }
                iSubjectForTest += 3;
                if (iSubjectForTest >= NB_SUBJECTS)
                    iSubjectForTest = 0;
                iFolder++;
                printf("%s \n", folder);
            }
            fclose(trainSet);
            fclose(testSet);
        }
        fclose(dataSubject);
    }
}

Subject readSubject(FILE* file) {
    Subject subject;
    char line[100];
    int trash;

    fgets(line, sizeof(line), file);

    sscanf_s(line, "%d; %d; %d; %d; %d", &subject.code, &trash, &trash, &trash, &subject.gender);

    return subject;
}

Data readDataBase(FILE* file) {
    Data data;
    char line[1000];
    double trash;

    //retire les titres de colonne  
    fgets(line, sizeof(line), file);

    //lit dans le file
    fgets(line, sizeof(line), file);

    sscanf_s(line, "%lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf, %lf", &trash, &trash, &trash, &trash, &trash, &trash, &trash, &trash, &trash, &trash, &data.userAccX, &data.userAccY, &data.userAccZ);
    return data;
}

void writeTilteVacc(FILE* file) {
    for (int i = 0; i < TIME_FOR_A_MIN; i++)
        fprintf(file, "; %s", "Vacc");
}

void defineMouvement(char typeMouvement[], char mouvement[]) {
    if (strcmp(typeMouvement, "dws") == 0)
        strcpy_s(mouvement, 10, "downstair");
    else {
        if (strcmp(typeMouvement, "jog") == 0)
            strcpy_s(mouvement, 10, "jogging");
        else {
            if (strcmp(typeMouvement, "sit") == 0)
                strcpy_s(mouvement, 10, "sit down");
            else {
                if (strcmp(typeMouvement, "std") == 0)
                    strcpy_s(mouvement, 10, "stand up");
                else {
                    if (strcmp(typeMouvement, "ups") == 0)
                        strcpy_s(mouvement, 10, "upstairs");
                    else {
                        if (strcmp(typeMouvement, "wlk") == 0)
                            strcpy_s(mouvement, 10, "walking");
                    }
                }
            }
        }
    }
}