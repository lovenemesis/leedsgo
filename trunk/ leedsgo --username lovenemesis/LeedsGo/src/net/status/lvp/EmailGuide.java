package net.status.lvp;

import android.app.Activity;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;


public class EmailGuide extends Activity {
	
	private Intent receipt =null;
	private WebView browser = null;
	private String username;
	private String client;
	private Button buttPer = null;
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
        buttPer = (Button)findViewById(R.id.button_personalize);
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
        
        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_guide), Toast.LENGTH_SHORT)
		.show();

        
        buttEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = username +"@leeds.ac.uk";
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(email);
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_email)+email, Toast.LENGTH_SHORT)
				.show();
			}
		});
        
        buttPer.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		        browser.loadUrl("javascript:changeText('" + username + "')");
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_per), Toast.LENGTH_SHORT)
				.show();
			}
		});
        
        buttIMAP.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String imap = username +".imap.leeds.ac.uk";
				((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(imap);
		        Toast.makeText(EmailGuide.this, getString(R.string.toast_email_imap)+imap, Toast.LENGTH_SHORT)
				.show();
			}
		});
        
    }
}
