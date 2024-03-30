package com.acme.exercicios;

import java.util.ArrayList;

public class Customer {

    // Atributos
    private String name;
    private String cpf;
    private String birthdate;
    private ArrayList<Account> bankAccounts;
    
    // Construtor
    public Customer() {
        bankAccounts = new ArrayList();
    }
    
    // Operações
    public void addAccount(Account c) {
        bankAccounts.add(c);
    }
    
    public boolean removeAccount(String branchOffice, int number) {
        for(Account c : bankAccounts) {
            if (c.getBranchOffice().equals(branchOffice) && c.getNumber() == number) {
                bankAccounts.remove(c);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    
    
}
