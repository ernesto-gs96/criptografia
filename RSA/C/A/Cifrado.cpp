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
	
	printf("CIFRADO");
	printf("\nIngrese n del receptor: ");
	scanf("%llu",&n);
	
	printf("\n\nIngrese b del receptor: ");
	scanf("%llu",&e);
	
	printf("\n\nIngrese el mensaje a cifrar: ");
	scanf("%llu",&msj);
	
	c=cifrado(msj,e,n);
	
	printf("\n\nc = msj^e mod n");
	printf("\nMensaje cifrado: %llu",c);
	
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
