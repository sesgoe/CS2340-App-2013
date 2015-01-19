package edu.gatech.wheresmystuff.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
	
	//Username, Password, Tries, Admin <---Table Column Order
	
	private SQLiteDatabase     database;
	private UserMySQLiteHelper dbHelper;
	private String[] allColumns = { UserMySQLiteHelper.COLUMN_ID, 
									UserMySQLiteHelper.COLUMN_USERNAME, 
									UserMySQLiteHelper.COLUMN_PASSWORD, 
									UserMySQLiteHelper.COLUMN_TRIES, 
									UserMySQLiteHelper.COLUMN_ADMIN };
	
	/**
	 * Map of all users for the application to use for login purposes
	 */
	public static Map<String, User> USER_MAP;
	
	/**
	 * List of all users for the application to use instead of constantly accessing the database
	 */
	public static List<User> USER_LIST;
	
	/**
	 * Constructor that sets up the class variable dbHelper
	 * @param context Android context (usually an activity)
	 */
	public UserDataSource(Context context) {
		dbHelper = new UserMySQLiteHelper(context);
	}
	
	/**
	 * Opens the database for reading/writing
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	/**
	 * Closes the database
	 */
	public void close() {
		dbHelper.close();
	}
	
	/**
	 * Creates a new user in the database
	 * @param username Username for the new user
	 * @param password Password for the new user
	 * @param admin    True if the new user should be an admin, false otherwise
	 * @return User created as a User
	 */
	public User createUser(String username, String password, boolean admin) {
		ContentValues values = new ContentValues();
		values.put(UserMySQLiteHelper.COLUMN_USERNAME, username);
		values.put(UserMySQLiteHelper.COLUMN_PASSWORD, password);
		values.put(UserMySQLiteHelper.COLUMN_TRIES, 3);
		values.put(UserMySQLiteHelper.COLUMN_ADMIN, admin ? 1 : 0);
		long insertID = database.insert(UserMySQLiteHelper.TABLE_USERS, null, values);
		Cursor cursor = database.query (UserMySQLiteHelper.TABLE_USERS, allColumns, UserMySQLiteHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
		cursor.moveToFirst();
		User newUser = cursorToUser(cursor);
		cursor.close();
		updateMap();
		return newUser;
		
	}
	
	/**
	 * Helper function for creating an admin account on a computer that doesn't have one in its local database
	 */
	public void createAdmin() {
		createUser("admin", "admin", true);
	}
	
	/**
	 * Deletes a user from the database
	 * @param user User to delete
	 */
	public void deleteUser(User user) {
		long id = user.getID();
		System.out.println("User deleted with ID: " + id);
		database.delete(UserMySQLiteHelper.TABLE_USERS, UserMySQLiteHelper.COLUMN_ID + " = " + id, null);
		updateMap();
	}
	
	/**
	 * Updates a user in the database
	 * @param user User to update
	 */
	public void updateUser(User user) {
		
		ContentValues values = new ContentValues();
		values.put(UserMySQLiteHelper.COLUMN_USERNAME, user.getUid());
		values.put(UserMySQLiteHelper.COLUMN_PASSWORD, user.getPassword());
		values.put(UserMySQLiteHelper.COLUMN_TRIES, user.getTries());
		values.put(UserMySQLiteHelper.COLUMN_ADMIN, user.isAdmin() ? 1 : 0);
		
		database.update(UserMySQLiteHelper.TABLE_USERS, values, UserMySQLiteHelper.COLUMN_ID + " = ?", 
				new String[] { String.valueOf(user.getID()) });
		
		updateMap();
	}
	
	/**
	 * Updates the global static user map that holds a map of all users
	 */
	public void updateMap() {
		USER_MAP = getAllUsersMap();
	}
	
	/**
	 * Updates the global static user list that holds a list of all users
	 */
	public void updateList() {
		USER_LIST = getAllUsers();
	}
	
	/**
	 * Gets a list of all users in the database
	 * @return the list of users
	 */
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Cursor cursor = database.query(UserMySQLiteHelper.TABLE_USERS, allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			User user = cursorToUser(cursor);
			users.add(user);
			cursor.moveToNext();
		}
		
		cursor.close();
		return users;
	}
	
	/**
	 * Gets a map of all users in the database with the format <Username, User> which is a <String, User> map
	 * @return the map of users
	 */
	public Map<String, User> getAllUsersMap() {
		Map<String, User> userMap = new HashMap<String, User>();
		List<User> users = getAllUsers();
		if(users != null) {
			for(User user : users) {
				String username = user.getUid();
				userMap.put(username, user);
			}
		}
		return userMap;
	}
	
	/**
	 * Helper function to convert the DB output into an actual user
	 * @param cursor
	 * @return User read in from database
	 */
	public User cursorToUser(Cursor cursor) {
		User user = new User();
		user.setID			(cursor.getLong(0));
		user.setUsername	(cursor.getString(1));
		user.setPassword	(cursor.getString(2));
		user.setTries   	(cursor.getInt(3));
		user.setAdmin   	(cursor.getInt(4));
		return user;
	}
	

}
