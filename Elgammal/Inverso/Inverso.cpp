#include <stdio.h>

main(){
	
	unsigned long long Phi,e;
	unsigned long long b,x;
	
	printf("INVERSO");
	
	printf("\nIngrese e: ");
	scanf("%llu",&Phi);
	
	printf("\nIngrese phi: ");
	scanf("%llu",&e);
    
    for(b = 0; b < e; b++)
    {
        x = (Phi * b) % e;
        if(x == 1)
        	printf("\n\nEl inverso es: %llu",b);
    }
	
}
