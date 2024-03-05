package com.acme;

import java.util.HashMap;
import java.util.Set;

public class ExercicioHashMap {

    public static void main(String[] args) {
        String g = """
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Todo dia eu viajo
        Com uma azul e uma amarela
        Eu perdi minha caneta
        Quem achou, devolva ela
        Todo dia eu viajo
        Com azul e uma amarela
        Eu perdi minha caneta
        Quem achou devolva ela
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Todo dia eu viajo
        Com uma azul e uma amarela
        Perdi minha caneta
        Quem achou, devolva ela
        Todo dia eu viajo
        Com uma azul e uma amarela
        Perdi minha caneta
        Quem achou, devolva ela
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        Caneta azul, azul caneta
        Caneta azul tá marcada com minha letra
        """;
        

        String texto = "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Todo dia eu viajo\n" +
        "Com uma azul e uma amarela\n" +
        "Eu perdi minha caneta\n" +
        "Quem achou, devolva ela\n" +
        "Todo dia eu viajo\n" +
        "Com azul e uma amarela\n" +
        "Eu perdi minha caneta\n" +
        "Quem achou devolva ela\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Todo dia eu viajo\n" +
        "Com uma azul e uma amarela\n" +
        "Perdi minha caneta\n" +
        "Quem achou, devolva ela\n" +
        "Todo dia eu viajo\n" +
        "Com uma azul e uma amarela\n" +
        "Perdi minha caneta\n" +
        "Quem achou, devolva ela\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "Caneta azul tá marcada com minha letra\n" +
        "Caneta azul, azul caneta\n" +
        "\n" +
        "Caneta azul tá marcada com minha letra";
        
        System.out.println(texto);
        texto = texto.toLowerCase();
        texto = texto.replace(",", "").replace("\n\n", " ").replace("\n", " ");
        System.out.println(texto);
        
        System.out.println("Caracteres -> " + texto.length());
        
        // Dividindo o texto em tokens, "palavras"
        String[] tokens = texto.split(" ");
        
        System.out.println("# Tokens -> " + tokens.length);
        
        HashMap<String, Integer> palavras = buildMap(tokens);
        
        Set<String> keys = palavras.keySet();
        for (String k : keys) {
            System.out.println(k + " ---> " + palavras.get(k));
        }
        
    } // Fim do main
    
    // Método para receber os tokens e retornar o mapa das palavras com chave String
    private static HashMap<String, Integer> buildMap(String[] tokens){
    
        HashMap<String, Integer> m = new HashMap();
        
        for(String t: tokens) {
            if (m.containsKey(t)) {
                int n = m.get(t);
                m.put(t, ++n);
            }else {
                m.put(t, 1);
            } 
        }
        return m;
    }  
}
