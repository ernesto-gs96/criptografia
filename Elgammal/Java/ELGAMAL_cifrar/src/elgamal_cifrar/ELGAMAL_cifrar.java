package elgamal_cifrar;

import java.util.Scanner;

public class ELGAMAL_cifrar {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long B,P,k,ge,N1,N2,mensaje;
        
        //PEDIR CLAVES
        System.out.println("CIFRAR CON ELGAMAL");
        
        System.out.println("Ingrese B del usuario destino: ");
        B = entrada.nextInt();
        
        System.out.println("Ingrese P del usuario destino: ");
        P = entrada.nextInt();
        
        System.out.println("Ingrese ge del usuario destino: ");
        ge = entrada.nextInt();
        
        System.out.println("1 < k < "+(P-1));
        System.out.println("Ingrese k: ");
        k = entrada.nextInt();
        
        System.out.println("Ingrese mensaje a cifrar: ");
        mensaje = entrada.nextInt();
        
        System.out.println("\n\nCIFRANDO...");
        System.out.println(ge+"^"+k+" mod "+P);
        N1 = cifrar(ge,k,P);
        System.out.println("N1: "+N1);
        
        System.out.println("\n"+mensaje+" * "+B+"^"+k+" mod "+P);
        N2 = cifrar2(B,k,P,mensaje);
        System.out.println("N2: "+N2);
        
    }
    
     public static long cifrar(long msj, long e, long n){
        
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
     
    public static long cifrar2(long b2, long e, long n, long msj){
        
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
