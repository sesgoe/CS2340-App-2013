package edu.gatech.wheresmystuff.model;

import java.util.Date;

/**
 * Represents an item
 * @author Ses
 *
 */
public class Item {
    /** Name of item */
	private String name;
	/** Description of item */
	private String desc;
	/** Category item is in (animal, electronics, etc.) */
	private String category;
	/** Date item was posted */
	private Date date;
	/** User associated with item */
	private User user;
	/** Location of item */
	private String location;
	/** Item's id */
	private long id;
	
	//for keeping track of whether an item is lost/found for sorting/displaying purposes
	private String status;
	

	/**
	 * Constructor that takes in a user (currently not in use)
	 * @param name item name
	 * @param desc item description
	 * @param user user to attach item to
	 */
	public Item(String name, String desc, String category, Date date, User user, String location, String status) {
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.user = user;
		this.status = status;
		this.date = date;
		this.location = location;
	}
	
	public Item() {
		//
	}
	
	/**
	 * Constructor that just sets the user to null (for the sake of this M6, honestly)
	 * @param name
	 * @param desc
	 */
	public Item(String name, String desc, String status, String category, Date date, String location) {
		this.name = name;
		this.desc = desc;
		this.category = category;
		this.user = null;
		this.status = status;
		this.date = date;
		this.location = location;
	}
	
	/**
	 * Getter for item name
	 * @return Item's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Getter for item description
	 * @return Item Description
	 */
	public String getDesc() {
		return this.desc;
	}
	/**
	 * Getter for category
	 * @return Item's Category
	 */
	public String getCategory() {
		return this.category;
	}
	/**
	 * Getter for user
	 * @return User attached to this item
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * Getter for status
	 * @return lost or found item status
	 */
	public String getStatus(){
		return this.status;
	}
	
	/**
	 * Getter for date
	 * @return the date the item was created
	 */
	public Date getDate(){
		return this.date;
	}
	
	/**
	 * Getter for location
	 * @return the location of the item
	 */
	public String getLocation(){
		return this.location;
	}
	
	/**
	 * Set item's id
	 * @param id 
	 */
	public void setID(long id) {
		this.id = id;
	}
	
	/**
	 * Get item's id
	 * @return item id
	 * @return
	 */
	public long getID() {
		return this.id;
	}

}
