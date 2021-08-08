#include <stdio.h>
#include <math.h>
#include <string.h>

unsigned long long mcd(unsigned long long,unsigned long long);
unsigned long long inv(unsigned long long,unsigned long long);
unsigned long long cifrado(unsigned long long,unsigned long long,unsigned long long);
unsigned long long cifrado2(unsigned long long,unsigned long long,unsigned long long,unsigned long long);
//double decifrado(int,int,int);


main(){
	
	unsigned long long p,ge,a1,b1,a2,b2,des;
	unsigned long long  msj,de;
	unsigned long long i=0,j=0,h=0,k;
	unsigned long long y1,y2;
	
	printf("DECIFRADO");
	printf("\nIngrese y1: ");
	scanf("%llu",&y1);
	
	printf("\nIngrese y2: ");
	scanf("%llu",&y2);
	
	printf("\nIngrese p: ");
	scanf("%llu",&p);
	
	printf("\nIngrese clave privada a1: ");
	scanf("%llu",&a1);
	
	des=cifrado2(y1,p-a1-1,p,y2);
	
	printf("\nmsj=%llu",des);
	
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

unsigned long long cifrado2(unsigned long long b2, unsigned long long e, unsigned long long n,unsigned long long msj){
	
	unsigned long long ci=1;
	unsigned long long xp=b2%n;
	
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	
	ci=(ci*msj)%n;
	
	return ci;
}
