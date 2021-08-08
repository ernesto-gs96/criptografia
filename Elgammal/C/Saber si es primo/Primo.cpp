#include <stdio.h>

unsigned long long mcd(unsigned long long,unsigned long long);

main(){
	
	unsigned long long pri,i,j=0;
	
	printf("BUSCADOR DE NUMEROS PRIMOS");
	printf("\nIngrese un numero: ");
	scanf("%llu",&pri);
	
	printf("\nEs divisible entre: ");
	for(i=1;i<=pri;i++){
		if(pri%i==0){
			printf("\n%llu",i);
			j++;
		}
			
	}
	
	if(j==2)
		printf("\n\n%llu es primo",pri);
	else
		printf("\n\n%llu no es primo",pri);
	
	
}
