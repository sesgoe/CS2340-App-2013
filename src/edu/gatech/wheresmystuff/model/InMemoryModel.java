package edu.gatech.wheresmystuff.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

/**
 * This is the actual implementation of the Model interface.
 * It uses the Monostate pattern, so all instances share one 
 * set of data.
 * 
 * @author Ses
 *
 */
public class InMemoryModel implements IModel, ItemModel {
	/** the data store of all people */
	private static Map<String, User> people = new HashMap<String, User>();
	private static Map<String, Item> items = new HashMap<String, Item>();
	private static String quickSearchName;
	private static String quickSearchLoc;
	
	/**
	 * Add a user to the map of users
	 * @param p User to add
	 */
	@Override
	public void addPerson(User p) { //TEST
		people.put(p.getUid(), p);	
		Log.d("Model", "Person added: " + p.getUid());
	}

	@Override
	/**
	 * Find a user by their username
	 * @param uid username ID to be searched for
	 * @return User with Uid or null
	 */
	public User findPersonById(String uid) { //TEST
		return people.get(uid);
	}
	
	/**
	 * remove a person by their username
	 * @param uid username ID to be removed
	 */
	@Override
	public void removePerson(String uid) {
		people.remove(uid);		
	}
	
	/**
	 * Get an array of users
	 * @return array of Users
	 */
	@Override
	public User[] getPeople() {
		//Making a copy of data to pass over trust boundary
		Collection<User> p = people.values();
		User[] retVal = new User[p.size()];
		int i = 0;
		for (User p1 : p) retVal[i++] = p1;
		return retVal;
	}
	
	/**
	 * Get the map of users
	 * @return Map of Users
	 */
	public Map<String, User> getPeopleMap() {
		return people;
	}
	
	/**
	 * Add an item to the memory model
	 * @param i Item to be added
	 */
	@Override
	public void addItem(Item i) {
		items.put(i.getName(), i);
		Log.d("ItemModel", "Item added: " + i.getName());
		
	}
	
	/**
	 * Find all items by a certain user (for future use)
	 * @param p User that all items will be sorted by
	 * @return an ArrayList of the User's Items
	 */
	@Override
	public ArrayList<Item> findItemsByUser(User p) {
		return p.getItems();
	}
	
	/**
	 * Get a person based on a certain item
	 * @param i Item that belongs to the user you want to see
	 * @return User you want to see
	 */
	@Override
	public User getPerson(Item i) {
		return i.getUser();
	}
	
	/**
	 * Get an array of all the items in the map
	 * @return array of Items
	 */
	@Override
	public Item[] getItems() {
		Collection<Item> i = items.values();
		Item[] retVal = new Item[i.size()];
		int j = 0;
		for(Item i1 : i) retVal[j++] = i1;
		return retVal;
	}
	
	/**
	 * Get the item map for use elsewhere
	 * @return Mapping of items
	 */
	@Override
	public Map<String, Item> getItemMap() {
		return items;
	}

	/**
	 * Get name for quick search
	 * @return quick search name
	 */
	@Override
	public String getQuickSearchName() {
		return quickSearchName;
	}

	/**
	 * Get location for quick search
	 * @return quick search location
	 */
	@Override
	public String getQuickSearchLoc() {
		return quickSearchLoc;
	}

	/**
	 * Set name for quick search
	 * @itemName name to set
	 */
	@Override
	public void setQuickSearchName(String itemName) {
		
		quickSearchName = itemName;
	}

	/**
	 * Sets the location for quick search
	 * @itemLoc location to set
	 */
	@Override
	public void setQuickSearchLoc(String itemLoc) {
		quickSearchLoc = itemLoc;
		
	}
	
}
