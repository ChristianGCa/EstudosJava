package com.acme;

public class Plant {
    
    // Atributos
    private String name;
    private String especie;
    private String descricao;
    
    private Season estacao;
            
    
    // Operacoes
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Season getEstacao() {
        return estacao;
    }

    public void setEstacao(Season estacao) {
        this.estacao = estacao;
    }
    
    
}
