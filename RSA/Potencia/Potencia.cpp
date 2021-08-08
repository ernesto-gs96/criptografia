#include <stdio.h>

main(){
	
	unsigned long long msj,e,n;
	unsigned long long ci=1,xp;
	
	printf("CIFRAR O DESIFRAR");
	printf("\n\nc = msj^e mod n");
	printf("\n\nmsj = c^d mod n\n");
	printf("\nIngrese el mensaje o mensaje cifrado: ");
	scanf("%llu",&msj);
	
	printf("\nIngrese e o d: ");
	scanf("%llu",&e);
	
	printf("\nIngrese n: ");
	scanf("%llu",&n);
	
	xp=msj%n;
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	
	printf("\nMensaje cifrado: %d",ci);
}
