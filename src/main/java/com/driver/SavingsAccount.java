package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount() {
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.maxWithdrawalLimit=maxWithdrawalLimit;
        this.rate=rate;
    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        try{
            if(amount>maxWithdrawalLimit) throw new Exception();
            try{
                if(amount>getBalance()) throw new Exception();
                setBalance(getBalance()-amount);
            }catch (Exception e){
                System.out.println("Insufficient Balance");
            }
        }catch (Exception e){
            System.out.println("Maximum Withdraw Limit Exceed");
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        return (getBalance()*rate*years)/100 + getBalance();
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
       double finalAmount=getBalance()*Math.pow((1+rate/100),years);
        return finalAmount;
    }

}
