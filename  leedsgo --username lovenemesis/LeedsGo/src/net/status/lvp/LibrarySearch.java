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

public class LibrarySearch extends Activity {
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_search);
        
        /**Initialise the preference*/
        final SharedPreferences searching = getSharedPreferences("searching", MODE_PRIVATE);
        final SharedPreferences.Editor editor = searching.edit();
        editor.commit();
        
        /**Initialise all the widgets with values from preference*/
        final EditText editSear = (EditText)findViewById(R.id.edit_search);
        final Spinner spinOnly = (Spinner)findViewById(R.id.spinner_only_in);
        final Spinner spinLang = (Spinner)findViewById(R.id.spinner_language);
        final Spinner spinMate = (Spinner)findViewById(R.id.spinner_material);
        final Spinner spinLoca = (Spinner)findViewById(R.id.spinner_location);
        final EditText editYeAf = (EditText)findViewById(R.id.edit_after);
        final EditText editYeBe = (EditText)findViewById(R.id.edit_before);
        final Spinner spinSort = (Spinner)findViewById(R.id.spinner_sort);
        final Button buttAL = (Button)findViewById(R.id.button_about_lib);
        final Button buttSear = (Button)findViewById(R.id.button_search);
        final Button buttClea = (Button)findViewById(R.id.button_search);
        
        
        /**Get information from widgets.*/
        editSear.setText(searching.getString("keywords",""));
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
				editor.commit();
			}
		});
        
        ArrayAdapter<?> adapOnly = ArrayAdapter.createFromResource(this, R.array.only_in, android.R.layout.simple_spinner_item);
        adapOnly.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOnly.setAdapter(adapOnly);
        spinOnly.setSelection(searching.getInt("only_in", 3));
        spinOnly.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("only_in", position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLang.setAdapter(adapLang);
        spinLang.setSelection(searching.getInt("language", 0));
        spinLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("language", position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapMate = ArrayAdapter.createFromResource(this, R.array.material_type, android.R.layout.simple_spinner_item);
        adapMate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMate.setAdapter(adapMate);
        spinLang.setSelection(searching.getInt("material", 0));
        spinMate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("material", position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapLoca = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        adapLoca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLoca.setAdapter(adapLoca);
        spinLang.setSelection(searching.getInt("location", 0));
        spinLoca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("location", position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        editYeAf.setText(searching.getString("year_after",""));
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
				editor.commit();
			}
		});
        
        editYeBe.setText(searching.getString("year_before",""));
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
				editor.commit();
			}
		});
        
        ArrayAdapter<?> adapSort = ArrayAdapter.createFromResource(this, R.array.sort, android.R.layout.simple_spinner_item);
        adapSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adapSort);
        spinSort.setSelection(searching.getInt("sort", 0));
        spinSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// Push position to preference
				editor.putInt("sort", position);
				editor.commit();
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        buttAL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(LibrarySearch.this)
				.setTitle(R.string.about_lib)
				.setMessage(R.string.about_lib_message)
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
				
			}
		});
        
        buttClea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Clear the preference to restore default value.
				editor.clear().commit();
			}
		});
    }
}
