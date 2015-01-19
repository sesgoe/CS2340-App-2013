package edu.gatech.wheresmystuff.views;

import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.Item;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.presenters.ItemListingPresenter;
import edu.gatech.wheresmystuff.support.ItemListAdapter;

/**
 * Activity to show the quick search results
 * 
 * @author Kevin
 * 
 */
public class ShowQuickSearchResultsActivity extends ListActivity implements
		IItemListingView {

	/** the items to display in the activity */
	private Item[] items;
	/** the presenter to use */
	private ItemListingPresenter myPresenter;
	/** Item data from DB */
	private ItemDataSource itemdata;

	/**
	 * Start of activity. Shows list of items matching search.
	 * @param savedInstanceState instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quick_search_results);
		itemdata = new ItemDataSource(this);
		// make our presenter
		myPresenter = new ItemListingPresenter(new InMemoryModel(), this);
		// now make an instance of our adapter so that the data can be displayed
		ItemListAdapter adapt = new ItemListAdapter(this, items);
		// tell this list view to use the adapter
		setListAdapter(adapt);
		Log.d("Model", "Set adapter");

		List<Item> tempItems = itemdata.getAllItemsMatching();
		
		Item[] tempItemsArray = new Item[tempItems.size()];
		for (int i = 0; i < tempItems.size(); i++) {
			tempItemsArray[i] = tempItems.get(i);
		}

		ItemListAdapter adapt2 = new ItemListAdapter(this, tempItemsArray);
		setListAdapter(adapt2);

	}

	/**
	 * Goes back to main logged in page
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
