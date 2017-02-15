package com.example.androutility;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteEditor extends Activity {

	private NoteItem note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_editor);
		getActionBar().setDisplayHomeAsUpEnabled(true);

		Intent intent = this.getIntent();
		note = new NoteItem();

		note.setKey(intent.getStringExtra("key"));
		note.setText(intent.getStringExtra("text"));

		EditText et = (EditText) findViewById(R.id.noteText);
		et.setText(note.getText());
		et.setSelection(note.getText().length());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.editor_option, menu);

		return super.onCreateOptionsMenu(menu);
	}

	private boolean saveAndFinish() {
		EditText et = (EditText) findViewById(R.id.noteText);
		String noteText = et.getText().toString();

		if (!noteText.isEmpty()) {
			Intent intent = new Intent();
			intent.putExtra("key", note.getKey());
			intent.putExtra("text", noteText);
			setResult(RESULT_OK, intent);
			finish();

			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (item.getItemId() == android.R.id.home
				|| item.getItemId() == R.id.save_note) {

			if (saveAndFinish()) {
				Toast t = Toast.makeText(this, "Note saved succesfully!",
						Toast.LENGTH_SHORT);
				t.show();
			} else {
				Toast t = Toast.makeText(this, "Can not save an empty note!",
						Toast.LENGTH_SHORT);
				t.show();
			}
		}

		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;

		
			//break;
		}

		return false;
	}

	 @Override
	 public void onBackPressed() {
	
	 if (saveAndFinish()) {
	 Toast t = Toast.makeText(this, "Note saved succesfully!",
	 Toast.LENGTH_SHORT);
	 t.show();
	 } else {
	 Toast t = Toast.makeText(this, "Can not save an empty note!",
	 Toast.LENGTH_SHORT);
	 t.show();
	 }
	
	 }
	
}
