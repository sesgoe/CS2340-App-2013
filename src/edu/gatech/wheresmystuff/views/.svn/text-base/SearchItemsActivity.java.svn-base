package edu.gatech.wheresmystuff.views;

import edu.gatech.wheresmystuff.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Search for items
 * @author John
 *
 */
public class SearchItemsActivity extends Activity implements IEnterItemView {
	/** name to search for */
	public static String searchName;
	/** category to search for */
	public static String category;

	/**
	 * Start of activity
	 * Sets layout to use
	 * @param savedInstanceState the instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
	}
	
	/**
	 * Creates options menu
	 * @param menu menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_loggedin, menu);
		return true;
	}
	
	/**
	 * Advances screen to shown searched for items
	 * @param source
	 */
	public void onSearchClick(View source){
		String searchName = getSearchNameField().getText().toString();
		String itemCategory = getCategory().getSelectedItem().toString();
		this.searchName=searchName;
		this.category=itemCategory;
		advance(1);
	}
	
	/**
	 * Get name from text field
	 * @return The name to search for
	 */
	private EditText getSearchNameField()     {
        return (EditText) findViewById(R.id.editSearchName);
	}
	
	/**
	 * Get category from spinner
	 * @return The category to search for
	 */
	private Spinner getCategory()     {
        return (Spinner) findViewById(R.id.searchSpinnerCategory);
	}
	
	/**
	 * Advances to next screens
	 * 1 = ShowSearchResults
	 * Else = LoggedInActivity
	 */
	public void advance(int screenID) {
		if(screenID == 1) { //show list
			Intent intent = new Intent(this, ShowSearchResultsActivity.class);
			startActivity(intent);}
		else {
			Intent intent = new Intent(this, LoggedInActivity.class);
			startActivity(intent);}
	}
	
	/**
	 * Makes an error alert
	 * @param message Error message
	 */
	public void errorAlert(String message) {
		ErrorAlert alert = new ErrorAlert(this, message);
		alert.show();
	}

}
