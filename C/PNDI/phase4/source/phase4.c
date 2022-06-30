#include <stdio.h>
#include <string.h>
#include <math.h>

#include "../../phase2/source/classificationPerformances.h"

#define TEST_SET_PATH "../../phase1/testSet.csv"
#define FIMODEL_PATH "../../phase3/fimodel.csv"

#define TIME_ONE_MINUTE 600
#define NB_TESTS 45
#define NB_MOVEMENTS 6

#define MAX 10000

typedef struct model Model;
struct model{
    int type;
    double averages[TIME_ONE_MINUTE];
    double stds[TIME_ONE_MINUTE];
    double globalAvg;
};

void readModel(FILE* file, Model models[]);
int defineMovement (char mouvement[]);
int decomposition(char line[], double data[]);
//estimation du mouvement
int estimatedAverage(Model models[], double data[]);
int estimatedStandartDevition(Model models[], double data[]);
int estimatedUsingGlobalAverage(Model models[],double data[]);

int identifyMovement(int estimateAverage, int estimatedStandartDevition, int estimatedUsingGlobalAverage);
void showMovementNum();

void main(void){
    FILE* fiModel;
    FILE* testSet;

    fopen_s(&fiModel, FIMODEL_PATH, "r");
    fopen_s(&testSet, TEST_SET_PATH, "r");

    if(fiModel == NULL || testSet == NULL){
        printf("erreur ouverture des fichiers");
    }
    else{

        int realClasses[NB_TESTS];
        int estimatedClasses[NB_TESTS];

        //stoc fiModel dans un tableau
        Model models[NB_MOVEMENTS];
        readModel(fiModel, models);

        char line[10000];
        int iTest = 0;
        //passe la ligne des titres
        fgets(line, sizeof(line), testSet);
        while(iTest < NB_TESTS && !feof(testSet)){
            double data[TIME_ONE_MINUTE];
            //récupère la ligne de Vacc
            fgets(line, sizeof(line), testSet);
            realClasses[iTest] = decomposition(line, data);
            
            //estimation sur la moyenne
            int estimateAverage = estimatedAverage(models, data);
            //estimation sur l'écart type
            int estimateStandartDeviavtion = estimatedStandartDevition(models, data);
            //estimation sur la moyenne globale
            int estimateUsingGeneraleAverage = estimatedUsingGlobalAverage(models, data);
            
            //identifie le mouvement sur base des 3 estimations
            estimatedClasses[iTest] = identifyMovement(estimateAverage, estimateStandartDeviavtion, estimateUsingGeneraleAverage);
            iTest++;
        }

        displayAccuracy(realClasses, estimatedClasses, iTest);
        printf("\n\n");
        showMovementNum();
        printf("\n\n");
        displayResultsByClass(realClasses, estimatedClasses, iTest);
        printf("\n\n");
        displayConfusionMatrix(realClasses, estimatedClasses, iTest);

        fclose(fiModel);
        fclose(testSet);
    }
}

void readModel(FILE* file, Model models[]){
    char line [10000];
    char* token;
    char* nextToken;

    //passe la ligne des titres
    fgets(line, sizeof(line), file);

    int i = 0;
    while(!feof(file) && i < NB_MOVEMENTS){
        //récupère la ligne des moyennes
        fgets(line, sizeof(line), file);
        token = strtok_s(line, ";", &nextToken);
        //sauvegarde le type du mouvementè
        models[i].type = defineMovement(token);

        //récupère les Vacc moyenne
        int iVacc = 0;
        token = strtok_s(NULL, ";", &nextToken);
        while(iVacc < TIME_ONE_MINUTE && token != NULL){
            double vacc;
            sscanf_s(token, "%lf", &vacc);
            models[i].averages[iVacc] = vacc;
            token = strtok_s(NULL, ";", &nextToken);
            iVacc++;
        }

        //récupère les ecarts types et passe le titre
        fgets(line, sizeof(line), file);
        token = strtok_s(line, ";", &nextToken);
        //passe le mouvement
        token = strtok_s(NULL, ";", &nextToken);
        int iStds = 0;
        token = strtok_s(NULL, ";", &nextToken);
        while(iStds < iVacc && token != NULL){
            double vacc;
            sscanf_s(token, "%lf", &vacc);
            models[i].stds[iVacc] = vacc;
            token = strtok_s(NULL, ";", &nextToken);
            iStds++;
        }

        ///récupère la vacc moyenne
        fgets(line, sizeof(line), file);
        //passe le mouvement
        token = strtok_s(line, ";", &nextToken);
        token = strtok_s(NULL, ";", &nextToken);
        //transforme en double
        double vacc;
        sscanf_s(token, "%lf", &vacc);
        models[i].globalAvg = vacc;
        i++;
    }
}

void showMovementNum(){
    printf("downstair = %d / ", defineMovement("downstair"));
    printf("jogging = %d / ", defineMovement("jogging"));
    printf("sit down = %d / ", defineMovement("sit down"));
    printf("stand up = %d / ", defineMovement("stand up"));
    printf("upstairs = %d / ", defineMovement("upstairs"));
    printf("walking = %d / ", defineMovement("walking"));
}

int decomposition(char line[], double data[]){
    char* token;
    char* nextToken;
    int type;

    //récupère le mouvement
    token = strtok_s(line, ";", &nextToken);
    type = defineMovement(token);

    //passe le genre et l'index
    token = strtok_s(NULL, ";", &nextToken);
    token = strtok_s(NULL, ";", &nextToken);  

    int i = 0;
    //récupère les vacc
    token = strtok_s(NULL, ";", &nextToken);
    while(i < TIME_ONE_MINUTE && token != NULL){
        double vacc;
        sscanf_s(token, "%lf", &vacc);
        data[i] = vacc;
        token = strtok_s(NULL, ";", &nextToken);
        i++;
    }
    return type;
}
//movement stocké sous un chaine de caractère 
//donc doit être converti en nomber
int defineMovement (char movement[]) {
    if (strcmp(movement, "downstair") == 0)
        return 1;
    if (strcmp(movement, "jogging") == 0)
        return 2;
    if (strcmp(movement, "sit down") == 0)
        return 3;
    if (strcmp(movement, "stand up") == 0)
        return 4;
    if (strcmp(movement, "upstairs") == 0)
        return 5;
    return 6;
}

//modules d'estimation sur un critère
int estimatedAverage(Model models[], double data[]){
    double standartDevMin = MAX;
    int estimatedMovement;
    for(int iMovement = 0; iMovement < NB_MOVEMENTS; iMovement++){
        double strdDev = 0;
        for(int i = 0; i < TIME_ONE_MINUTE; i++){
            strdDev += pow(models[iMovement].averages[i] - data[i], 2); 
        }
        strdDev = sqrt(strdDev);

        //regarde si la deviation est inférieur aux précedente
        if(strdDev < standartDevMin){
            estimatedMovement = iMovement+1;
            standartDevMin = strdDev;
        }
    }   
    return estimatedMovement; 
}

int estimatedStandartDevition(Model models[], double data[]){
    double standartDevMin = MAX;
    int estimatedMovement;
    for(int iMovement = 0; iMovement < NB_MOVEMENTS; iMovement++){
        double strdDev = 0;
        for(int i = 0; i < TIME_ONE_MINUTE; i++){
            strdDev += pow(models[iMovement].stds[i] - data[i], 2); 
        }
        strdDev = sqrt(strdDev);

        //regarde si la deviation est inférieur aux précedente
        if(strdDev < standartDevMin){
            estimatedMovement = iMovement+1;
            standartDevMin = strdDev;
        }
    }   
    return estimatedMovement; 
}

int estimatedUsingGlobalAverage(Model models[],double data[]){
    double vaccMiddle;
    int estimatedMovement;
    //calcule la moyenne de data
    double vaccTot = 0;
    int nbVacc = 0;

    for(int i = 0; i < TIME_ONE_MINUTE; i++){
        vaccTot += data[i];
        nbVacc++;
    }
    vaccMiddle = vaccTot / nbVacc;

    double diffMin = MAX;
    for(int i = 0; i < NB_MOVEMENTS; i++){
        double diff = models[i].globalAvg - vaccMiddle;
        if(diff < 0)
            diff = -diff;
        if(diff < diffMin){
            estimatedMovement = i+1;
            diffMin = diff;
        }
    }
    return estimatedMovement;
}

int identifyMovement(int estimatedAverage, int estimatedStandartDevition, int estimatedUsingGlobalAverage){
    //regarde si l'estimation estimatedStandartDevition apparait 2 fois
    if(estimatedAverage == estimatedStandartDevition || estimatedUsingGlobalAverage == estimatedStandartDevition)
        return estimatedStandartDevition;

    //si estimatedStandartDevition, soit les 2 autres estimateurs sont égaux,
    //soit on prend le premier estimateur par défault
    //dans les 2 cas on prend le premier estimateur 
    return estimatedAverage;
}