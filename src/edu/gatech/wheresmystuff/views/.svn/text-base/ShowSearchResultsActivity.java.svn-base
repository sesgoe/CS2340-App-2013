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
 * Activity to show the quick search results
 * 
 * @author Hillary
 * 
 */
public class ShowSearchResultsActivity extends ListActivity implements
		IItemListingView {

	/** the items to display in the activity */
	private Item[] items;
	/** the presenter to use */
	private ItemListingPresenter myPresenter;

	/**
	 * Start of activity. Shows list of search results.
	 * @param savedInstanceState the instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results);
		myPresenter = new ItemListingPresenter(new InMemoryModel(), this);
		// now make an instance of our adapter so that the data can be displayed
		ItemListAdapter adapt = new ItemListAdapter(this, items);
		// tell this list view to use the adapter
		setListAdapter(adapt);
		Log.d("Model", "Set adapter");

		ArrayList<Item> tempItems = new ArrayList<Item>();

		for (Item i : items) {
			if (i.getName().equalsIgnoreCase(SearchItemsActivity.searchName)
					|| i.getCategory().equalsIgnoreCase(SearchItemsActivity.category)) {
				tempItems.add(i);
			}
		}
		
		Item[] tempItemsArray = new Item[tempItems.size()];
		for (int i = 0; i < tempItems.size(); i++) {
			tempItemsArray[i] = tempItems.get(i);
		}

		ItemListAdapter adapt2 = new ItemListAdapter(this, tempItemsArray);
		setListAdapter(adapt2);

	}

	/**
	 * Returns to main logged in activity
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

}
