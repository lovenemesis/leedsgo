package net.status.lvp.leedsgo;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;


public class EmailGuide extends Activity {
	
	private Intent receipt =null;
	private WebView browser = null;
	private String username;
	private String client;
	private Button buttUser = null;
	private Button buttEmail = null;
	private Button buttIMAP = null;
	private static final String ASSET_EMAIL_ANDROID = "file:///android_asset/email_android.html";
	private static final String ASSET_EMAIL_K9 = "file:///android_asset/email_k9.html";
	private static final String ASSET_EMAIL_HTC = "file:///android_asset/email_htc.html";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_guide);
        
        // Initialize the values

        browser = (WebView)findViewById(R.id.WebView);
        browser.getSettings().setJavaScriptEnabled(true);
        buttUser = (Button)findViewById(R.id.button_copy_user);
        buttEmail = (Button)findViewById(R.id.button_copy_email);
        buttIMAP = (Button)findViewById(R.id.button_copy_imap);
        receipt = getIntent();
        username = receipt.getStringExtra("username");
        client = receipt.getStringExtra("client");
        
        
        //Load different local html files according to clients.
        if (client.equalsIgnoreCase(getString(R.string.email_android))){
        	browser.loadUrl(ASSET_EMAIL_ANDROID);
        }
        if (client.equalsIgnoreCase(getString(R.string.email_k9))){
        	browser.loadUrl(ASSET_EMAIL_K9);
        }       
        if (client.equalsIgnoreCase(getString(R.string.email_htc))){
        	browser.loadUrl(ASSET_EMAIL_HTC);
        }
                
        new AlertDialog.Builder(EmailGuide.this)
        .setCancelable(false)
		.setTitle(R.string.help_email_guide)
		.setMessage(R.string.help_email_guide_message)
		.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				//Invoke JS method to change username when close
				browser.loadUrl("javascript:changeText('" + username + "')");
			}
		})
		.show();
        
        
        buttEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Copy email address.
				String email = username +"@leeds.ac.uk";
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(email);
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_email)+email, Toast.LENGTH_LONG)
				.show();
			}
		});
        
        buttUser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Copy username.
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(username);
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_user)+username, Toast.LENGTH_LONG)
				.show();
			}
		});
        
        buttIMAP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Copy IMAP address.
				String imap = username +".imap.leeds.ac.uk";
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(imap);
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_imap)+imap, Toast.LENGTH_LONG)
				.show();
			}
		});
        
    }
        
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }
}
