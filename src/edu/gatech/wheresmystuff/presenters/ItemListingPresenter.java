package edu.gatech.wheresmystuff.presenters;

import edu.gatech.wheresmystuff.model.Item;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.model.ItemModel;
import edu.gatech.wheresmystuff.views.IItemListingView;

/**
 * Presenter for listing items
 * @author John
 *
 */
public class ItemListingPresenter {
	
	/** the model to pull data from */
	private final  ItemModel myModel;
	/** the view to display to */
	private final IItemListingView myView;

	/**
	 * Make a new presenter
	 * @param m the model
	 * @param v the view
	 */
	public ItemListingPresenter(ItemModel m, IItemListingView v) {
		myModel = m;
		myView = v;
		Item[] items = new Item[ItemDataSource.ITEM_LIST.size()];
		for(int i=0; i<ItemDataSource.ITEM_LIST.size(); i++) {
			items[i] = ItemDataSource.ITEM_LIST.get(i);
		}
		myView.setItems(items);
	}
	
	/**
	 * Gets the ItemModel
	 * @return ItemModel
	 */
	public ItemModel getModel(){
		return myModel;
	}

}
