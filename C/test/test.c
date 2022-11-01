#include <stdio.h>

int suite(int m, int c, int a, int x0, int* result);

void main (){
// suite pseudo-aléatoire
    int x0 = 5;
    int a = 13; 
    int m = 36;
    int c = 7;

    //changer la taille de résult pour quelle soit ou moins égale à m
    int result[50];
    int periode = suite(m, c, a, x0, result);

    for(int i = 0; i < periode; i++){
        printf("X%d : %d  \t Y%d : %.1lf\n", i+1, result[i], i+1, (double)result[i] / m * 10);
    }
    printf("\nperiode = %d\n", periode);

//monte-carlo
/*
    int cMin = 0;
    int cMAx = 17;
    int limA = 2;
    int limB = 7;

    int suite1[36];
    suite(36, 7, 13, 5, result);
    int suite2[36];
    suite(36, 7, 13, 5, result);

    double xk = limA + (limB - limA) * (suite1[0] / m);
    double yk = cMin + (cMAx - cMin) * (suite2[0] / m);
    
    printf("%lf - %lf", xk, yk);
    printf("\n");
*/
}

int suite(int m, int c, int a, int x0, int* result){

    int xn = x0;
    int i = 0;
    do{
        xn = (a * xn + c) % m;
        result[i] = xn;
        i++;
    }while(xn != x0);
    return i;
}