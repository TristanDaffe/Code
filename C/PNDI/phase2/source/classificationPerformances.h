#include <stdio.h>
#include <stdlib.h>

#define NB_MAX_CLASSES 20

/*=====structures=======*/

typedef struct classes Classes;
struct classes {
	int totCorrect;
	int total;
};

/*=====prototypes=======*/

//displayResultsByClass
void displayResultsByClass(int realClasses[], int estimatedClasses[], int nbTests);
void calculResult(int realClasses[], int estimatedClasses[], int nbTests, Classes result[], int nbClasses);

//displayAccuracy
void displayAccuracy(int realClasses[], int estimatedClasses[], int nbTests);
int countTot(int realClasses[], int estimatedClasses[], int nbTests);

//displayConfusionMatrice
void displayConfusionMatrix(int realClasses[], int estimatedClasses[], int nbTests);
int maxMouvement(int realClasses[], int estimatedClasses[], int nbTests);
int** createMatrix( int realClasses[], int estimatedClasses[], int nbTests, int nbClasses);
void displaySplitLine(int nbClasses);

//autre 
double perc(int num, int denom);

/*=====definitions=======*/

void displayResultsByClass(int realClasses[], int estimatedClasses[], int nbTests) {
	int nbClasses = maxMouvement(realClasses, estimatedClasses, nbTests);
	Classes* result = (Classes*) calloc(nbClasses, sizeof(Classes));
	calculResult(realClasses, estimatedClasses, nbTests, result, nbClasses);

	printf("\tclasse \t|\tbien classes\t|\ttotal\t|\tpercentage \n");
	printf("---------------------------------------------------------------------------\n");
	for(int i = 0; i < nbClasses; i++) {
		printf("\t %d\t|\t\t%d \t| \t %d \t| \t %.2lf%% \n", i+1, result[i].totCorrect, result[i].total, perc(result[i].totCorrect, result[i].total));
	}
}
void calculResult(int realClasses[], int estimatedClasses[], int nbTests, Classes result[], int nbClasses) {
	//traite les tableaux 
	for(int i = 0; i < nbTests; i++){
		result[realClasses[i]-1].total++;
		if(realClasses[i] == estimatedClasses[i])
		result[realClasses[i]-1].totCorrect++;
	}
}

void displayAccuracy(int realClasses[], int estimatedClasses[], int nbTests) {
	int tot = countTot(realClasses, estimatedClasses, nbTests);
	printf("L'accuracy est de %.2lf%%\n", perc(tot, nbTests));
}
int countTot(int realClasses[], int estimatedClasses[], int nbTests) {
	int totCorrect = 0;
	for (int i = 0; i < nbTests; i++) {
		if (realClasses[i] == estimatedClasses[i])
			totCorrect++;
	}
	return totCorrect;
}

void displayConfusionMatrix(int realClasses[], int estimatedClasses[], int nbTests){
	int nbClasses = maxMouvement(realClasses, estimatedClasses, nbTests);
	int** matrix = createMatrix(realClasses, estimatedClasses, nbTests, nbClasses);
	
	//affiche la ligne de titre
	printf("\t\t|");
	for(int iColumn = 0; iColumn < nbClasses; iColumn++)
		printf("\t%d \t|", iColumn+1);
	printf("\n");
	displaySplitLine(nbClasses);
	//affiche la matrice
	for(int iLine = 0; iLine < nbClasses; iLine++){
		printf("\t%d\t|", iLine+1);
		for(int iColumn = 0; iColumn < nbClasses; iColumn++)
			printf("\t%d \t|", matrix[iLine][iColumn]);
		printf("\n");
		displaySplitLine(nbClasses);
	}

}
int maxMouvement(int realClasses[], int estimatedClasses[], int nbTests) {
	int maxClasses = 0;
	for (int i = 0; i < nbTests; i++) {
		if (realClasses[i] > maxClasses || estimatedClasses[i] > maxClasses)
			maxClasses = realClasses[i] > estimatedClasses[i] ? realClasses[i] : estimatedClasses[i];
	}
	return maxClasses;
}
int** createMatrix( int realClasses[], int estimatedClasses[], int nbTests, int nbClasses) {
	int** matrix = (int**) calloc(nbClasses, sizeof(int*));
	for(int i = 0; i < nbClasses; i++)
		matrix[i] = (int*) calloc(nbClasses, sizeof(int*));
	for(int i = 0; i < nbTests; i++){
		matrix[realClasses[i]-1][estimatedClasses[i]-1] ++;
	}
	return matrix;
}
void displaySplitLine(int nbClasses) {
	printf("-");
	for(int j = 0; j < nbClasses+1; j++){
		for (int i = 0; i < 15; i++)
			printf("-");
		printf("|");
	}
	printf("\n");
}

double perc(int num, int denom){
	if(denom != 0)
		return (double)num / denom * 100;
	else
		return 0;
}