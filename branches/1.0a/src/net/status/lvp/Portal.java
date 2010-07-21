package net.status.lvp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;

public class Portal extends Activity {
	
	private TextView rowL = null;
	private TextView rowE = null;
	private TextView rowR = null;
	private TextView rowM = null;
	private Button buttAU = null;
	private Button buttAI = null;
	private Button buttAM = null; 
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Initialise list and buttons.
        rowL = (TextView)findViewById(R.id.text_title_library);
        rowE = (TextView)findViewById(R.id.text_title_email);
        rowR = (TextView)findViewById(R.id.text_title_rss);
        rowM = (TextView)findViewById(R.id.text_title_map);
        buttAU = (Button)findViewById(R.id.button_about_uol);
        buttAI = (Button)findViewById(R.id.button_about_iss);
        buttAM = (Button)findViewById(R.id.button_about_me);
        
        
        //Setup listeners for click events.
        rowL.setOnClickListener(new View.OnClickListener() {
			//Library List
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Portal.this, LibrarySearch.class));
			}
		});
        
        rowE.setOnClickListener(new View.OnClickListener() {
			//Email List
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Portal.this, EmailPre.class));
			}
		});
        
        rowR.setOnClickListener(new View.OnClickListener() {
			//Email List
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Portal.this, RssGuide.class));
			}
		});
        
        rowM.setOnClickListener(new View.OnClickListener() {
			//Email List
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Portal.this, MapGuide.class));
			}
		});
       
        
        buttAU.setOnClickListener(new View.OnClickListener() {
			//Button About University of Leeds.
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Portal.this)
				.setTitle(R.string.about_uol)
				.setMessage(R.string.about_uol_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttAI.setOnClickListener(new View.OnClickListener() {
        	//Button About ISS@Leeds
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Portal.this)
				.setTitle(R.string.about_iss)
				.setMessage(R.string.about_iss_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttAM.setOnClickListener(new View.OnClickListener() {
        	//Button About this application
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Portal.this)
				.setTitle(R.string.about_me)
				.setMessage(R.string.about_me_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
    }
}