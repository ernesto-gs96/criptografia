package curva_eliptica;

import java.util.*;

public class Curva_eliptica {
    
    public static long pot2(long a, long e, long n,long b){
	long ci=1;
	long xp=a%n;
	
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	ci=(ci*b)%n;
	return ci;
    }
    
    public static long pot(long a, long e, long n){
	long ci=1;
	long xp=a%n;
	
	while(e>0){
	    if((e%2)!=0){
	        ci=(ci*xp)%n;
	    }
	    xp=(xp*xp)%n;
	    e=e/2;
	}
	
	return ci;
    }
	
    
    public static long obtenerInverso(long a,long m)
    {
        long c1 = 1;
        long c2 = -(m/a); //coeficiente de a y b respectivamente
        long t1 = 0;
        long t2 = 1; //coeficientes penultima corrida
        long r = m % a; //residuo, asignamos 1 como condicion de entrada 
        long x=a,y=r,c;
        while(r!=0)
        {
        c = x/y;//cociente
        r = x%y;//residuo
        //guardamos valores temporales de los coeficientes
        //multiplicamos los coeficiente por -1*cociente de la division
        c1*=-c;
        c2*=-c;
        //sumamos la corrida anterior
        c1+=t1;
        c2+=t2;
        //actualizamos corrida anterior
        t1=-(c1-t1)/c;
        t2=-(c2-t2)/c;
        x=y;
        y=r;
        }
      if(x==1)//residuo anterior es 1 , son primos relativos y el inverso existe
          return t2;
      else
            System.out.println("No hay inverso");
      return 0;
    }
    
    public static long condiciones(long p, long a, long b){
        
        long i,aux,cont=0;
        
        //PASO 1 SABER SI P ES PRIMO
        for(i=1;i<=p;i++){
            aux = p % i;
            if(aux==0)
                cont++;
        }
        
        if(cont==2)
            System.out.println("\n"+p+" es primo");
        else{
            System.out.println("\n"+p+" no es primo");
            return 0;
        }
        
        
        //PASO 2 SABER SI P MOD 4 = 1
        aux = p % 4;
        
        if(aux==1)
            System.out.println(p+" mod 4 = 1");
        else{
            System.out.println(p+" mod 4 != 1");
            return 0;
        }
        
        
        //PASO 3 SABER SI A + B MOD 4 =1
        aux = (a+b) % 4;
        if(aux==1)
            System.out.println(a+"+"+b+" mod 4 = 1");
        else{
            System.out.println(a+"+"+b+" mod 4 != 1");
            return 0;
        }
        return 1;
        
        
    }
    
    
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        long a,b,p,q,x0,y0,k,s,x1,y1,x3,y3;
        long i,j,aux=1,cont=0;
        long[] aux1 = new long[3];
        
        //PRUEBAS
        //System.out.println(obtenerInverso(-284080,1062789));
        
        
        /*
        a=1;
        b=6;
        p=11;
        x0=2;
        y0=7;
        aux1[0] = obtenerInverso(2*y0,p);
    if(aux1[0]<0)
        aux1[0] = p + aux1[0];
    System.out.println(2*y0+" Inverso de "+aux1[0]);
    aux1[1] = pot(pot2(x0,2,p,3)+a,1,p);
    if(aux1[1]<0)
        aux1[1] = p + aux1[1];
    System.out.println(3*2*x0+a+" mod de "+aux1[1]);
    s = pot(aux1[0]*aux1[1],1,p);
    if(s<0)
        s = p + s;
    System.out.println(s+" s");
    
    x3 = pot(s*s,1,p);
    x3 = pot(x3-x0-x0,1,p);
    if(x3<0)
        x3 = p + x3;
    System.out.println(x3+" x3");
    y3 = pot(x0-x3,1,p);
    if(y3<0)
        y3 = p + y3;
    y3 = pot(s*y3-y0,1,p);
    if(y3<0)
        y3 = p + y3;
    System.out.println(y3+" y3");
    
    System.out.println("2("+x3+" "+y3+")");
    
    for(i=4; i<q-1; i+=2){
        x1=x3;
        y1=y3;
        aux1[0] = obtenerInverso(2*y1,p);
        if(aux1[0]<0)
            aux1[0] = p + aux1[0];
        aux1[1] = pot(pot2(x1,2,p,3)+a,1,p);
        if(aux1[1]<0)
            aux1[1] = p + aux1[1];
        s = pot(aux1[0]*aux1[1],1,p);
        if(s<0)
            s = p + s;

        x3 = pot(s*s,1,p);
        x3 = pot(x3-2*x1,1,p);
        if(x3<0)
            x3 = p + x3;
        y3 = pot(1-x3,1,p);
        if(y3<0)
            y3 = p + y3;
        y3 = pot(s*y3-y1,1,p);
        if(y3<0)
            y3 = p + y3;

        System.out.println(i+"("+x3+" "+y3+")");
    }
        */
        
        
        
        //**************************************
        
        
        //PASO 1 PEDIR a
        do{
            if(aux==0)
                System.out.println("\n¡a NO VALIDA!");
            
            System.out.println("\na > 3, a impar");
            System.out.print("Ingrese a: ");
            a = entrada.nextInt();
            
            aux = a % 2;
            
            if(a==3)
                aux=0;
            
        }while(aux==0);
        
        //PASO 2 PEDIR b
        aux=0;
        do{
            if(aux!=0)
                System.out.println("\n¡b NO VALIDA!");
            
            System.out.println("\nb >= 2, b par");
            System.out.print("Ingrese b: ");
            b = entrada.nextInt();
            
            aux = b % 2;
        
        }while(aux!=0);
        
        System.out.println("\na="+a+" b="+b);
        
        //PASO 3 hacer operacion de p
        p = (a*a) + (b*b);
        System.out.println("\n\nP = "+a+"^2 + "+b+"^2 = "+p);
        
        
        //PASO 4 condiciones de p
        aux=1;
        do{
            if(aux==0){
                System.out.println("\n\n¡P NO CUMPLE LAS CONDICIONES!");
                System.out.println("b = "+b+" + 2 = "+(b+2));
                b = b + 2;
                p = (a*a) + (b*b);
                System.out.println("\n\nP = "+a+"^2 + "+b+"^2 = "+p);
            }
            aux=condiciones(p,a,b);
            
        }while(aux!=1);
    
    //PASO 5 CALCULAR q
    q = (p+1+2*a)/4;
    System.out.println("\nq = ("+p+"+1+2*"+a+")/4 = "+q);
        
    for(i=1;i<=q;i++){
        aux = q % i;
        if(aux==0)
            cont++;
    }
    
    if(cont==2)
            System.out.println("\n"+q+" es primo");
        else{
            System.out.println("\n"+q+" no es primo");
            System.out.println("Se deben probar nuevos numeros");
            System.exit(0);
        }
    
    //PASO 6 X0 y Y0
    System.out.println("\nIngrese X0: ");
    x0 = entrada.nextInt();
    
    System.out.println("Ingrese Y0: ");
    y0 = entrada.nextInt();
    
    aux1[0] = pot(x0,3,p);
    aux1[1] = pot(y0,2,p);
    aux1[2] = obtenerInverso(x0,p);
    if(aux1[2]<0)
        aux1[2] = p + aux1[2];
    System.out.println(aux1[2]);
    aux = pot((aux1[0] - aux1[1]),1,p);
    if(aux<0)
        aux = p + aux;
    k = pot((aux * aux1[2]),1,p);
    if(k<0)
        k = p + k;
    System.out.println("\nk = ("+x0+"^3-"+y0+"^2)("+x0+")^-1 mod "+p+" = "+k);
    
    
    //PASO 7 condiciones K
    aux1[0] = (p-1)/4;
    aux1[1] = pot(k,aux1[0],p);
    if(aux1[1]==1){
        System.out.println(k+"^"+aux1[0]+" mod "+p+" == "+aux1[1]);
        System.out.println("Probar otra x0 y y0");
        System.exit(0);
    }
    
    aux1[0] = (p-1)/2;
    aux1[1] = pot(k,aux1[0],p);
    
    if(aux1[1]!=1){
        System.out.println(k+"^"+aux1[0]+" mod "+p+" != "+aux1[1]);
        System.out.println("Probar otra x0 y y0");
        System.exit(0);
    }

    
    }
    
}
