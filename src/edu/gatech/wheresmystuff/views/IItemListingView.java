package edu.gatech.wheresmystuff.views;

import edu.gatech.wheresmystuff.model.Item;

/**
 * Interface for item listing view
 * @author John
 *
 */
public interface IItemListingView {
	
	/**
	 * Set the items array to a given input array
	 * @param i
	 */
	void setItems(Item[] i);

}
