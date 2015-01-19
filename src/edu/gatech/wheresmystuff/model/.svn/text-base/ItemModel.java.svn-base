package edu.gatech.wheresmystuff.model;

import java.util.ArrayList;
import java.util.Map;

/**
 * Item Model for the InMemoryModel class
 * @author John
 *
 */
public interface ItemModel {
	
	/**
	 * Add an item to the item model
	 * @param i item to add
	 */
	void addItem(Item i);
	
	/**
	 * Find all items that have a certain user associated with them (for future use)
	 * @param u
	 * @return an arraylist of items that that user 'owns'
	 */
	ArrayList<Item> findItemsByUser(User u);
	
	/**
	 * get a person for a specific item
	 * @param i item
	 * @return person item belongs to
	 */
	User getPerson(Item i);
	
	/**
	 * Get an array of all the items
	 * @return an array of all items
	 */
	Item[] getItems();
	
	/**
	 * Same as getPeopleMap from the IModel, except this time for items
	 * @return a map of all items
	 */
	Map<String, Item> getItemMap();

	/**
	 * Getter for name
	 * @return the name of the item
	 */
	String getQuickSearchName();
	/**
	 * Getter for location
	 * @return the location of the item
	 */
	String getQuickSearchLoc();
	/**
	 * Set name for quick search
	 * @itemName name to set
	 */
	void setQuickSearchName(String itemName);
	/**
	 * Set location for quick search
	 * @itemName location to set
	 */
	void setQuickSearchLoc(String itemLoc);
	
}
