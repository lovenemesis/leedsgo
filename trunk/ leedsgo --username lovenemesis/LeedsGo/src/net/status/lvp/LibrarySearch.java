package net.status.lvp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class LibrarySearch extends Activity {
	
	private Handler handler = new Handler();
	
	private EditText editSear = null;
	private Spinner spinOnly = null;
	private Spinner spinLang = null;
	private Spinner spinMate = null;
	private Spinner spinLoca = null ; 
	private EditText editYeAf = null; 
	private EditText editYeBe = null;
	private Spinner spinSort = null;
	private Button buttHowto = null;
	private Button buttSear = null;
	private Button buttClea = null;
	
	private String searchstring = null;
	private String scope = "4";
	private String lang = "";
	private String mattype = "";
	private String branch = "";
	private String Da = "";
	private String Db = "";
	private String sort = "D";
	
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_search);
        
        //Initialise all the widgets with values from preference
        editSear = (EditText)findViewById(R.id.edit_search);
        spinOnly = (Spinner)findViewById(R.id.spinner_only_in);
        spinLang = (Spinner)findViewById(R.id.spinner_language);
        spinMate = (Spinner)findViewById(R.id.spinner_material);
        spinLoca = (Spinner)findViewById(R.id.spinner_location);
        editYeAf = (EditText)findViewById(R.id.edit_after);
        editYeBe = (EditText)findViewById(R.id.edit_before);
        spinSort = (Spinner)findViewById(R.id.spinner_sort);
        buttHowto = (Button)findViewById(R.id.button_howto_library);
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
				// Put result to variable
				searchstring = editSear.getText().toString();
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
				switch(position)
				{
				case 0:
					scope = "1";
					break;
				case 1:
					scope = "2";
					break;
				case 2:
					scope = "3";
					break;
				case 3:
					scope = "4";
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Revert to default
				spinOnly.setSelection(3);
				scope = "4";
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
				switch(position)
				{
				case 0:
					lang = "";
					break;
				case 1:
					lang = "eng";
					break;
				case 2:
					lang = "fre";
					break;
				case 3:
					lang = "ger";
					break;
				case 4:
					lang = "ita";
					break;
				case 5:
					lang = "spa";
					break;
				case 6:
					lang = "por";
					break;
				case 7:
					lang = "rus";
					break;
				case 8:
					lang = "ice";
					break;
				case 9:
					lang = "ara";
					break;
				case 10:
					lang = "lat";
					break;
				case 11:
					lang = "grc";
					break;
				case 12:
					lang = "chi";
					break;
				case 13:
					lang = "heb";
					break;
				case 14:
					lang = "jpn";
					break;
				case 15:
					lang = "kor";
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Revert to default
				spinLang.setSelection(0);
				lang = "";
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
				switch(position)
				{
				case 0:
					mattype = "";
					break;
				case 1:
					mattype = "k";
					break;
				case 2:
					mattype = "c";
					break;
				case 3:
					mattype = "l";
					break;
				case 4:
					mattype = "a";
					break;
				case 5:
					mattype = "h";
					break;
				case 6:
					mattype = "q";
					break;
				case 7:
					mattype = "o";
					break;
				case 8:
					mattype = "g";
					break;
				case 9:
					mattype = "s";
					break;
				case 10:
					mattype = "t";
					break;
				case 11:
					mattype = "v";
					break;
				case 12:
					mattype = "@";
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Revert to default
				spinMate.setSelection(0);
				mattype = "";
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
				switch(position)
				{
				case 0:
					branch = "";
					break;
				case 1:
					branch = "net";
					break;
				case 2:
					branch = "bl";
					break;
				case 3:
					branch = "caree";
					break;
				case 4:
					branch = "ebl";
					break;
				case 5:
					branch = "mdl";
					break;
				case 6:
					branch = "mdsjh";
					break;
				case 7:
					branch = "blspc";
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				//Revert to default
				spinLoca.setSelection(0);
				branch = "";
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
				Da = editYeAf.getText().toString();
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
				Db = editYeBe.getText().toString();
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
				switch(position)
				{
				case 0:
					sort = "D";
					break;
				case 1:
					sort = "A";
					break;
				case 2:
					sort = "R";
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?>  parent) {
				// Sort must have a value
				spinSort.setSelection(0);
				sort = "D";
			}
		});
        
        buttHowto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(LibrarySearch.this)
				.setTitle(R.string.howto)
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
				// Verify and start the searching activity
				if (searchstring == null || searchstring.length() == 0) {
					Toast.makeText(LibrarySearch.this, getString(R.string.toast_lib_search), Toast.LENGTH_SHORT)
					.show();
				}
				else {
					startActivity(new Intent(LibrarySearch.this, LibraryList.class)
						.putExtra("searchstring", searchstring)
						.putExtra("scope", scope)
						.putExtra("lang", lang)
						.putExtra("mattype", mattype)
						.putExtra("branch", branch)
						.putExtra("Da", Da)
						.putExtra("Db", Db)
						.putExtra("sort", sort)
					);
				}
			}
		});
        
        buttClea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Clear the preference to restore default value.
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						/**searchstring = null;
						scope = "4";
						lang = "";
						mattype = "";
						branch = "";
						Da = "";
						Db = "";
						sort = "D";*/
						editSear.setText("");
						spinOnly.setSelection(3);
						spinLang.setSelection(0);
						spinMate.setSelection(0);
						spinLoca.setSelection(0);
						editYeAf.setText("");
						editYeBe.setText("");
						spinSort.setSelection(0);
					}
				});
			}
		});
    }
    
    @Override
    public void onPause(){
    	// TODO 
    	super.onPause();
    		
    }
    
}
