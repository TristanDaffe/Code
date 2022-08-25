#include "classificationPerformances.h"

void main() {

	int realClasses[20] = { 5, 2, 5, 3, 1, 3, 2, 4, 6, 7, 8, 9, 10, 11, 12, 13 ,14, 15 , 20};
	int estimateClasses[20] = { 5, 5, 1, 2, 1, 3, 2, 4, 10, 10, 15, 1, 17 ,18 ,19 ,15, 6, 13, 15, 20};
	
	displayResultsByClass(realClasses, estimateClasses, 8);
	printf("\n\n");
	displayAccuracy(realClasses, estimateClasses, 8);
	printf("\n\n");
	displayConfusionMatrix(realClasses, estimateClasses, 8); 
}
