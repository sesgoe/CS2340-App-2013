package edu.gatech.wheresmystuff.views;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.User;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.presenters.PersonListingPresenter;
import edu.gatech.wheresmystuff.support.MyPersonListAdapter;

/**
 * Our activity to show all the people in a list view
 * Since we derive from ListActivity, then we don't need
 * a special layout.xml file.
 * 
 * @author Ses
 *
 */
public class PersonListingActivity extends ListActivity implements IPersonListingView {

	/** the people to display in the activity */
	private User[] people;
	/** the presenter to use */
	private PersonListingPresenter myPresenter;
	/** User data from DB */
	private UserDataSource userdata;
	
	/**
	 * Start of activity
	 * @param savedInstanceState the instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//make our presenter
		userdata = new UserDataSource(this);
		
		userdata.open();
		
		userdata.updateList();
		people = new User[UserDataSource.USER_LIST.size()];
		for(int i=0; i<UserDataSource.USER_LIST.size(); i++) {
			people[i] = UserDataSource.USER_LIST.get(i);
		}
		
		//now make an instance of our adapter so that the data can be displayed
		MyPersonListAdapter adapt = new MyPersonListAdapter(this, people);
		//tell this list view to use the adapter
		setListAdapter(adapt);
		Log.d("Model", "Set adapter");
		userdata.close();
	}
	
	/**
	 * Resumes after DB work
	 */
	@Override
	protected void onResume() {
		userdata.open();
		super.onResume();
	}
	
	/**
	 * Pauses for DB work
	 */
	@Override
	protected void onPause() {
		userdata.close();
		super.onPause();
	}

	/**
	 * Called by the presenter to set the people that this list will display.
	 * 
	 * @param p Array of users
	 */
	@Override
	public void setPeople(User[] p) {
		people = p;		
	}

}
