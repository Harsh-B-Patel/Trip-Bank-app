package com.example.tripbankapp;

/**
 * Created by mailh on 2018-03-15.
 */

public class Transaction {
    String type;
    double amount;


    Transaction(String type, double amt){
        this.type= type;
        this.amount=amt;
    }


    String getType(){
        return this.type;
    }

    double getAmount(){
        return this.amount;
    }





}