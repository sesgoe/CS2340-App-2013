package edu.gatech.wheresmystuff.model;

import java.util.Map;

/**
 * Login interface represents the thing that checks for correct user information
 * @author Ses
 *
 */
public interface ILogin {
	
	/**
	 * checks the user's login info
	 * @param username
	 * @param password
	 * @param map map that contains links to all users basically
	 * @return true if correct info, false otherwise
	 */
	boolean checkLogin(String username, String password, Map<String, User> map);
	/**
	 * unlocks a user account
	 * @param username
	 * @param map
	 */
	void unlockAccount(String username, Map<String, User> map);
	/**
	 * removes a user from the system
	 * @param username
	 * @param map
	 */
	void removeUser(String username, Map<String, User> map);
	/**
	 * sets a user as an admin
	 * @param username
	 * @param map
	 */
	void setAdmin(String username, Map<String, User> map);

}
