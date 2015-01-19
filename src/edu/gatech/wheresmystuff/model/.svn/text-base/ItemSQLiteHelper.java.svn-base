package edu.gatech.wheresmystuff.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

public class ItemSQLiteHelper extends SQLiteOpenHelper {
	
	public static final String  TABLE_ITEMS 		= "items";
	public static final String  COLUMN_ID   		= "_id";
	public static final String  COLUMN_NAME 		= "name";
	public static final String  COLUMN_DESCRIPTION  = "description";
	public static final String  COLUMN_CATEGORY     = "category";
	public static final String  COLUMN_DATE 		= "date";
	public static final String  COLUMN_USER    		= "user";
	public static final String  COLUMN_LOCATION		= "location";
	public static final String  COLUMN_STATUS       = "status";
	
	private static final String DATABASE_NAME     = "items.db";
	private static final int    DATABASE_VERSION  = 1;
	
	//Create DB
	private static final String DATABASE_CREATE = 
			"CREATE TABLE "+ TABLE_ITEMS 
			+ "("   + COLUMN_ID       	 + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ COLUMN_NAME 		 + " TEXT NOT NULL, " 
					+ COLUMN_DESCRIPTION + " TEXT NOT NULL, "
					+ COLUMN_CATEGORY    + " TEXT NOT NULL,"
					+ COLUMN_DATE        + " TEXT NOT NULL,"
					+ COLUMN_USER    	 + " TEXT NOT NULL,"
					+ COLUMN_LOCATION    + " TEXT NOT NULL,"
					+ COLUMN_STATUS      + " TEXT NOT NULL)";
	
	/**
	 * Standard constructor that calls the constructor of SQLiteOpenHelper
	 * @param context Android context (usually an activity)
	 */
	public ItemSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	/**
	 * When this class is created for the first time, android will execute the SQL string that creates the database
	 */
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}
	
	@Override
	/**
	 * When you change the version number of the database, it'll automatically drop the old table and update the database with the new table
	 */
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		Log.w(UserMySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldversion + " to "
					+ newversion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
		onCreate(db);
	}

}

