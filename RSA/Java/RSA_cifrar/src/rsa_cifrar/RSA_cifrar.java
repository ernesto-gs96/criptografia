package rsa_cifrar;

import static java.lang.Boolean.TRUE;
import java.util.Scanner;

public class RSA_cifrar {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long n,e,mensaje,mensaje_cifrado;
        
        //PEDIR CLAVES
        System.out.println("CIFRAR CON RSA");
        System.out.println("\nIngrese n del usuario destino: ");
        n = entrada.nextInt();
        
        System.out.println("Ingrese e del usuario destino: ");
        e = entrada.nextInt();
        
        System.out.println("Ingrese mensaje a cifrar: ");
        mensaje = entrada.nextInt();
        
        System.out.println("\n\nCIFRANDO...");
        System.out.println(mensaje+"^"+e+" mod "+n);
        mensaje_cifrado = cifrar(mensaje,e,n);
        System.out.println("Mensaje cifrado: "+mensaje_cifrado);
        
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
    
}
