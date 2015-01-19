package edu.gatech.wheresmystuff.presenters;

import java.util.Date;
import java.util.Map;

import edu.gatech.wheresmystuff.model.InMemoryModel;
import edu.gatech.wheresmystuff.model.Item;
import edu.gatech.wheresmystuff.model.ItemDataSource;
import edu.gatech.wheresmystuff.model.ItemModel;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.views.IEnterItemView;

/**
 * Presenter for the EnterItem activity
 * @author Ses
 *
 */
public class EnterItemPresenter {
	
	/** the view to manipulate */
	private final IEnterItemView myView;
	/** the model that the presenter pulls data from */
	private ItemDataSource itemdata;
	private ItemModel myModel;
	
	Map<String, Item> itemMap;
	/**
	 * Constructor for EnterItemPresenter
	 * @param view current view
	 * @param itemdata Item data source
	 */
	public EnterItemPresenter(IEnterItemView view, ItemDataSource itemdata) {
		this.myView = view;
		this.itemdata = itemdata;
		this.myModel = new InMemoryModel();
		itemMap = ItemDataSource.ITEM_MAP;
		
	}

	/**
	 * Handles adding an item to the map
	 * @param itemName item name
	 * @param itemDesc item description
	 */
	public void onAddItemClick(String itemName, String itemDesc, String itemStatus, String itemCategory, Date itemDate, String itemLoc) {
		itemdata.open();
		itemdata.createItem(itemName, itemDesc, itemCategory, itemDate, UserDataSource.USER_MAP.get("admin"), itemLoc, itemStatus);
		itemdata.close();
		myView.advance(1);
	}
	
	/**
	 * Gives the quickSearch criteria to the model 
	 * @param itemName
	 * @param itemLoc
	 */
	public void takeQuickSearch(String itemName, String itemLoc){
		
		myModel.setQuickSearchName(itemName);
		myModel.setQuickSearchLoc(itemLoc);
		myView.advance(3);
		
	}

}
