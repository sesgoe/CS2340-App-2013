package edu.gatech.wheresmystuff.views;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.model.LoginModel;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.presenters.LoggedInPresenter;

/**
 * Activity for the screen representing being "Logged in" (Temp)
 * @author Ses
 *
 */
public class LoggedInActivity extends Activity implements ILoggedInView {
	/** Presenter to use */
	private LoggedInPresenter myPresenter;
	/** User data from DB */
	private UserDataSource userdata;
	/** Item data from DB */
	private ItemDataSource itemdata;
	
	/**
	 * Start of activity
	 * @param savedInstanceState current instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loggedin);
		userdata = new UserDataSource(this);
		userdata.open();
		userdata.updateMap();
		userdata.updateList();
		userdata.close();
		itemdata = new ItemDataSource(this);
		itemdata.open();
		itemdata.updateMap();
		itemdata.updateList();
		itemdata.close();
		myPresenter = new LoggedInPresenter(this, userdata, new LoginModel(userdata));
		TextView textView = (TextView) findViewById(R.id.textView2);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String username = prefs.getString("username", "null");
		if(myPresenter.isAdmin(username)) {
			showHidden();
		}
		textView.setText(username);
	}

	/**
	 * Creates options menu
	 * @param menu Menu to create
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_loggedin, menu);
		return true;
	}
	
	/**
	 * When you hit the add item button, go to the add item screen
	 * @param source
	 */
	public void onAddItemClick(View source) {
		Intent intent = new Intent(this, EnterItemActivity.class);
		startActivity(intent);
	}
	
	/**
	 * When you hit the add found item button, go to the add found item screen
	 * @param source
	 */
	public void onAddFoundItemClick(View source) {
		Intent intent = new Intent(this, EnterFoundItemActivity.class);
		startActivity(intent);
	}
	
	/**
	 * When you hit the list items button, go to the list items screen
	 * @param source
	 */
	public void onListItemsClick(View source) {
		Intent intent = new Intent(this, ShowItemsActivity.class);
		startActivity(intent);
	}
	
	/**
	 * When you hit the quick search button, go to the quick search screen
	 * @param source
	 */
	public void onQuickSearchClick(View source){
		Intent intent = new Intent(this, ShowQuickSearchResultsActivity.class);
		startActivity(intent);
	}
	
	/**
	 * When you hit the list items button, go to the list items screen
	 * @param source
	 */
	public void onSearchClick(View source) {
		Intent intent = new Intent(this, SearchItemsActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Goes to the manage uesrs screens
	 * @param source
	 */
	public void onManageUsersClick(View source) {
		Intent intent = new Intent(this, ManageUsersActivity.class);
		startActivity(intent);
	}

	/**
	 * Shows the admin only function to manage users
	 */
	@Override
	public void showHidden() {
		Button manageUsers = (Button) findViewById(R.id.manageUsersButton);
		manageUsers.setVisibility(View.VISIBLE);
	}
	
}
