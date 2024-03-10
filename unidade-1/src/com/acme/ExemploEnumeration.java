package com.acme;

public class ExemploEnumeration {

    public static void main(String[] args) {
        
        Plant p = newPlant("Cenoura", "Raiz laranja com folhas compridas verdes", Season.SUMMER);
        imprimir(p);
        
        Plant p2 = newPlant("Mamão", "Arvore alta", Season.FALL);
        imprimir(p2);

    }
    
    public static void imprimir(Plant plant) {
        System.out.println("Espécie: " + plant.getEspecie());
        System.out.println("Descrição: " + plant.getDescricao());
        System.out.println("Estação: " + plant.getEstacao());
    
    }
    
    public static Plant newPlant(String especie, String descricao, Season estacao) {
    
        Plant p = new Plant();
        p.setEspecie(especie);
        p.setDescricao(descricao);
        p.setEstacao(estacao);
        return p;
    
    
    }
}
