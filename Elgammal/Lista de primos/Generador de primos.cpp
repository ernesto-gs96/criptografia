#include <stdio.h>
#include <stdlib.h>

main(){
	
	unsigned long long i,j,num,cot;
	FILE* fichero;     
    fichero = fopen("primos.txt", "wt");
    
	printf("Generador de primos");
	
	printf("\nIntroduce un numero: ");
	scanf("%llu",&num);
	
	printf("\n\nGenerando primos....");
	
	//100,000 MAX
	for(i=1;i<num+1;i++){
			cot=0;
		for(j=1;j<i+1;j++){
		    if(i%j==0){
		    	cot++;
			}
		}
		if(cot==2) {
		    fprintf (fichero,"%llu\n",j-1);
		}
	}
		
    fclose(fichero);     
	printf("\nProceso completado");
}






