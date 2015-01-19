/*Course: CS2302
 *Section: 01
 *Name: Andrew El-Masry
 *Professor: Dr Shaw
 *Assignment #: Lab 17
 */


package com.example.androidcalculator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends Activity {

	public final int DONE = 0;        // The value of the plus operator
	public final int PLUS = 1;        // The value of the plus operator
    public final int MINUS = 2;       // The value of the minus operator
    public final int MULTIPLY = 3;    // The value of the multiply operator
    public final int DIVIDE = 4;      // The value of the divide operator
    
	private static TextView outputTxt = null;
	private static Button button1 = null;
	private static Button button2 = null;
	private static Button button3 = null;
	private static Button button4 = null;
	private static Button button5 = null;
	private static Button button6 = null;
	private static Button button7 = null;
	private static Button button8 = null;
	private static Button button9 = null;
	private static Button button0 = null;
	private static Button buttonPlus = null;
	private static Button buttonMinus = null;
	private static Button buttonDivide = null;
	private static Button buttonMultiply = null;
	private static Button buttonEquals = null;
	private static Button buttonClear = null;

    //private double input1, input2, result;
    private double input1, input2, input3, result;
    private int operator = 0;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
		outputTxt = (TextView) findViewById(R.id.txtOutput);
		
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr1));
        	}
        });
		
		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr2));
        	}
        });
		
		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr3));
        	}
        });
		
		button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr4));
        	}
        });
		
		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr5));
        	}
        });
		
		button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr6));
        	}
        });
		
		button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr7));
        	}
        });
		
		button8 = (Button) findViewById(R.id.button8);
		button8.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr8));
        	}
        });
		
		button9 = (Button) findViewById(R.id.button9);
		button9.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr9));
        	}
        });
		
		button0 = (Button) findViewById(R.id.button0);
		button0.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		addToOutput(getString(R.string.btnStr0));
        	}
        });
		
		buttonClear = (Button) findViewById(R.id.buttonClear);
		buttonClear.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		outputTxt.setText("");
        		operator = DONE;
        		input1 = 0;
        	}
        });
		
		buttonPlus = (Button) findViewById(R.id.buttonPlus);
		buttonPlus.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		processOperation(PLUS);
        	}
        });
		
		buttonMinus = (Button) findViewById(R.id.buttonMinus);
		buttonMinus.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		processOperation(MINUS);
        	}
        });
		
		buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
		buttonMultiply.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		processOperation(MULTIPLY);
        	}
        });
		
		buttonDivide = (Button) findViewById(R.id.buttonDivide);
		buttonDivide.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		processOperation(DIVIDE);
        	}
        });
		
		buttonEquals = (Button) findViewById(R.id.buttonEquals);
		buttonEquals.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		if (operator > -1)
        			input3 = getOutputDbl();
        		result = getResult();
        		String outputstr = "" + result;
        	    if (outputstr.endsWith(".0"))
        	        outputstr = outputstr.substring(0,outputstr.length()-2);
        	    outputTxt.setText(outputstr);
        	    operator = -Math.abs(operator);
        	}
        });
    }

    private void processOperation(int nextOp) {
		getInput1();
	    outputTxt.setText("");
		operator = nextOp;
    }
    

	private void addToOutput(String appendStr) {
		checkOp();
		outputTxt.setText(outputTxt.getText() + appendStr);
	}
	
	private double getOutputDbl()
	{
		String outputstr = outputTxt.getText().toString();
		return (outputstr.equals("")) ? 0 : Double.parseDouble(outputstr);
	}
	
	private void checkOp()
	{
		if (operator == -1) {
			outputTxt.setText("");
    	    operator = 0;
		}
	}
	
	private double getResult()
	{
		input2 = (operator < 0) ? input3: getOutputDbl();
		if(operator<0){
			input1 = getOutputDbl();
			input2 = input3;
		}else 
			input2 = getOutputDbl();

		//input2 = getOutputDbl();
		//switch(operator) {
		switch(Math.abs(operator)) {
		    case PLUS: result = input1 + input2; break;
		    case MINUS: result = input1 - input2; break;
		    case MULTIPLY: result = input1 * input2; break;
		    case DIVIDE: result = input1 / input2; break;
		}
		return result;
	}
	
	private void getInput1()
	{
		if (operator > DONE)
			input1 = getResult();
		else
			input1 = getOutputDbl();
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculator, menu);
        return true;
    }
}