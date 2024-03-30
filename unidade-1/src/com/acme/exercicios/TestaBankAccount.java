package com.acme.exercicios;

public class TestaBankAccount {

    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.setName("João de Deus");
        
        Account a1 = new Account();
        a1.setNumber(10325);
        a1.setBranchOffice("5788-6");
        a1.setActive(true);
        
        Account a2 = new Account();
        a2.setNumber(10225);
        a2.setBranchOffice("1301-9");
        a2.setActive(true);
        
        c1.addAccount(a1); // adiciona a conta bancária 1 ao cliente 1
        c1.addAccount(a2);
        
        Customer c2 = new Customer();
        c2.setName("Maria Antonieta");
        
        a1.put(1000);        
        System.out.println("Saldo Conta 1 = "+a1.getBalance() );
        
        a1.put(-250);
        System.out.println("Saldo Conta 1 = "+a1.getBalance() );
        
        try {
            a1.take(100);
            System.out.println("Saldo Conta 1 = "+a1.getBalance() );
        }catch(AccountOperationException ex) {
            System.out.println("Falha -> "+ex.getMessage());
        }
        
        
        
    }
    
}
