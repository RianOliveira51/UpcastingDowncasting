package com.example.aprendendoupcastingdowncasting.entities;

public class BusinessAccount extends Account {
    private double loanLimit;

    public BusinessAccount(){
        super();
    }

    public BusinessAccount(Integer number, String holder, double balance, double loanLimit){
        //usamos o metodo super para pegar os argumentos de outra class.
        super(number, holder, balance);
        this.loanLimit = loanLimit;

    }

    public double getLoanLimit(){
        return loanLimit;
    }

    public void setLoanLimit(double loanLimit){
        this.loanLimit = loanLimit;
    }

    public void loan(double amount){
        if(amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Number: ");
        sb.append(number + "\n");
        sb.append("Holder: ");
        sb.append(holder + "\n");
        sb.append("Balance: ");
        sb.append(balance + "\n");
        sb.append("LoanLimit: ");
        sb.append(String.format("%.2f",loanLimit));
        return sb.toString();

    }

}
