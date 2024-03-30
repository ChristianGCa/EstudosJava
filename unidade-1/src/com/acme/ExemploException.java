package com.acme;

public class ExemploException {

    public static void main(String[] args) {
        System.out.println("Início do algoritmo");
        int a = 10;
        int b = 0;        
      
        try {
            System.out.println( args[2] );
            int res = div(a,b);        
            System.out.println("O resultado é -> "+res);
        }catch(ArithmeticException ex) {
            System.out.println("Você forneceu um valor zero para o denominador!");
            System.out.println( ex.getMessage() );
        }catch(ArrayIndexOutOfBoundsException ex) {
            System.out.println("Opts, vc acessou uma posição que não existe no vetor");
        }
        
        System.out.println("FIM");
    }
    
    public static int div(int a, int b) {
        return a / b;
    }
    
    
}
