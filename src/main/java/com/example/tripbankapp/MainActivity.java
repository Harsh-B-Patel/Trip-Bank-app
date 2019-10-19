package com.example.tripbankapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Bank bank= new Bank();
    int noc = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void displayThis(int id, String newContent){
        View view = findViewById(id);
        TextView textview = (TextView) view;
        textview.setText(newContent);
    }
    private String getInput(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }
    private String getSpinnerInput(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String mySpinner = spinner.getSelectedItem().toString();
        return mySpinner;
    }


    public void CreateAccount(View view){

        String name = getInput(R.id.inputName);
        double balance = Double.parseDouble(getInput(R.id.inputAmt));
        bank.addClinet(name,balance);
        displayThis(R.id.labelAnswer,bank.CreateAccountTostring());


    }

    public void CompleteTransaction(View view){

        String service = getSpinnerInput(R.id.spinner);
        bank.setService(service);
        String Fromclient = getInput(R.id.inputFrom);
        String Toclient = getInput(R.id.inputTo);
        double amt = Double.parseDouble(getInput(R.id.inputTAmt));
        bank.Transaction(Fromclient,Toclient,amt,service);
        displayThis(R.id.labelAnswer,bank.toStringTranscation());


    }

    public void OutputStatement(View view){
        String clinetinfo = getInput(R.id.inputOName);
        displayThis(R.id.labelAnswer,bank.statement(clinetinfo));


    }




}
