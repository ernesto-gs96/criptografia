#include <stdio.h>

main(){
	
	unsigned long long a,a1,b,b1;
	
	printf("mcd(a,b)");
	printf("\n\nIngrese a: ");
	scanf("%llu",&a);
	
	printf("\nIngrese b: ");
	scanf("%d",&b);
	a1=a;
	b1=b;
	
	while(a != b){
        if(a>b)
            a = a-b;
        else
            b = b-a;
    }
    
    printf("\nmcd(%llu,%llu)=%llu",a1,b1,a);
}
