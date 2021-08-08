package elgamal_decifrar;

import java.util.Scanner;

public class ELGAMAL_decifrar {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long A,B,P,k,ge,N1,N2,mensaje,mensaje_decifrado;
        
        //PEDIR CLAVES
        System.out.println("CIFRAR CON ELGAMAL");
        
        System.out.println("Ingrese P: ");
        P = entrada.nextInt();
        
        System.out.println("Ingrese A (llave privada): ");
        A = entrada.nextInt();
        
        System.out.println("Ingrese N1: ");
        N1 = entrada.nextInt();
        
        System.out.println("Ingrese N2: ");
        N2 = entrada.nextInt();
        
        
        System.out.println("\nDECIFRANDO...");
        System.out.println(N1+"^("+P+" - "+A+" - 1) ("+N2+") mod "+P);
        mensaje_decifrado = decifrado(N1,(P-A-1),P,N2);
        System.out.println("Mensaje decifrado: "+mensaje_decifrado);
       
    }
    
    public static long decifrado(long b2, long e, long n, long msj){
        
        long ci=1;
	long xp=b2%n;
	
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
    
}
