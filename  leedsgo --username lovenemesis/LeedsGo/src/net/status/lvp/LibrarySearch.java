package net.status.lvp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;

public class LibrarySearch extends Activity {
	
	SharedPreferences searching = null;
	SharedPreferences.Editor editor = null;
	
	private EditText editSear = null;
	private Spinner spinOnly = null;
	private Spinner spinLang = null;
	private Spinner spinMate = null;
	private Spinner spinLoca = null ; 
	private EditText editYeAf = null; 
	private EditText editYeBe = null;
	private Spinner spinSort = null;
	private Button buttHeLi = null;
	private Button buttSear = null;
	private Button buttClea = null;
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_search);
        
        //Initialise the preference
    	searching = getSharedPreferences("searching", MODE_PRIVATE);
        editor = searching.edit();
        
        //Initialise all the widgets with values from preference
        editSear = (EditText)findViewById(R.id.edit_search);
        spinOnly = (Spinner)findViewById(R.id.spinner_only_in);
        spinLang = (Spinner)findViewById(R.id.spinner_language);
        spinMate = (Spinner)findViewById(R.id.spinner_material);
        spinLoca = (Spinner)findViewById(R.id.spinner_location);
        editYeAf = (EditText)findViewById(R.id.edit_after);
        editYeBe = (EditText)findViewById(R.id.edit_before);
        spinSort = (Spinner)findViewById(R.id.spinner_sort);
        buttHeLi = (Button)findViewById(R.id.button_help_lib);
        buttSear = (Button)findViewById(R.id.button_search);
        buttClea = (Button)findViewById(R.id.button_clear);
        
        
        //Get information from inputs.
        editSear.setText("");
        editSear.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// Push text to preference
				editor.putString("keyword", editSear.getText().toString());
			}
		});
        
        ArrayAdapter<?> adapOnly = ArrayAdapter.createFromResource(this, R.array.only_in, android.R.layout.simple_spinner_item);
        adapOnly.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOnly.setAdapter(adapOnly);
        spinOnly.setSelection(3);
        spinOnly.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("only_in", position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Only_in must have a value
				editor.putInt("only_in", 3);
			}
		});
        
        ArrayAdapter<?> adapLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLang.setAdapter(adapLang);
        spinLang.setSelection(0);
        spinLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("language", position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub

			}
		});
        
        ArrayAdapter<?> adapMate = ArrayAdapter.createFromResource(this, R.array.material_type, android.R.layout.simple_spinner_item);
        adapMate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMate.setAdapter(adapMate);
        spinMate.setSelection(0);
        spinMate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("material", position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapLoca = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        adapLoca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLoca.setAdapter(adapLoca);
        spinLoca.setSelection(0);
        spinLoca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("location", position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        editYeAf.setText("");
        editYeAf.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// Push text to preference
				editor.putString("year_after", editYeAf.getText().toString());
			}
		});
        
        editYeBe.setText("");
        editYeBe.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// Push text to preference
				editor.putString("year_before", editYeBe.getText().toString());
			}
		});
        
        ArrayAdapter<?> adapSort = ArrayAdapter.createFromResource(this, R.array.sort, android.R.layout.simple_spinner_item);
        adapSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adapSort);
        spinSort.setSelection(0);
        spinSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("sort", position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Sort must have a value
				editor.putInt("sort", 0);
			}
		});
        
        buttHeLi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(LibrarySearch.this)
				.setTitle(R.string.help_lib)
				.setMessage(R.string.help_lib_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttSear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor.commit();
				startActivity(new Intent(LibrarySearch.this, LibraryList.class));
			}
		});
        
        buttClea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Clear the preference to restore default value.
				editor.clear()
				.remove("keyword")
				.remove("only_in")
				.remove("language")
				.remove("material")
				.remove("location")
				.remove("year_after")
				.remove("year_before")
				.remove("sort")
				.commit();
			}
		});
    }
    
    @Override
    public void onPause(){
    	// Save the current input area status to preference.
    	super.onPause();
    	editor.commit();
    	
    }
    
    
    @Override
    public void onResume(){
    	super.onResume();
    	// Restore the input area from last successful search in preference.
    	editSear.setText(searching.getString("keyword", ""));
    	spinOnly.setSelection(searching.getInt("only_in", 3));
    	spinLang.setSelection(searching.getInt("language", 0));
    	spinMate.setSelection(searching.getInt("material", 0));
    	spinLoca.setSelection(searching.getInt("location", 0));
    	editYeAf.setText(searching.getString("year_after", ""));
    	editYeBe.setText(searching.getString("year_before", ""));
    	spinSort.setSelection(searching.getInt("sort", 0));
    } 
}
