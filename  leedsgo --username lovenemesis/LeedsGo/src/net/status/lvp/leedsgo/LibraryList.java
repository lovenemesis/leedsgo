package net.status.lvp.leedsgo;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

public class LibraryList extends Activity {
	
	private Intent receipt = null;
	
	private String searchstring = null;
	private String scope = null;
	private String lang = null;
	private String mattype = null;
	private String branch = null;
	private String Da = null;
	private String Db = null;
	private String sort = null;
	private static final String BASE_URL = "http://lib.leeds.ac.uk/airpac/search?action=search&indexcount=1&indexsetstart=0&sourcebrowse=avssearchpage&directhit=recordbrowse&itemstart=1&indexstart=1&searchtype=X";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_list);
        
        receipt = getIntent();
        searchstring = receipt.getStringExtra("searchstring");
		scope = receipt.getStringExtra("scope");
		lang = receipt.getStringExtra("lang");
		mattype = receipt.getStringExtra("mattype");
		branch = receipt.getStringExtra("branch");
		Da = receipt.getStringExtra("Da");
		Db = receipt.getStringExtra("Db");
		sort = receipt.getStringExtra("sort");
		
		Toast.makeText(LibraryList.this, searchstring + "\n" +
				scope + "\n" +
				lang + "\n" +
				mattype + "\n" +
				branch + "\n" +
				Da + "\n" +
				Db + "\n" +
				sort, Toast.LENGTH_LONG)
		.show();
		
		try{
			new LibraryParser().execute(new URL(BASE_URL));
		}
        catch(MalformedURLException e){
        	Toast.makeText(LibraryList.this,
        			"Wrong URL was passed" +
        			searchstring + "\n" +
    				scope + "\n" +
    				lang + "\n" +
    				mattype + "\n" +
    				branch + "\n" +
    				Da + "\n" +
    				Db + "\n" +
    				sort,
    				Toast.LENGTH_LONG)
    		.show();
        }
    }
    
    
    
    
    private class LibraryParser extends AsyncTask<URL, Void, LibraryBook[]>{
    	protected void  onPreExecute(){
    		
    		
    	}
    	
    	protected LibraryBook[] doInBackground(URL... urls){
    		
    		return null;
    	}
    	
    	protected void onProgressUpdate(Void... unused){
    		
    		
    	}
    	
    	protected void  onPostExecute(LibraryBook[] books){
    		
    		
    	}
    }
    
    
}
