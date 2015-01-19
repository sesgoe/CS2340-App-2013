package edu.gatech.wheresmystuff.model;

import java.util.ArrayList;

/**
 * Represents a single Person in the model
 * Information Holder
 * 
 * @author Ses
 *
 */
public class User {
	/** the persons username */
	private String uid;
	/** the persons email */
	private String password;
	/** lock counter */
	private int tries;
	/** ID for DB */
	private long id;
	/** Whether they're an admin */
	protected boolean admin;
	/** array of items attached to a certain user */
	private ArrayList<Item> items;
	
	/**
	 * Makes a new person
	 * @param u the id
	 * @param p the password
	 */
	/*
	public User(String u, String p) {
		uid = u;
		password = p;
		tries = 3;
		items = new ArrayList<Item>();
		admin = false;
	}*/
	
	/**
	 * Gets the person's name
	 * @return the person's name
	 */
	public String getUid() { return uid; }
	/**
	 * Gets the user's password
	 * @return the person's id
	 */
	public String getPassword() { return password; }
	/**
	 * Gets how many times they've tried to login
	 * @return Number of tries
	 */
	public int getTries() { return tries; }
	/**
	 * Gets a user's id
	 * @return user's id
	 */
	public long getID() { return id; }
	/**
	 * Sets a user's id
	 * @param id
	 */
	public void setID(long id) {
		this.id = id;
	}
	/**
	 * Add item attached to this user
	 * @param i Item to add
	 * @return Success or failure of method
	 */
	public boolean addItem(Item i) {
		try{
			items.add(i);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * get an arraylist of items
	 * @return
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Set the number of tries for a user
	 * @param i
	 */
	public void setTries(int i) {
		tries = i;
	}
	
	/**
	 * boolean value if the User is an Admin or not
	 * @return true or false if it an admin or not
	 */
	public boolean isAdmin() {
		if (admin) return true;
		else return false;
	}
	
	/**
	 * makes the user an admin
	 * @param admin boolean value to set if the User is an Admin or not
	 */
	public void setAdmin(int admin) {
		this.admin = (admin == 1 ? true : false);
	}
	/**
	 * Sets a user's uid
	 * @param uid
	 */
	public void setUsername(String uid) {
		this.uid = uid;
	}
	/**
	 * Sets a user's password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
