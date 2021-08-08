package elgamal;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Scanner;

public class ELGAMAL {

    public static void main(String[] args) {
    
        Scanner entrada = new Scanner(System.in);
        long P,Q,n,phi,e,d,ge,A,B;
        boolean puerta = TRUE;
        
        //PEDIR P
        do{
            if(puerta==FALSE)
                System.out.println("\n¡P NO VALIDA!");
            
            System.out.println("Ingrese P (primo): ");
            P = entrada.nextInt();
            
            puerta=bus_primos(P);
            
        }while(puerta!=TRUE);
        
        //CALCULAR GENERADOR
        
        
        //******
        System.out.println("Ingrese generador: ");
        ge = entrada.nextInt();
        
        System.out.println("1 < A < "+(P-1));
        System.out.println("Ingrese A: ");
        A = entrada.nextInt();
        
        System.out.println("\nCALCULANDO B...");
        System.out.println(ge+"^"+A+" mod "+P);
        B = cal_b(ge,A,P);
        System.out.println(B);
        
        System.out.println("\nCLAVES PUBLICAS ("+ge+","+P+","+B+")");
	
	System.out.println("CLAVE PRIVADA("+A+")");
        
        
        
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
    
    //CODIGO REUTILIZADO DE RSA CIFRAR
    public static long cal_b(long msj, long e, long n){
        
        long ci=1;
	long xp=msj%n;
	
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	
	return ci;
    }
    
}
