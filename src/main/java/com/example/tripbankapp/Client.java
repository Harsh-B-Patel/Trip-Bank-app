package com.example.tripbankapp;

/**
 * Created by mailh on 2018-03-15.
 */

public class Client {
    String servicetype= null;
    String name = null;
    double amount = 0;
    Transaction[] transaction = new Transaction[10];
    int toc = 0;

    Client(String name , double amount ){
        this.name= name;
        this.amount= amount;
    }

    void setServicetype(String service){
        this.servicetype= service;
    }

   void setWithdraw(double a ){
        this.amount= this.amount-a;
        String wd = "Withdraw";
        Transaction t = new Transaction(wd,a);
        transaction[toc]= t;
        toc++;
   }

   void setdeposit(double a){
       this.amount= this.amount+a;
       String dp= "Deposit";
       Transaction t = new Transaction(dp,a);
       transaction[toc]= t;
       toc++;
   }



   String getoutput(){
       String s ="The statement of client "+this.name+ "(current balance is "+this.amount+")\n";
       for(int a = 0; a<toc;a++){
           s = s + "Transaction "+ transaction[a].getType() +": "+transaction[a].getAmount()+"\n";
       }
       return s;
   }



    String getname(){
        return this.name;

    }

    double getAmount(){
        return this.amount;
    }

}
