package edu.gatech.wheresmystuff.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ItemDataSource {
	
	private SQLiteDatabase     database;
	private ItemSQLiteHelper dbHelper;
	private String[] allColumns = { ItemSQLiteHelper.COLUMN_ID, 
									ItemSQLiteHelper.COLUMN_NAME, 
									ItemSQLiteHelper.COLUMN_DESCRIPTION, 
									ItemSQLiteHelper.COLUMN_CATEGORY, 
									ItemSQLiteHelper.COLUMN_DATE,
									ItemSQLiteHelper.COLUMN_USER,
									ItemSQLiteHelper.COLUMN_LOCATION,
									ItemSQLiteHelper.COLUMN_STATUS };
	
	public static Map<String, Item> ITEM_MAP;
	public static List<Item> ITEM_LIST;
	public static List<Item> ITEM_LIST_MATCHING;
	
	/**
	 * Constructor that initializes dbHelper
	 * @param context Android context (Usually an activity)
	 */
	public ItemDataSource(Context context) {
		dbHelper = new ItemSQLiteHelper(context);
	}
	
	/**
	 * Opens a database for reading or writing
	 * @throws SQLException
	 */
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	
	/**
	 * Closes an open database
	 */
	public void close() {
		dbHelper.close();
	}
	
	/**
	 * Creates an item in the database
	 * @param name 		Item Name
	 * @param desc 		Item Description
	 * @param category 	Item Category
	 * @param date 		Item Data Posted
	 * @param user 		User associated with item
	 * @param location 	Item location posted
	 * @param status 	Item status
	 * @return
	 */
	public Item createItem(String name, String desc, String category, Date date, User user, String location, String status) {
		ContentValues values = new ContentValues();
		values.put(ItemSQLiteHelper.COLUMN_NAME, name);
		values.put(ItemSQLiteHelper.COLUMN_DESCRIPTION, desc);
		values.put(ItemSQLiteHelper.COLUMN_CATEGORY, category);
		values.put(ItemSQLiteHelper.COLUMN_DATE, date.toGMTString());
		values.put(ItemSQLiteHelper.COLUMN_USER, user.getUid());
		values.put(ItemSQLiteHelper.COLUMN_LOCATION, location);
		values.put(ItemSQLiteHelper.COLUMN_STATUS, status);
		long insertID = database.insert(ItemSQLiteHelper.TABLE_ITEMS, null, values);
		Cursor cursor = database.query (ItemSQLiteHelper.TABLE_ITEMS, allColumns, ItemSQLiteHelper.COLUMN_ID + " = " + insertID, null, null, null, null);
		cursor.moveToFirst();
		Item newItem = cursorToItem(cursor);
		cursor.close();
		updateMap();
		updateList();
		return newItem;
		
	}
	
	/**
	 * Deletes an item from the database
	 * @param item Item to delete
	 */
	public void deleteItem(Item item) {
		long id = item.getID();
		System.out.println("Item deleted with ID: " + id);
		database.delete(ItemSQLiteHelper.TABLE_ITEMS, UserMySQLiteHelper.COLUMN_ID + " = " + id, null);
		updateMap();
		updateList();
	}
	
	/**
	 * Updates an item in the database
	 * @param item Item to update
	 */
	public void updateItem(Item item) {
		
		ContentValues values = new ContentValues();
		values.put(ItemSQLiteHelper.COLUMN_NAME, item.getName());
		values.put(ItemSQLiteHelper.COLUMN_DESCRIPTION, item.getDesc());
		values.put(ItemSQLiteHelper.COLUMN_CATEGORY, item.getCategory());
		values.put(ItemSQLiteHelper.COLUMN_DATE, item.getDate().toGMTString());
		values.put(ItemSQLiteHelper.COLUMN_USER, item.getUser().getUid());
		values.put(ItemSQLiteHelper.COLUMN_LOCATION, item.getLocation());
		values.put(ItemSQLiteHelper.COLUMN_STATUS, item.getStatus());
		
		database.update(ItemSQLiteHelper.TABLE_ITEMS, values, UserMySQLiteHelper.COLUMN_ID + " = ?", 
				new String[] { String.valueOf(item.getID()) });
		
		updateMap();
		updateList();
	}
	
	/**
	 * Updates the global static map ITEM_MAP
	 */
	public void updateMap() {
		ITEM_MAP = getAllItemsMap();
	}
	
	/**
	 * Updates the global static list ITEM_LIST
	 */
	public void updateList() {
		ITEM_LIST = getAllItems();
	}
	
	/**
	 * Gets a list of all items in the database
	 * @return list of all items
	 */
	public List<Item> getAllItems() {
		List<Item> items = new ArrayList<Item>();
		Cursor cursor = database.query(ItemSQLiteHelper.TABLE_ITEMS, allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			Item item = cursorToItem(cursor);
			items.add(item);
			cursor.moveToNext();
		}
		
		cursor.close();
		return items;
	}
	
	/**
	 * Gets all items in a map format <String, Item> which is <ItemName, Item>
	 * @return
	 */
	public Map<String, Item> getAllItemsMap() {
		Map<String, Item> itemMap = new HashMap<String, Item>();
		List<Item> items = getAllItems();
		if(items != null) {
			for(Item item : items) {
				String name = item.getName();
				itemMap.put(name, item);
			}
		}
		return itemMap;
	}
	
	/**
	 * Gets a list of all items that actually match (items with the same name, but different statuses, aka one lost, one found)
	 * @return
	 */
	public List<Item> getAllItemsMatching() {
		
		Map<String, String> duplicateMap = new HashMap<String, String>();
		List<Item> items = new ArrayList<Item>();
		duplicateMap.put("", "");
		for(Item i : ITEM_LIST) {
			if(duplicateMap.get(i.getName().toLowerCase()) == null) {
				duplicateMap.put(i.getName().toLowerCase(), i.getStatus().toLowerCase());
			} 
			if(duplicateMap.get(i.getName()) != null && !duplicateMap.get(i.getName().toLowerCase()).equals(i.getStatus().toLowerCase())) {
				items.add(ITEM_MAP.get(i.getName()));
			}
		}
		return items;
	}
	
	/**
	 * Helper function to convert a SQL cursor into an actual usable item
	 * @param cursor
	 * @return
	 */
	public Item cursorToItem(Cursor cursor) {
		Item item = new Item(cursor.getString(1), cursor.getString(2), cursor.getString(3), new Date(Date.parse(cursor.getString(4))), UserDataSource.USER_MAP.get(cursor.getString(5)), 
				cursor.getString(6), cursor.getString(7));
		item.setID(cursor.getLong(0));
		return item;
	}

}
