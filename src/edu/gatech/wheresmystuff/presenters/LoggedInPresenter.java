package edu.gatech.wheresmystuff.presenters;

import java.util.Map;

import edu.gatech.wheresmystuff.model.ILogin;
import edu.gatech.wheresmystuff.model.User;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.views.ILoggedInView;

public class LoggedInPresenter {
	
	/** the view to use */
	private final ILoggedInView myView;
	/** the model that the presenter pulls data from */
	private final UserDataSource userdata;
	/** the model that the presenter gets login checks from */
	private final ILogin myLogin;
	
	/**
	 * Constructor for LoggedInPresenter
	 * @param view current view
	 * @param userdata User data source
	 * @param login ILogin to use
	 */
	public LoggedInPresenter(ILoggedInView view, UserDataSource userdata, ILogin login) {
		myView = view;
		this.userdata = userdata;
		myLogin = login;
	}
	
	/**
	 * Checks if a user is an admin
	 * @param username username of user
	 * @return If they're an admin or not
	 */
	public boolean isAdmin(String username) {
		
		if(UserDataSource.USER_MAP.get(username) == null) return false;
		
		if(UserDataSource.USER_MAP.get(username).isAdmin()) {
			return true;
		} else {
			return false;
		}
	}
	
}
