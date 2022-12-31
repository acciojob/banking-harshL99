package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
       BankAccount ba=new BankAccount("Harsh",1000,1000);
       ba.withdraw(500);
       ba.deposit(2000);
        System.out.println(ba.generateAccountNumber(5,5));
        System.out.println(ba.getBalance());
        CurrentAccount ca=new CurrentAccount("Harsh",5500,"AAABBBB");
        ca.validateLicenseId();

    }
}