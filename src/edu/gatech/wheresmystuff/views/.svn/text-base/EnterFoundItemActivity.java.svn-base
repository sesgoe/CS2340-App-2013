package edu.gatech.wheresmystuff.views;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.presenters.EnterItemPresenter;

/**
 * Enter found item activity/screen
 * @author Kevin
 */
public class EnterFoundItemActivity extends Activity implements IEnterItemView {
	
	/** Presenter for entering items */
	private EnterItemPresenter presenter;
	/** Item Data source from DB */
	private ItemDataSource itemdata;
	
	/**
	 * Start activity
	 * @param savedInstanceState instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_item);
		itemdata = new ItemDataSource(this);
		presenter = new EnterItemPresenter(this, itemdata);
	}
	
	/**
	 * Create buttons on screen
	 * @param menu Menu of buttons to create
	 * @return true
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_loggedin, menu);
		return true;
	}
	
	/**
	 * Add an item on click by sending it to the presenter
	 * @param source (Not Used)
	 */
	public void onAddItemClick(View source) {
		String itemName = getItemNameField().getText().toString();
		String itemDesc = getDescField().getText().toString();
		String itemCategory = getCategory().getSelectedItem().toString();
		String day = ((Spinner) findViewById(R.id.postSpinnerMonth)).getSelectedItem().toString();
		String month = ((Spinner) findViewById(R.id.postSpinnerDay)).getSelectedItem().toString();
		String year = ((Spinner) findViewById(R.id.postSpinnerYear)).getSelectedItem().toString();
		
		//by default when you create an item its location is set to atlanta 
		//need to change it later so you can add in location on creation
		if(!day.equals("Day") && !month.equals("Month") && !year.equals("Year")){
			presenter.onAddItemClick(itemName, itemDesc, "found", itemCategory, new Date(Integer.parseInt(year)-1900,Integer.parseInt(month)-1,Integer.parseInt(day)), "Atlanta");
		} else {
			presenter.onAddItemClick(itemName, itemDesc, "found", itemCategory, new Date(), "Atlanta");
		}
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
	private EditText getDescField()     {
        return (EditText) findViewById(R.id.itemDescText);
	}
	
	/**
	 * Gets the Spinner of the item category (to grab the text later)
	 * @return Spinner field for the item category
	 */
	private Spinner getCategory()     {
        return (Spinner) findViewById(R.id.categorySpinner);
	}
	
	/**
	 * Function to handle advancing the screen to the next one using a screenID (Messy, will clean up later)
	 * @param screenID current screen
	 */
	@Override
	public void advance(int screenID) {
		if(screenID == 1) { //show list
			Intent intent = new Intent(this, ShowItemsActivity.class);
			startActivity(intent);
		} else {
			Intent intent = new Intent(this, LoggedInActivity.class);
			startActivity(intent);
		}
	}
	
	/**
	 * Not used here, but provides functionality to pop up error messages from the presenter
	 * @param message Error message
	 */
	@Override
	public void errorAlert(String message) {
		ErrorAlert alert = new ErrorAlert(this, message);
		alert.show();
		
	}

}