package edu.gatech.wheresmystuff.model;

import java.util.Collection;
import java.util.Map;


/**
 * This is a Facade for the actual model
 * We hide all the other model classes behind this interface
 * To the rest of the application, we provide all required 
 * services.  Where the data comes from (files, memory, databases)
 * is hidden.
 * 
 * @author Ses
 *
 */
public interface IModel {
	/**
	 * Add a person to the model
	 * 
	 * @param p the person to add
	 */
	void addPerson(User p);
	/**
	 * Lookup a person by their id
	 * 
	 * @param uid the id to search for
	 * 
	 * @return the person with that id or null if not found
	 */
	User findPersonById(String uid);
	/**
	 * Remove a person from the model 
	 * 
	 * @param id the id of teh person to remove
	 */
	void removePerson(String id);
	/**
	 * Get all the people  in the model as an array
	 * 
	 * @return an array of all people in the model.
	 */
	User[] getPeople();
	
	/**
	 * Get all the people in the model as a map
	 * 
	 * @return a map of all people in the model
	 */
	Map<String, User> getPeopleMap();
}
