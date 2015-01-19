package edu.gatech.wheresmystuff.views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.R.layout;
import edu.gatech.wheresmystuff.R.menu;
import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.Item;
import edu.gatech.wheresmystuff.model.User;
import edu.gatech.wheresmystuff.presenters.ItemListingPresenter;
import edu.gatech.wheresmystuff.presenters.PersonListingPresenter;
import edu.gatech.wheresmystuff.support.ItemListAdapter;
import edu.gatech.wheresmystuff.support.MyPersonListAdapter;
import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Our activity to show all the people in a list view
 * Since we derive from ListActivity, then we don't need
 * a special layout.xml file.
 * 
 * @author Ses
 *
 */
public class ShowItemsActivity extends ListActivity implements IItemListingView {

	/** the items to display in the activity */
	private Item[] items;
	/** the presenter to use */
	private ItemListingPresenter myPresenter;
	
	/**
	 * Start of activity. Sets presenter, view, and ItemListAdapter to use
	 * @param savedInstanceState The instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_items);
		//make our presenter
		myPresenter = new ItemListingPresenter(new InMemoryModel(), this);
		//now make an instance of our adapter so that the data can be displayed
		ItemListAdapter adapt = new ItemListAdapter(this, items);
		//tell this list view to use the adapter
		setListAdapter(adapt);
		Log.d("Model", "Set adapter");
	}
	
	/**
	 * Filters the item list. Can filter by multiple fields or only some.
	 * Fields to filter by: Category, status, date
	 * Can also filter by partial dates (i.e. After 2013)
	 * @param source Current view
	 */
	public void onFilterClick(View source) {
		String category = ((Spinner) findViewById(R.id.sortSpinnerCategory)).getSelectedItem().toString();
		String status = ((Spinner) findViewById(R.id.sortSpinnerStatus)).getSelectedItem().toString();
		String date = ((Spinner) findViewById(R.id.sortSpinnerDate)).getSelectedItem().toString();
		String day = ((Spinner) findViewById(R.id.sortSpinnerMonth)).getSelectedItem().toString();
		String month = ((Spinner) findViewById(R.id.sortSpinnerDay)).getSelectedItem().toString();
		String year = ((Spinner) findViewById(R.id.sortSpinnerYear)).getSelectedItem().toString();
		Item[] tempItems = items;
		
		if(!category.equals("All Categories")){
			tempItems = filterByCategory(category, tempItems);
		}
		
		if(!status.equals("Lost and Found")){
			tempItems = filterByStatus(status, tempItems);
		}
		
		if(!year.equals("Year")){
			tempItems = filterByDate(date, tempItems, month, day, year);
		}
		
		ItemListAdapter adapt = new ItemListAdapter(this, tempItems);
		setListAdapter(adapt);
		
	}
	
	/**
	 * Returns to main LoggedInActivity
	 * @param source
	 */
	public void onReturnClick(View source) {
		Intent intent = new Intent(this, LoggedInActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Providing functionality for our presenter again
	 */
	public void setItems(Item[] i) {
		items = i;		
	}
	
	/**
	 * Filters a list by a category
	 * @param category Category to filter by
	 * @param itemList List of items to filter
	 * @return List of filtered items
	 */
	public Item[] filterByCategory(String category, Item[] itemList) {
		ArrayList<Item> tempItems = new ArrayList<Item>();
		
		for(Item item : itemList){
			if(item.getCategory().equals(category)){
				tempItems.add(item);
			}
		}
		
		Item[] tempItemsArray = new Item[tempItems.size()];
		for(int i = 0 ; i < tempItems.size() ; i++){
			tempItemsArray[i] = tempItems.get(i);
		}
		
		return tempItemsArray;
	}
	
	/**
	 * Filters either lost or found items
	 * @param status lost or found
	 * @param itemList list of items
	 * @return Filtered item list
	 */
	public Item[] filterByStatus(String status, Item[] itemList) {
		ArrayList<Item> tempItems = new ArrayList<Item>();
		if(status.equals("Only Lost")){
			status = "lost";
		} else {
			status = "found";
		}
		for(Item item : itemList){
			if(item.getStatus().equals(status)){
				tempItems.add(item);
			}
		}
		
		Item[] tempItemsArray = new Item[tempItems.size()];
		for(int i = 0 ; i < tempItems.size() ; i++){
			tempItemsArray[i] = tempItems.get(i);
		}
		
		return tempItemsArray;
	}
	
	/**
	 * Filters items posted before or after a specified date
	 * @param status Lost or Found
	 * @param itemList List of items
	 * @param date Before or After specified date
	 * @param month Month to compare to
	 * @param day Day to compare to
	 * @param year Year to compare to
	 * @return Array of items posted before or after specified date
	 */
	public Item[] filterByDate(String date, Item[] itemList, String month, String day, String year) {
		ArrayList<Item> tempItems = new ArrayList<Item>();
		
		int m = 0;
		if(!month.equals("Month")){
			m = Integer.parseInt(month)-1;
		}
		
		int d = 1;
		if(!day.equals("Day")){
			d = Integer.parseInt(day);
		}
		
		int y = Integer.parseInt(year);
		Date compDate = new Date(y-1900, m, d);
		
		for(Item item : itemList){
			if(item.getDate().compareTo(compDate)<0 && date.equals("Before")){
				tempItems.add(item);	
			} else if(item.getDate().compareTo(compDate)>0 && date.equals("After")){
				tempItems.add(item);
			}
		}
		
		Item[] tempItemsArray = new Item[tempItems.size()];
		for(int i = 0 ; i < tempItems.size() ; i++){
			tempItemsArray[i] = tempItems.get(i);
		}
		
		return tempItemsArray;
	}
	
}
