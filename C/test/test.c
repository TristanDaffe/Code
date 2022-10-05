#include <stdio.h>

void main (){
    int x0 = 7;
    int a = 7;
    int m = 18;
    int c = 7;

    int xn = x0;
    // for(int i = 0; i < m; i++){
    //     xn = (a * xn + c) % m;
    //     printf("X%d => %d \n", i+1, xn);
    // }

    int i = 0;
    do{
        xn = (a * xn + c) % m;
        printf("X%d => %d \n", i+1, xn);
        i++;
    }while(xn != x0);

    printf("\nPériode : %d \n\n", i);
}