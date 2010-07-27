package net.status.lvp.leedsgo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class LibraryWeb extends Activity {
	
	private WebView airpac = null;
	private Button buttReturn = null;
	private Button buttHome = null;
	private Button buttForw =null;
	
	private static final String AIRPAC = "http://lib.leeds.ac.uk/airpac/";

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_web);
        
        airpac = (WebView)findViewById(R.id.airpac);
        buttReturn = (Button)findViewById(R.id.button_return_view);
        buttHome = (Button)findViewById(R.id.button_home);
        buttForw = (Button)findViewById(R.id.button_forward);
        
        airpac.getSettings().setJavaScriptEnabled(true);
        airpac.setWebViewClient(new myWebClient());
        airpac.loadUrl(AIRPAC);
        
        buttReturn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        buttHome.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				airpac.loadUrl(AIRPAC);
			}
		});
        
        buttForw.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				airpac.goForward();
			}
		});
        
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
            view.loadUrl(url);
            return true;
        }
    	
    }
	
}
