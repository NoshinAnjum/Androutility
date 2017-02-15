package com.example.androutility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calculator extends Activity {

	
	Button scientific,normal;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator_chooser);
		
	   scientific= (Button) findViewById(R.id.scientific);
	   normal = (Button) findViewById(R.id.normal);
		
		scientific.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent andy= new Intent(Calculator.this, scientific_calculator.class);
				startActivity(andy);
				
			}
		});
		
       normal.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent and= new Intent(Calculator.this, normal_calculator.class);
				startActivity(and);
				
			}
		});

	}
	
}
