package net.status.lvp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;

public class EmailPre extends Activity {
	
	private EditText editUser = null;
	private RadioGroup rgEmail = null;
	private RadioButton rbAnd = null;
	private RadioButton rbK9 = null;
	private RadioButton rbHtc = null;
	private Button buttHowto = null;
	private Button buttGuide = null;
	private String username = null;
    private String client = null;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_pre);
        
        editUser = (EditText)findViewById(R.id.edit_username);
        rgEmail = (RadioGroup)findViewById(R.id.rg_email);
        rbAnd = (RadioButton)findViewById(R.id.rb_android);
        rbK9 = (RadioButton)findViewById(R.id.rb_k9);
        rbHtc = (RadioButton)findViewById(R.id.rb_htc);
        buttHowto = (Button)findViewById(R.id.button_howto_email);
        buttGuide = (Button)findViewById(R.id.button_guide);
        
       
        editUser.addTextChangedListener(new TextWatcher() {
			
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
				// Store username to local variable
				username = editUser.getText().toString();
			}
		});
        

        rgEmail.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Get the checked radio button id
				if(rbAnd.isChecked())
					client = getString(R.string.email_android);
				if(rbK9.isChecked())
					client = getString(R.string.email_k9);
				if(rbHtc.isChecked())
					client = getString(R.string.email_htc);		
			}
		});
        
        buttHowto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(EmailPre.this)
				.setTitle(R.string.howto)
				.setMessage(R.string.help_email_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttGuide.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (username == null || client == null) {
					Toast.makeText(EmailPre.this, getString(R.string.toast_email), Toast.LENGTH_SHORT)
					.show();
				}
				else {
					startActivity(new Intent(EmailPre.this, EmailGuide.class)
						.putExtra("username", username)
						.putExtra("client", client));
				}
			}
		});
        
    }
}
