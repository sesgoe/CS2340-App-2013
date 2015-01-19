package edu.gatech.wheresmystuff.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.LoginModel;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.presenters.ManageUsersPresenter;

/**
 * Allows an admin to manage users (remove, unlock, make admin, etc.)
 * @author John
 *
 */
public class ManageUsersActivity extends Activity implements IManageUsers {
	
	/** Presenter to ues */
	private ManageUsersPresenter myPresenter;
	/** User data from DB */
	private UserDataSource userdata;
	
	/** Start of activity
	 * @param savedInstanceState the instance state
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_users);
		userdata = new UserDataSource(this);
		myPresenter = new ManageUsersPresenter(this, userdata, new LoginModel(userdata));
	}

	/**
	 * Creates options menu
	 * @param menu menu
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_manage_users, menu);
		return true;
	}
	
	/**
	 * Gets username from text field
	 * @return username
	 */
	private EditText getUsernameField()     {
        return (EditText) findViewById(R.id.manageUsername);
	}
	
	/**
	 * Calls presenter to make an admin
	 * @param source
	 */
	public void onMakeAdminClick(View source) {
		myPresenter.onMakeAdminClick(getUsernameField().getText().toString());
	}
	
	/**
	 * Goes back to the main page
	 * @param source
	 */
	public void onGoBackClick(View source) {
		Intent intent = new Intent(this, LoggedInActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Calls presenter to remove a user
	 * @param source
	 */
	public void onRemoveUserClick(View source) {
		myPresenter.onRemoveUserClick(getUsernameField().getText().toString());
	}
	
	/**
	 * 
	 * @param source
	 */
	public void onUnlockAccountClick(View source) {
		myPresenter.onUnlockAccountClick(getUsernameField().getText().toString());
	}

	/**
	 * Creates a new error alert
	 * @param message error message
	 */
	@Override
	public void alert(String message) {
		ErrorAlert alert = new ErrorAlert(this, message);
		alert.show();
		
	}
	
}
