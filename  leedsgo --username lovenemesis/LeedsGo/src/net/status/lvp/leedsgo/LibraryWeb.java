package net.status.lvp.leedsgo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class LibraryWeb extends Activity {
	
	private Intent receipt = null;
	
	private String searchstring = null;
	private String scope = null;
	private String lang = null;
	private String mattype = null;
	private String branch = null;
	private String Da = null;
	private String Db = null;
	private String sort = null;
	
	private WebView airpac = null;
	private Button buttBack = null;
	private Button buttHome = null;
	private Button buttForw =null;
	
	private static final String AIRPAC = "http://lib.leeds.ac.uk/airpac/";
	private static final String BASE_URL = "http://lib.leeds.ac.uk/airpac/search?action=search&indexcount=1&indexsetstart=0&sourcebrowse=avssearchpage&directhit=recordbrowse&itemstart=1&indexstart=1&searchtype=X";
	private static final String ACTION = "&targetbrowse=recordbrowse&recordcount=7&recordstart=1";
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_web);
        
        receipt = getIntent();
        searchstring = "&searchstring=" + receipt.getStringExtra("searchstring");
		scope = "&scope=" + receipt.getStringExtra("scope");
		lang = "&lang=" + receipt.getStringExtra("lang");
		mattype = "&mattype=" + receipt.getStringExtra("mattype");
		branch = "&branch=" + receipt.getStringExtra("branch");
		Da = "&Da=" + receipt.getStringExtra("Da");
		Db = "&Db=" + receipt.getStringExtra("Db");
		sort = "&sort=" + receipt.getStringExtra("sort");
        
        airpac = (WebView)findViewById(R.id.airpac);
        buttBack = (Button)findViewById(R.id.button_back);
        buttHome = (Button)findViewById(R.id.button_home);
        buttForw = (Button)findViewById(R.id.button_forward);
        
        airpac.getSettings().setJavaScriptEnabled(true);
        airpac.setWebViewClient(new myWebClient());
        airpac.loadUrl(BASE_URL+searchstring+scope+lang+mattype+branch+Da+Db+sort+ACTION);
        
        buttBack.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				airpac.goBack();
			}
		});
        
        buttHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
        
        buttForw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				airpac.goForward();
			}
		});
        
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig){        
        super.onConfigurationChanged(newConfig);
    }

    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && airpac.canGoBack()) {
            airpac.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
	
    private class myWebClient extends WebViewClient {
    	@Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
    		if(url.equalsIgnoreCase(AIRPAC+"search/")){
    			LibraryWeb.this.finish();
    		}
    		else{
    			if(url.startsWith(AIRPAC)){    			
    				view.loadUrl(url);
    			}
    			else {
    				new AlertDialog.Builder(LibraryWeb.this)
    				.setTitle(R.string.caution)
    				.setMessage(R.string.caution_lib_message)
    				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
    					
    					@Override
    					public void onClick(DialogInterface dialog, int which) {
    						// TODO Auto-generated method stub
    						
    					}
    				})
    				.show();
    			}
    		}
            return true;
        }
    	
    }
	
}
