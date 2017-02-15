package com.example.androutility;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends Activity {

	String classes[] = { "Calculator", "Equation Solver", "Unit Converter",
			"To Do List" };
	Intent go;
	
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view_android_example);

		listView = (ListView) findViewById(R.id.list);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				classes);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				if (position == 0) {
					go = new Intent("com.example.androutility.Calculator");
				} else if (position == 1) {
					go = new Intent("com.example.androutility.EquationSolver");
				} else if (position == 2) {
					go = new Intent("com.example.androutility.UnitConverter");
				} else if (position == 3) {
					go = new Intent("com.example.androutility.todo_mainActivity");
				}
				  

				startActivity(go);
				
			}

		});

	}


	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do You Wanna Quit?")
				.setPositiveButton("Yes", dialogClickListener)
				.setNegativeButton("No", dialogClickListener).show();
	}

	DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			switch (which) {

			case DialogInterface.BUTTON_POSITIVE:
				dialog.dismiss();
				finish();
				break;

			case DialogInterface.BUTTON_NEGATIVE:
				dialog.dismiss();
				break;
			}
		}
	};

}
