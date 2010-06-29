package net.status.lvp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
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
        
        /**Initialise all the widgets*/
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
        
        editSear.getText();
        
        ArrayAdapter<?> adapOnly = ArrayAdapter.createFromResource(this, R.array.only_in, android.R.layout.simple_spinner_item);
        adapOnly.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinOnly.setAdapter(adapOnly);
        spinOnly.setSelection(3);
        spinOnly.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				parent.getItemAtPosition(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapLang = ArrayAdapter.createFromResource(this, R.array.language, android.R.layout.simple_spinner_item);
        adapLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLang.setAdapter(adapLang);
        spinLang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				parent.getItemAtPosition(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapMate = ArrayAdapter.createFromResource(this, R.array.material_type, android.R.layout.simple_spinner_item);
        adapMate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMate.setAdapter(adapMate);
        spinMate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				parent.getItemAtPosition(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        ArrayAdapter<?> adapLoca = ArrayAdapter.createFromResource(this, R.array.location, android.R.layout.simple_spinner_item);
        adapLoca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinLoca.setAdapter(adapLoca);
        spinLoca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				parent.getItemAtPosition(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// TODO Auto-generated method stub
				
			}
		});
        
        editYeAf.getText();
        
        editYeBe.getText();
        
        ArrayAdapter<?> adapSort = ArrayAdapter.createFromResource(this, R.array.sort, android.R.layout.simple_spinner_item);
        adapSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adapSort);
        spinSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				parent.getItemAtPosition(position);
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
				// Restore input area to default value
				editSear.setText("");
				editSear.refreshDrawableState();
				spinOnly.setSelection(3);
				spinOnly.refreshDrawableState();
				spinLang.setSelection(0);
				spinLang.refreshDrawableState();
				spinLoca.setSelection(0);
				spinLoca.refreshDrawableState();
				spinMate.setSelection(0);
				spinMate.refreshDrawableState();
				spinSort.setSelection(0);
				spinSort.refreshDrawableState();
				editYeAf.setText("");
				editYeAf.refreshDrawableState();
				editYeBe.setText("");
				editYeBe.refreshDrawableState();
				
			}
		});
    }
}
