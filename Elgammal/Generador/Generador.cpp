#include <stdio.h>
#include <stdlib.h>

unsigned long long pot_mod(unsigned long long, unsigned long long, unsigned long long);
void lista_primos(unsigned long long);

unsigned long long iglobal=0,liprimos[100];

main(){
	
	unsigned long long p,p1,q,e,ge,i,j,x,y,aux,aux1;
	unsigned long long primos[100], primos2[100], potencia[100], generadores[100];
	FILE* fichero;
	fichero = fopen("primos.txt", "r");
	
	printf("ENCONTRAR NUMERO GENERADOR");
	printf("\nIngrese p: ");
	scanf("%llu",&p);
 	
 	p1=p-1;
 	aux=p1;
 	
 	i=2;
    j=0;
 	while(p1>1)
    {
       if(p1%i==0)
       {
          p1=p1/i;
          primos[j]=i;
          j++;
          i=2;
       }
       else
          i++;
    } 
    
	y=0;
	primos2[y]=primos[y];
	potencia[y++]=1;
	
	for(i=1;i<j;i++){
		for(x=0;x<y;x++){
			if(primos[i]==primos2[x])
				potencia[x]=potencia[x]+1;
			else
				if(x==y-1){
					primos2[y]=primos[i];
					potencia[y++]=1;
					break;
				}
		}
	}
	
	printf("\n\n%llu = ",aux);
	
	for(x=0;x<y;x++)
    	printf("%llu ^ %llu * ",primos2[x],potencia[x]);
	
	//lista_primos(p);
	//printf("\n\nLista con primos que probar generada");
	
	x=0;
	
	for(i=2;i<p;i++){
		for(j=0;j<y;j++){
			aux1=aux/primos2[j];
			if(pot_mod(i,aux1,p)!=1)
				if(j==y-1)
					generadores[x++]=i-1;
			else
				break;
		}
	}
	
	printf("\n\nLos generadores son: ");
	for(i=0;i<x;i++)
    	printf("%llu, ",generadores[i]);
	
	
}


void lista_primos(unsigned long long num){
	
	unsigned long long i,j,cot;
	
	for(i=1;i<num+1;i++){
			cot=0;
		for(j=1;j<i+1;j++){
		    if(i%j==0){
		    	cot++;
			}
		}
		if(cot==2) {
		    liprimos[iglobal]=j-1;
		}
	}
	
}

unsigned long long pot_mod(unsigned long long msj, unsigned long long e, unsigned long long n){
	
	unsigned long long ci=1;
	unsigned long long xp=msj%n;
	
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	
	return ci;
}







