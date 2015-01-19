package edu.gatech.wheresmystuff.presenters;

import java.util.Map;

import edu.gatech.wheresmystuff.model.ILogin;
import edu.gatech.wheresmystuff.model.User;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.views.IManageUsers;

/**
 * Presenter for allowing admins to manage users (unlock, remove, promote to admin, etc.)
 * @author John
 *
 */
public class ManageUsersPresenter {
	
	/** view to use */
	private final IManageUsers myView;
	/** the model that the presenter pulls data from */
	private final UserDataSource userdata;
	/** the model that the presenter gets login checks from */
	private final ILogin myLogin;
	
	/**
	 * Constructor for ManageUsersPresenter
	 * @param view
	 * @param userdata
	 * @param login
	 */
	public ManageUsersPresenter(IManageUsers view, UserDataSource userdata, ILogin login) {
		myView = view;
		myLogin = login;
		this.userdata = userdata;
	}
	
	/**
	 * Call myLogin to make a user an admin
	 * @param username User to make an admin
	 */
	public void onMakeAdminClick(String username) {
		if(UserDataSource.USER_MAP.get(username) == null) {
			myView.alert("That user does not exist.");
		} else {
			myLogin.setAdmin(username, UserDataSource.USER_MAP);
			myView.alert(username + " has been made into an Admin");
		}
	}
	
	/**
	 * Calls myLogin to remove a user
	 * @param username User to remove
	 */
	public void onRemoveUserClick(String username) {
		if(UserDataSource.USER_MAP.get(username) == null) {
			myView.alert("That user either has already been removed, or does not exist.");
		} else {
			myLogin.removeUser(username, UserDataSource.USER_MAP);
			myView.alert(username + " has been removed from the list of users.");
		}
	}
	
	/**
	 * Calls myLogin to unlock an account
	 * @param username User to unlock
	 */
	public void onUnlockAccountClick(String username) {
		if(UserDataSource.USER_MAP.get(username) == null) {
			myView.alert("That user does not exist.");
		} else {
			myLogin.unlockAccount(username, UserDataSource.USER_MAP);
			myView.alert(username + "'s account has been unlocked.");
		}
	}
	
}
