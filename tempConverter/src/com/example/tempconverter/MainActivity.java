package com.example.tempconverter;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView tempOut =   (TextView) findViewById(R.id.textView1);
		final EditText tempIn = (EditText) findViewById(R.id.editText1);
		final Button button = (Button) findViewById(R.id.button1);
		final RadioButton cToF = (RadioButton) findViewById(R.id.cToF);
		final RadioButton fToC = (RadioButton) findViewById(R.id.fToC);
		
		// Link UI elements to actions in c12ode		
		button.setOnClickListener(new Button.OnClickListener() {
			private String TAG="starting button";

			@Override
			public void onClick(View v) {
				try {
					if(fToC.isChecked())tempOut.setText(String.format("%.2f",(convert1(tempIn))));
					
					else if(cToF.isChecked())tempOut.setText(String.format("%.2f",(convert2(tempIn))));
				
				} catch (Exception e) {
					Log.e(TAG, e.toString());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public Double convert1(EditText s){
		int i=Integer.valueOf(s.getText().toString());
		double temp;
		temp= (i-32)*(5/9.0212);
		
		return temp;
	}
	
	public Double convert2(EditText s){
		int i=Integer.valueOf(s.getText().toString());
		double temp;
		temp= (i*9.5/5)+32;
		
		return temp;
	}

}
