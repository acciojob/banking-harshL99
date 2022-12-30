package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount() {

    }

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        String d="";

        for(int i=1;i<=digits;i++){
            d=d+'9';   //Possible Maximum No...having digits
        }


        try{
            if(sumOfDigits(d)<sum) throw new Exception();

            while(sumOfDigits(d)>sum){
                d=(Integer.parseInt(d)-1)+"";
            }

            if(d.length()==digits) return d;  //Ac.No is equal to digits...
            for(int i=1;i<=digits-d.length();i++)  //Ac.No is lesser than digits...Attach Zeroes
                d='0'+d;

            return d;

        }catch (Exception e){
            System.out.println("Account Number can not be generated");
        }
        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
          balance-=amount;
          try{
              if(balance<minBalance) throw new Exception();
          }catch (Exception e){
              System.out.println("Insufficient Balance");
          }
    }

    public int sumOfDigits(String n){
        int res=0;
        for(int i=0;i<n.length();i++){
            res+=(n.charAt(i)-'0');
        }
        return res;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}