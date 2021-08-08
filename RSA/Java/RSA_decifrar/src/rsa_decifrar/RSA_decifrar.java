package rsa_decifrar;

import java.util.Scanner;

public class RSA_decifrar {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long d,n,e,mensaje,mensaje_cifrado;
        
        System.out.println("Ingrese d: ");
        d = entrada.nextInt();
        
        System.out.println("Ingrese n: ");
        n = entrada.nextInt();
        
        System.out.println("Ingrese mensaje cifrado: ");
        mensaje_cifrado = entrada.nextInt();
        
        System.out.println("\n\nDECIFRANDO...");
        System.out.println(mensaje_cifrado+"^"+d+" mod "+n);
        mensaje = decifrar(mensaje_cifrado,d,n);
        System.out.println("Mensaje decifrado: "+mensaje);
        
    }
    
    public static long decifrar(long msj, long e, long n){
        
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
