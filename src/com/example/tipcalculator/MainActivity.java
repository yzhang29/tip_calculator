package com.example.tipcalculator;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	 
    public void increaseTip(View v){
    	EditText txtPercentage = (EditText) findViewById(R.id.txtTipPercentage);
    	String txtPercentageValue = txtPercentage.getText().toString();
    	int percentage = getPercentage(txtPercentageValue)+1;
    	txtPercentage.setText(percentage+"%");
    	
    }
    
    public void decreaseTip(View v){
    	EditText txtPercentage = (EditText) findViewById(R.id.txtTipPercentage);
    	String txtPercentageValue = txtPercentage.getText().toString();
    	int percentage = getPercentage(txtPercentageValue)-1;
    	if(percentage<0) percentage = 0;
    	txtPercentage.setText(percentage+"%");
    	
    }
    
    public void calculate(View v){
    	EditText txtPercentage = (EditText) findViewById(R.id.txtTipPercentage);
    	EditText txtTotal = (EditText) findViewById(R.id.txtTotal);
    	int percentage = getPercentage(txtPercentage.getText().toString());
    	int total = parseInput(txtTotal.getText().toString());
    	if(total == -1)
    		total = 0;
    	int tip = total*percentage/100;
    	total = total+tip;
    	txtPercentage.setText(percentage+"%");
    	TextView result = (TextView) findViewById(R.id.txtResult);
    	result.setText("Tip: "+tip+"\nTotal: "+total);
    	
    }

    private int getPercentage(String input){
    	int tip = parseInput(input);
    	if(tip==-1) 
    		return 15;
    	return tip;
    }
    private int parseInput(String input){
    	int number=-1;
    	int length = input.length();
    	if(length<1) return number;
    	if(input.charAt(length-1)=='%')
    		input=input.substring(0,length-1);
    	try{
    		number = Integer.parseInt(input);
    	    if(number<0) 
    	    	number *= -1;
    	}
    	catch(Exception e){
    		return number;
    	}
    	return number;
    }

}
