package edu.gatech.wheresmystuff.model;

import java.util.Map;

import android.content.SharedPreferences;

/**
 * Implementatino of the ILogin interface so that we can use it
 * @author Ses
 *
 */
public class LoginModel implements ILogin {
	/** User data source for DB */
	private UserDataSource userdata;
	
	/**
	 * Constructor for LoginModel
	 * @param userdata
	 */
	public LoginModel(UserDataSource userdata) {
		this.userdata = userdata;
	}
	
	/**
	 * Checks the login information of the user to see if it's correct
	 * 
	 * @param username
	 * @param password
	 * @param map Map holding <username, person>
	 * @return true if login succesfull, false otherwise
	 */
	@Override
	public boolean checkLogin(String username, String password, Map<String, User> map) {
		if(username == null || password == null || map == null) return false;
		
		User p = map.get(username);
		if(p == null) return false;
		if(password.equals(p.getPassword()) && p.getTries() > 0) {
			return true;
		}
		p.setTries(p.getTries() - 1);
		if(userdata != null) {
			userdata.open();
			userdata.updateUser(p);
			userdata.close();
		}
		return false;
	}

	/**
	 * Unlocks an account (admin only)
	 * @param username account to unlock
	 * @param map map of users
	 */
	@Override
	public void unlockAccount(String username, Map<String, User> map) {
		User u = map.get(username);
		u.setTries(3);
		userdata.open();
		userdata.updateUser(u);
		userdata.close();
	}
	/**
	 * Removes an account (admin only)
	 * @param username account to remove
	 * @param map map of users
	 */
	@Override
	public void removeUser(String username, Map<String, User> map) {
		userdata.open();
		userdata.deleteUser(map.get(username));
		userdata.close();
	}
	/**
	 * Sets an account as admin (admin only)
	 * @param username account to set
	 * @param map map of users
	 */
	public void setAdmin(String username, Map<String, User> map) {
		map.get(username).setAdmin(1);
		userdata.open();
		userdata.updateUser(map.get(username));
		userdata.updateMap();
		userdata.close();
	}

}
