package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId=""; //consists of Uppercase English characters only

    public CurrentAccount() {

    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        try {
            if(balance<5000) throw new Exception();
            new BankAccount(name,balance,5000);
        }catch (Exception e){
            System.out.println("Insufficient Balance");
        }

    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        tradeLicenseId=rearrangeString(tradeLicenseId);
        if(tradeLicenseId.equals("")) System.out.println("Valid License can not be generated");
        else System.out.println(tradeLicenseId);
    }

    public char getMaxCountChar(int[] count){
        int max=0;
        char ch=0;

        for(int i=0;i<26;i++){
            if(count[i]>max){
                max=count[i];
                ch=(char)((int)'a'+i);
            }
        }
        return ch;
    }
    public String rearrangeString(String s){
        int n=s.length();
        if(n==0) return "";

        int count[]=new int[26];

        for(char ch : s.toCharArray()){
            count[(int)ch-(int)'a']++;
        }
        char chMax=getMaxCountChar(count);
        int maxCount=count[(int)chMax-(int)'a'];

        if(maxCount>(n+1)/2) return "";

        String res="";
        for(int i=0;i<n;i++)
            res=res+' ';

        int ind=0;

        while(maxCount>0){
            res=res.substring(0,ind)+chMax+res.substring(ind+1);
            ind+=2;
            maxCount--;
        }
        count[(int)chMax-(int)'a']=0;

        for(int i=0;i<26;i++){
            while (count[i]>0){
                ind=(ind>=n)?1:ind;
                res=res.substring(0,ind)+(char)((int)'a'+i)+res.substring(ind+1);
                ind+=2;
                count[i]--;
            }
        }
        return res;
    }

}
