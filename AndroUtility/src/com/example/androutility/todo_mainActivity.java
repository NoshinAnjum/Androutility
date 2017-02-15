package com.example.androutility;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class todo_mainActivity extends ListActivity {

	private static final int EDITOR_ACTIVITY_REQUEST = 1001;
	private static final int MENU_DELETE_ID = 9999;
	private static final int MENU_DELETE_ALL_ID = 9989;
	private int currentNoteID;
	private NotesDataSource datasource;
	List<NoteItem> notesList;

	private static int backID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.todo_activity_main);
		registerForContextMenu(getListView());

		datasource = new NotesDataSource(this);

		refreshDisplay();

	}

	private void refreshDisplay() {

		notesList = datasource.findAll();
		ArrayAdapter<NoteItem> adapter = new ArrayAdapter<NoteItem>(this,
				R.layout.list_item_layout, notesList);
		setListAdapter(adapter);
		
		backID = 0;

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	
		getMenuInflater().inflate(R.menu.menu_todo_list, menu);
		
		return true;
	}
	
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.item_create:
			createNote();
			break;

		default:
			break;
		}
		
		return super.onOptionsItemSelected(item);
	}

	private void createNote() {

		NoteItem note = NoteItem.getNew();
		Intent intent = new Intent(this, NoteEditor.class);
		intent.putExtra("key", note.getKey());
		intent.putExtra("text", note.getText());
		startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		NoteItem note = notesList.get(position);
		Intent intent = new Intent(this, NoteEditor.class);
		intent.putExtra("key", note.getKey());
		intent.putExtra("text", note.getText());
		startActivityForResult(intent, EDITOR_ACTIVITY_REQUEST);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		if (requestCode == EDITOR_ACTIVITY_REQUEST && resultCode == RESULT_OK) {
			NoteItem note = new NoteItem();
			note.setKey(data.getStringExtra("key"));
			note.setText(data.getStringExtra("text"));
			datasource.update(note);
			refreshDisplay();
		}
		
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
		currentNoteID = (int) info.id;
		
		menu.add(0, MENU_DELETE_ID, 0, "Delete");
		menu.add(0, MENU_DELETE_ALL_ID, 1, "Delete All");
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case MENU_DELETE_ID:
			NoteItem note = notesList.get(currentNoteID);
			datasource.remove(note);
			refreshDisplay();
			break;

		case MENU_DELETE_ALL_ID:
			datasource.removeAll();
			refreshDisplay();
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		
		if (backID == 1) {
			super.onBackPressed();
		} else {
			Toast t = Toast.makeText(this, "Press Back again to return in main menu",
					Toast.LENGTH_SHORT);
			t.show();
		}
		
		backID++;
		
	}
}
