package rsa;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;

/**
 *
 * @author Ernes
 */
public class RSA {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long P,Q,n,phi,e,d;
        boolean puerta = TRUE;
        
        //PEDIR P
        do{
            if(puerta==FALSE)
                System.out.println("\n¡P NO VALIDA!");
            
            System.out.println("Ingrese P (primo): ");
            P = entrada.nextInt();
            
            puerta=bus_primos(P);
            
        }while(puerta!=TRUE);
        
        //PEDIR Q
        do{
            if(puerta==FALSE)
                System.out.println("\n¡Q NO VALIDA!");
            
            System.out.println("\nIngrese Q (primo): ");
            Q = entrada.nextInt();
            
            puerta=bus_primos(Q);
            
        }while(puerta!=TRUE);
        
        System.out.println("\nCALCULANDO n");
        n = P * Q;
        System.out.println(P+" * "+Q+" = "+n);
        
        System.out.println("\nCALCULANDO phi");
        phi = (P-1) * (Q-1);
        System.out.println((P-1)+" * "+(Q-1)+" = "+phi);
        
        //PROPONER e
        System.out.println("\nLos siguientes números son validos para e:");
        bus_e(phi);
        
        
        do{
            if(puerta==FALSE)
                System.out.println("\n¡e NO VALIDA!");
            
            System.out.println("\n\n 1 < e < "+phi);
            System.out.println("Ingrese e: ");
            e = entrada.nextInt();
            
            //CONDICION 1
            if(e>1 && e<phi)
                puerta = TRUE;
            else
                puerta = FALSE;
            
        }while(puerta!=TRUE);
        
        System.out.println("\nCalculando d");
        d = inv(e,phi);
        System.out.println("inv("+e+" "+phi+") = "+d);
        
        System.out.println("\n\nSUS LLAVES PUBLICAS SON:");
	System.out.println("e = "+e+"   n = "+n);
	
	System.out.println("\n\nSUS LLAVES PUBLICAS SON:");
	System.out.println("d = "+d+"   n = "+n);
        
        
        
    }
    
    public static boolean bus_primos(long numero){
        
        int i, j=0;
        boolean puerta;
        
        //System.out.println("\nEs divisible entre: ");
	for(i=1;i<=numero;i++){
		if(numero%i==0){
			//System.out.println(i);
			j++;
		}	
	}
	
	if(j==2){
            puerta = TRUE;
            System.out.println(numero+" es primo");
        }
        else{
            puerta = FALSE;
            System.out.println(numero+" no es primo");
        }
        
        return puerta;
    }
    
    public static long mcd(long a, long b){
        
        while(a != b){
        if(a>b)
            a = a-b;
        else
            b = b-a;
    }
    return a;
    
    }
    
    public static void bus_e(long phi){
        
        long i,j = 0,aux = 0;
        
        for(i=2;i<phi;i++){
		aux=mcd(phi,i);
		if(aux==1){
                    if(j==10){
                        System.out.println("\n");
                        j++;
                    }
                    System.out.print(i+" ");
		}
	}
        
    }
    
    public static long inv(long a, long m){
        
        long b,x;
        
        for(b = 0; b < m; b++)
        {
            x = (a * b) % m;
            if(x == 1)
                    return b;
        }
        
        return b;
    }
    
}
