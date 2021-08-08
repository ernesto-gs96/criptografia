#include <stdio.h>
#include <math.h>
#include <string.h>

unsigned long long mcd(unsigned long long,unsigned long long);
unsigned long long inv(unsigned long long,unsigned long long);
unsigned long long cifrado(unsigned long long,unsigned long long,unsigned long long);
//double decifrado(int,int,int);


main(){
	
	unsigned long long p,q; //Son numeros primos
	unsigned long long n,e,Phi,d,aux;
	unsigned long long  oe[100];
	unsigned long long  msj,c,de;
	unsigned long long i=0,j=0,k=0;
	
	printf("GENERACION DE CLAVES USUARIO B");
	printf("\nIngrese p: ");
	scanf("%llu",&p);
	
	printf("Ingrese q: ");
	scanf("%llu",&q);
	
	printf("\nn=p*q \nGenerando n.........");
	n=p*q;
	
	printf("\n\nPhi=(p-1)*(q-1) \nGenerando Phi........");
	Phi=(p-1)*(q-1);
	
	printf("\n\nmcd(Phi,e)=1 \nCalculando posibles valores para e.........");
	for(i=2;i<Phi;i++){
		aux=mcd(Phi,i);
		if(aux==1){
			oe[j++]=i;
		}
	}
	
	printf("\nLos siguientes valores son validos para e:\n");
	for(i=0;i<j;i++){
		printf("%llu   ",oe[i]);
		k++;
		if(k>=10){
			printf("\n");
			k=0;	
		}
	}
	
	printf("\n\nIngrese e: ");
	scanf("%llu",&e);
	
	printf("\nd=inv(Phi,e)\nCalculando d..........");
	d=inv(e,Phi);
	
	printf("\n\nSUS LLAVES PUBLICAS SON:");
	printf("\nB=%llu n=%llu",e,n);
	
	printf("\n\nSUS LLAVES PRIVADAS SON:");
	printf("\nA=%llu n=%llu",d,n);
}

//Calcular maximo comun divisor
unsigned long long mcd(unsigned long long a,unsigned long long b){
	
	while(a != b){
        if(a>b)
            a = a-b;
        else
            b = b-a;
    }
    return a;
}

//Calcular inverso multiplicativo euclides extendido
unsigned long long inv(unsigned long long a, unsigned long long m){
    
    unsigned long long b,x;
    
    for(b = 0; b < m; b++)
    {
        x = (a * b) % m;
        if(x == 1)
        	return b;
    }
    
 
}

unsigned long long cifrado(unsigned long long msj, unsigned long long e, unsigned long long n){
	
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
