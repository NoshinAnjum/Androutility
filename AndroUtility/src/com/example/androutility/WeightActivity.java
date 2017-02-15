package com.example.androutility;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WeightActivity extends Activity {

	double factor;
	Spinner spinner;
	Button btnConvert;
	EditText etFrom, etTo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weight);

		spinner = (Spinner) findViewById(R.id.spinnerLength);
		btnConvert = (Button) findViewById(R.id.btnConvert);
		etFrom = (EditText) findViewById(R.id.editTextFrom);
		etTo = (EditText) findViewById(R.id.editTextTo);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter
				.createFromResource(this, R.array.weightArray,
						android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				switch (arg2) {
				case 0:
					factor = 28.34952;
					break;
				case 1:
					factor = 0.035273;
					break;
				case 2:
					factor = 0.4535924;
					break;
				case 3:
					factor = 2.2046225;
					break;
				case 4:
					factor = 15.432358;
					break;
				case 5:
					factor = 0.064799;
					break;
				case 6:
					factor = 1000;
					break;
				case 7:
					factor = 0.001;
					break;
					 
				default:
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
				
			}
		});
		
		
		btnConvert.setOnClickListener(new OnClickListener() { 
			
			@Override
			public void onClick(View arg0) {
				double from, to;
				
				from = Double.parseDouble(etFrom.getText().toString());
				
				to  = factor * from;
				
				etTo.setText(String.valueOf(to));
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weight, menu);
		return true;
	}

}
