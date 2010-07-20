package net.status.lvp;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Intent;
import android.util.Log;


public class EmailGuide extends Activity {
	
	private Intent receipt =null;
	private WebView browser = null;
	private String username;
	private String client;
	private static final String ASSET_EMAIL_ANDROID = "file:///android_asset/email_android.html";
	private static final String ASSET_EMAIL_K9 = "file:///android_asset/email_k9.html";
	private static final String ASSET_EMAIL_HTC = "file:///android_asset/email_htc.html";
	private static final String LOG_TAG = "EmailGuide";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_guide);
        
        // Initialize the values

        browser = (WebView)findViewById(R.id.WebView);
        browser.getSettings().setJavaScriptEnabled(true);
        receipt = getIntent();
        username = receipt.getStringExtra("username");
        client = receipt.getStringExtra("client");
        Log.d(LOG_TAG, "Retrived from intents.");
        //Load different local html files according to clients.
        if (client.equalsIgnoreCase(getString(R.string.email_android))){
        	browser.loadUrl(ASSET_EMAIL_ANDROID);
        	Log.d(LOG_TAG, "Load android html.");
        }
        
        if (client.equalsIgnoreCase(getString(R.string.email_k9))){
        	browser.loadUrl(ASSET_EMAIL_K9);
        	Log.d(LOG_TAG, "Load K9 html.");
        }
        
        if (client.equalsIgnoreCase(getString(R.string.email_htc))){
        	browser.loadUrl(ASSET_EMAIL_HTC);
        	Log.d(LOG_TAG, "Load HTC html.");
        }
        browser.loadUrl("javascript:changeText("+username+")");
        Log.d(LOG_TAG, "Load javascript.");
    }
}
