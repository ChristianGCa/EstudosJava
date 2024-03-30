package com.acme.exercicios;

public class Account {

    // Atributos
    private float balance;
    private String branchOffice;
    private int number;
    private boolean active;
    
    // Operações
    /**
     * This operation alows to take money from an account.
     * @param amount this is the amount you want to add to your account
     * @throws AccountOperationException There is no balance in your account or you are tring to take more money than you have.
     */
    public void take(float amount) throws AccountOperationException {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;            
        }else {
            String msg = "Não há saldo suficiente na conta para saque!";
            if ( amount <= 0 ) {
                msg = "Não é possível sacar um valor negativo ou igual a zero!";
            }
            throw new AccountOperationException(msg);            
        }
    }
    
    public boolean put(float amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }

    public float getBalance() {
        return balance;
    }

    public String getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
    
}
