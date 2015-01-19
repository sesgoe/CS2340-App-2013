package edu.gatech.wheresmystuff.views;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.model.LoginModel;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.presenters.EnterPersonPresenter;

/**
 * Startup activity that gets a persons information
 * 
 * @author Ses
 *
 */
public class EnterPersonActivity extends Activity implements IEnterPersonView {
	
	/** The presenter for this activity */
    private EnterPersonPresenter myPresenter;
    private UserDataSource userdata;
    private ItemDataSource itemdata;
    
    /**
     * Start activity
     * @param savedInstanceState current instance state
     */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_person);
		userdata = new UserDataSource(this);
		myPresenter = new EnterPersonPresenter(this, userdata, new LoginModel(userdata));
	}

	/**
	 * Creates menu
	 * @param menu menu to create
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_enter_person, menu);
		return true;
	}
	
	/**
	 * Resumes userdata for database
	 */
	@Override
	protected void onResume() {
		userdata.open();
		super.onResume();
	}
	
	/**
	 * Pauses userdata for database
	 */
	@Override
	protected void onPause() {
		userdata.close();
		super.onPause();
	}
	
	/**
	 * Button handler for the Login button
	 * 
	 * @param source not used
	 */
	public void onLoginClick(View source) {
		String username = getUsernameField().getText().toString();
		String password = getPasswordField().getText().toString();
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		prefs.edit().putString("username", username).commit();
		myPresenter.onLoginClick(username, password);
	}
	
	/**
	 * Get username from the text field
	 * @return username
	 */
	private EditText getUsernameField()     {
        return (EditText) findViewById(R.id.editUsername);
	}

	/**
	 * Get password from the text field
	 * @return password
	 */
	private EditText getPasswordField()     {
        return (EditText) findViewById(R.id.editPassword);
	}
	
	/**
	 * Button handler for the Register button
	 * 
	 * @param v not used
	 */
	public void onRegisterClick(View v) {
		String username = getUsernameField().getText().toString();
		String password = getPasswordField().getText().toString();
		myPresenter.onRegisterClick(username, password);
	}
	
	/**
	 * show an error alert on the screen
	 * @param message Message to be shown in alert
	 */
	public void errorAlert(String message) {
		ErrorAlert errorAlert = new ErrorAlert(this, message);
		errorAlert.show();
	}
	
	/**
	 * Advances to the next screen based on a screenID
	 * 
	 * 1 = Logged in
	 * 2 = Register (show users)
	 */
	@Override
	public void advance(int screenID) {
		if(screenID == 1) { //login button hit
			Intent intent = new Intent(this, LoggedInActivity.class);
			startActivity(intent);
		}
		if(screenID == 2) { //register button hit
			Intent intent = new Intent(this, PersonListingActivity.class);
			startActivity(intent);
		}
	}
}
