#include <stdio.h>

void suite(int m, int c, int a, int x0, int* result);


void main (){
// suite pseudo-aléatoire
    int x0 = 5;
    int a = 13; 
    int m = 36;
    int c = 7;

    int result[36];
    suite(m, c, a, x0, result);
    // for(int i = 0; i < m; i++){
    //     xn = (a * xn + c) % m;
    //     printf("X%d => %d \n", i+1, xn);
    // }

    // int xn = x0;
    // int i = 0;
    // do{
    //     xn = (a * xn + c) % m;
    //     printf("X%d => %d \n", i+1, xn);
    //     i++;
    // }while(xn != x0);

    // printf("\nPeriode : %d \n\n", i);

//monte-carlo
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

}

void suite(int m, int c, int a, int x0, int* result){

    int xn = x0;
    int i = 0;
    do{
        xn = (a * xn + c) % m;
        result[i] = xn;
        i++;
    }while(xn != x0);
}