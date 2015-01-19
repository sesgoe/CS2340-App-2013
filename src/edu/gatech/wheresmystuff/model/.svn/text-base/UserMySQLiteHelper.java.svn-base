package edu.gatech.wheresmystuff.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

/**
 * Database creation class that also handles updating the database if necessary
 * @author Ses
 *
 */
public class UserMySQLiteHelper extends SQLiteOpenHelper {
	
	public static final String  TABLE_USERS = "users";
	public static final String  COLUMN_ID   = "_id";
	public static final String  COLUMN_USERNAME = "username";
	public static final String  COLUMN_PASSWORD = "password";
	public static final String  COLUMN_TRIES    = "tries";
	public static final String  COLUMN_ADMIN    = "admin";
	
	private static final String DATABASE_NAME     = "users.db";
	private static final int    DATABASE_VERSION  = 1;
	
	/**
	 * String using SQLite syntax to create the DB for storing users
	 */
	private static final String DATABASE_CREATE = 
			"CREATE TABLE "+ TABLE_USERS 
			+ "("   + COLUMN_ID       + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ COLUMN_USERNAME + " TEXT NOT NULL, " 
					+ COLUMN_PASSWORD + " TEXT NOT NULL, "
					+ COLUMN_TRIES    + " INTEGER,"
					+ COLUMN_ADMIN    + " INTEGER)";
	
	public UserMySQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	/**
	 * Executes the SQL string above when this class is created (handled by the Android OS)
	 */
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}
	
	@Override
	/**
	 * Upgrades the database by dropping the old table, and adding the new one automatically if the database version changes
	 */
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		Log.w(UserMySQLiteHelper.class.getName(),
				"Upgrading database from version " + oldversion + " to "
					+ newversion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		onCreate(db);
	}

}
