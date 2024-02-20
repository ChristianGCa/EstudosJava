/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.acme;

/**
 *
 * @author christian
 */
public class WrapperClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String q = "47";
        String p = "2.87";
        
        int qq = Integer.parseInt(q);
        float pp = Float.parseFloat(p);
        
        float total = qq * pp;
        
        System.out.println(qq);
        System.out.println(pp);
        System.out.println(total);
        
        System.out.println("Maior inteiro: " + Integer.MAX_VALUE);
        System.out.println("Menor inteiro: " + Integer.MIN_VALUE);
        System.out.println("Maior float: " + Float.MAX_VALUE);
        System.out.println("Menor float: " + Float.MIN_VALUE);
        System.out.println("Maoior double: " + Double.MAX_VALUE);
        System.out.println("Menor double: " + Double.MIN_VALUE);
        
        Integer i = 73;
        System.out.println(i.toBinaryString(i));
        
    
    }
}