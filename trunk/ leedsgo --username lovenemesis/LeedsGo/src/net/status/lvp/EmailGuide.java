package net.status.lvp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Intent;


public class EmailGuide extends Activity {
	
	private Intent receipt =null;
	private WebView browser = null;
	private String username;
	private String imap;
	private String address;
	private String client;
	private String uri = null;
	private static final String ASSET_EMAIL_ANDROID = "file:///android_asset/email_android.html";
	private static final String ASSET_EMAIL_K9 = "file:///android_asset/email_k9.html";
	private static final String ASSET_EMAIL_HTC = "file:///android_asset/email_htc.html";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_guide);
        
        // Initialize the values
        receipt = getIntent();
        username = receipt.getStringExtra("username");
        imap = username + ".imap.leeds.ac.uk";
        address = username + "@leeds.ac.uk";
        browser = (WebView)findViewById(R.id.WebView);
        client = receipt.getStringExtra("client");
        
        //Load different local html files according to clients.
        if (client.equalsIgnoreCase(getString(R.string.email_android)))
        	browser.loadUrl(ASSET_EMAIL_ANDROID);
        if (client.equalsIgnoreCase(getString(R.string.email_k9)))
        	browser.loadUrl(ASSET_EMAIL_K9);
        if (client.equalsIgnoreCase(getString(R.string.email_htc)))
        	browser.loadUrl(ASSET_EMAIL_HTC);
    }
}
