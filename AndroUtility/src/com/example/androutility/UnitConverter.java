package com.example.androutility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UnitConverter extends Activity {

	Button length, weight, area, volume, speed, others;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_unitconverter_chooser);

		length = (Button) findViewById(R.id.buttonLength);
		weight = (Button) findViewById(R.id.buttonWeight);
		area = (Button) findViewById(R.id.buttonArea);
		volume = (Button) findViewById(R.id.buttonVolume);
		speed = (Button) findViewById(R.id.buttonSpeed);
		others = (Button) findViewById(R.id.buttonOthers);

		length.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						LengthActivity.class);
				startActivity(intent);
			}
		});
		
		weight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						WeightActivity.class);
				startActivity(intent);
			}
		});
		
		area.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						AreaActivity.class);
				startActivity(intent);
			}
		});
		
		volume.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						VolumeActivity.class);
				startActivity(intent);
			}
		});
		
		speed.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						SpeedActivity.class);
				startActivity(intent);
			}
		});
		
		others.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						OthersActivity.class);
				startActivity(intent);
			}
		});

	}

}
