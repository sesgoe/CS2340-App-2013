package edu.gatech.wheresmystuff.views;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.presenters.EnterItemPresenter;

/**
 * Activity to perform a quick search.
 * 
 * @author Kevin
 */

public class QuickSearchActivity extends Activity implements IEnterItemView {
	/** Presenter to use */
	private EnterItemPresenter presenter;
	/** Item data from DB */
	private ItemDataSource itemdata;
	
	/**
	 * Start of activity
	 * @param savedInstanceState the instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_search);
		itemdata = new ItemDataSource(this);
		presenter = new EnterItemPresenter(this, itemdata);
	}
	
	/**
	 * Create options menu
	 * @param menu menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_loggedin, menu);
		return true;
	}
	
	/**
	 * Tell the presenter you want to quick search for this item name and location
	 * @param source (Not Used)
	 */
	public void onAddItemClick(View source) {
		String itemName = getItemNameField().getText().toString();
		String itemLoc = getDescField().getText().toString();

		//give the presenter the name and location you are searching for
		presenter.takeQuickSearch(itemName, itemLoc);
	}
	
	/**
	 * On cancel click, instead of invoking a presenter, just go back to previous screen
	 * @param source (Not Used)
	 */
	public void onCancelClick(View source) {
		advance(2);
	}
	
	/**
	 * Gets the EditText of the item name (to grab the text later)
	 * @return EditText field for the item name
	 */
	private EditText getItemNameField()     {
        return (EditText) findViewById(R.id.editItemName);
	}
	
	/**
	 * Gets the EditText of the item desc (to grab the text later)
	 * @return EditText field for the item desc
	 */
	//right now this is assigned to itemDescText when it should be some new location thing, idk how to make it though
	private EditText getDescField()     {
        return (EditText) findViewById(R.id.itemDescText);
	}
	
	/**
	 * Function to handle advancing the screen to the next one using a screenID (Messy, will clean up later)
	 */
	@Override
	public void advance(int screenID) {
		if(screenID == 1) { //show list
			Intent intent = new Intent(this, ShowItemsActivity.class);
			startActivity(intent);
		} 
		else if(screenID == 3){ //show quick search results
			Intent intent = new Intent(this, ShowQuickSearchResultsActivity.class);
			startActivity(intent);
		}
		else {
			Intent intent = new Intent(this, LoggedInActivity.class);
			startActivity(intent);
		}
	}
	
	/**
	 * Not used here, but provides functionality to pop up error messages from the presenter
	 */
	@Override
	public void errorAlert(String message) {
		ErrorAlert alert = new ErrorAlert(this, message);
		alert.show();
		
	}
	
}
