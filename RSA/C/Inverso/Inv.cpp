#include <stdio.h>

main(){
	
	unsigned long long a,b,x,m;
	
	printf("Ingresa a: ");
	scanf("%llu",&a);
	
	printf("\nIngresa m: ");
	scanf("%llu",&m);
	
	for(b = 0; b < m; b++)
    {
        x = (a * b) % m;
        if(x == 1)
            printf("%llu", b);
    }
	
}
