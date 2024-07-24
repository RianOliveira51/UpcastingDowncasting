package com.example.aprendendoupcastingdowncasting.entities;

public class Account {
    protected Integer number;
    protected String holder;
    protected double balance;

    public Account(){

    }

    public Account(Integer number, String holder, double balance){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    public Integer getNumber(){
        return number;
    }

    public void setHolder(Integer number){
        this.number = number;
    }

    public String getHolder(){
        return holder;
    }

    public void setHolder(String holder){
        this.holder = holder;
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount){
        balance -= amount;
    }


    public void deposit(double amount){
        balance += amount;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Number: ");
        sb.append(number + "\n");
        sb.append("Holder: ");
        sb.append(holder + "\n");
        sb.append("Balance");
        sb.append(balance);
        return sb.toString();
    }

}
