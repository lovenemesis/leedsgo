package net.status.lvp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;

public class RssGuide extends Activity {
	
	private RadioGroup rgRss = null;
	private RadioButton rbUol = null;
	private RadioButton rbLib = null;
	private Button buttInst = null;
	private Button buttHowto = null;
	private Button buttAdd = null;
    private String subs = null;
    private static final String RSS_UOL = "http://www.leeds.ac.uk/rss/news";
    private static final String RSS_LIB = "http://library.leeds.ac.uk/rss";
    private static final String FEED_READER = "market://details?id=org.openintents.news";
    

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rss_guide);
        
        rgRss = (RadioGroup)findViewById(R.id.rg_rss);
        rbUol = (RadioButton)findViewById(R.id.rb_uol);
        rbLib = (RadioButton)findViewById(R.id.rb_lib);
        buttInst = (Button)findViewById(R.id.button_news_reader);
        buttHowto = (Button)findViewById(R.id.button_howto_rss);
        buttAdd = (Button)findViewById(R.id.button_add_subs);
        
       
        buttInst.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(FEED_READER)));
			}
		});
        

        rgRss.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Get the checked radio button id
				if(rbUol.isChecked())
					subs = RSS_UOL;
				if(rbLib.isChecked())
					subs = RSS_LIB;
			}
		});
        
        buttHowto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(RssGuide.this)
				.setTitle(R.string.howto)
				.setMessage(R.string.help_rss_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (subs == null) {
					Toast.makeText(RssGuide.this, getString(R.string.toast_rss), Toast.LENGTH_SHORT)
					.show();
				}
				else {
					((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(subs);
					Toast.makeText(RssGuide.this, getString(R.string.toast_add), Toast.LENGTH_SHORT)
					.show();
				}
			}
		});
        
    }
}