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
        client = receipt.getStringExtra("client");
        if (client.equalsIgnoreCase("0"))
        	uri = "file:///android_asset/email_android.html";
        if (client.equalsIgnoreCase("1"))
        	uri = "file:///android_asset/email_k9.html";
        if (client.equalsIgnoreCase("2"))
        	uri = "file:///android_asset/email_htc.html";
        
        
        //Initialize the widget
        browser = (WebView)findViewById(R.id.WebView);
        browser.loadUrl(uri);
    }
}
