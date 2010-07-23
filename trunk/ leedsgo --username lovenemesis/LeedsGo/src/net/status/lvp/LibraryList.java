package net.status.lvp;

import android.app.Activity;
import android.content.Intent;
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
        
    }
}
