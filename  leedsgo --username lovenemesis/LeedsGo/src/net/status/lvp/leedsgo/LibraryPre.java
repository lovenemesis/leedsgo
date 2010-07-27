package net.status.lvp.leedsgo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LibraryPre extends Activity {
	
	private RadioGroup rgLib = null;
	private RadioButton rbNat = null;
	private RadioButton rbWeb = null;
	private Button buttView = null; 
	
	private Intent intent = null;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_pre);
        
        rgLib = (RadioGroup)findViewById(R.id.rg_lib);
        rbNat = (RadioButton)findViewById(R.id.rb_lib_native);
        rbWeb = (RadioButton)findViewById(R.id.rb_lib_web);
        buttView = (Button)findViewById(R.id.button_view_lib);
        
        rgLib.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Get the checked radio button id
				if(rbNat.isChecked())
					intent = new Intent(LibraryPre.this, LibrarySearch.class);
				if(rbWeb.isChecked())
					intent = new Intent(LibraryPre.this, LibraryWeb.class);
			}
		});
        
        buttView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (intent == null) {
					Toast.makeText(LibraryPre.this, getString(R.string.toast_lib_pre), Toast.LENGTH_SHORT)
					.show();
				}
				else {
					startActivity(intent);
				}
			}
		});
        
    }
	
}
