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

public class MapGuide extends Activity {
	
	private Button buttMap = null;
	private Button buttPDF = null;
	private Button buttFlash = null;
	private RadioGroup rgMap = null;
	private RadioButton rbMV = null;
	private RadioButton rbPV = null;
	private RadioButton rbFV = null;
	private Button buttHowto = null;
	private Button buttView = null;
    private Intent intent = null;
    private static final String MAP_VIEWER = "market://details?id=com.google.android.apps.maps";
    private static final String PDF_VIEWER = "market://details?id=com.adobe.reader";
    private static final String FLASH_VIEWER = "market://details?id=com.adobe.flashplayer";
    private static final String GEO_UOL = "geo:53.807988,-1.55448?z=16";
    private static final String PDF_MAP = "http://www.leeds.ac.uk/downloads/014257_campus_map_A3_fold.pdf";
    private static final String FLASH_MAP = "http://www.leeds.ac.uk/site/custom_scripts/campus_map/";
    

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_guide);
        
        buttMap = (Button)findViewById(R.id.button_map_viewer);
        buttPDF = (Button)findViewById(R.id.button_pdf_viewer);
        buttFlash = (Button)findViewById(R.id.button_flash_viewer);
        rgMap= (RadioGroup)findViewById(R.id.rg_map);
        rbMV = (RadioButton)findViewById(R.id.rb_mapviewer);
        rbPV = (RadioButton)findViewById(R.id.rb_pdfviewer);
        rbFV = (RadioButton)findViewById(R.id.rb_flashviewer);
        buttHowto = (Button)findViewById(R.id.button_howto_map);
        buttView = (Button)findViewById(R.id.button_view_map);
        
       
        buttMap.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(MAP_VIEWER)));
			}
		});
        
        buttPDF.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(PDF_VIEWER)));
			}
		});
        
        buttFlash.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(FLASH_VIEWER)));
			}
		});
        

        rgMap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// Get the checked radio button id
				if(rbMV.isChecked())
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse(GEO_UOL));
				if(rbPV.isChecked())
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse(PDF_MAP));
				if(rbFV.isChecked())
					intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FLASH_MAP));
			}
		});
        
        buttHowto.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(MapGuide.this)
				.setTitle(R.string.howto)
				.setMessage(R.string.help_map_message)
				.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				})
				.show();
			}
		});
        
        buttView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (intent == null) {
					Toast.makeText(MapGuide.this, getString(R.string.toast_map), Toast.LENGTH_SHORT)
					.show();
				}
				else {
					startActivity(intent);
				}
			}
		});
        
    }
}