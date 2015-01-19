package edu.gatech.wheresmystuff.views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * View class to help show error messages
 * @author Ses
 *
 */
public class ErrorAlert implements DialogInterface.OnClickListener {
	/** Alert Dialog to use */
	private AlertDialog dialog;
	
	/**
	 * Gives an error alert
	 * @param activity current activity
	 * @param text Error message
	 */
	public ErrorAlert(Activity activity, String text) {
		AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setMessage(text);
		builder.setPositiveButton("Ok", this);
		dialog = builder.create();
	}
	
	/**
	 * Show the error dialog
	 */
	public void show() {
		dialog.show();
	}
	
	/**
	 * Close the error dialog upon clicking the button
	 */
	public void onClick(DialogInterface dialogInterface, int i) {
		dialog.cancel();
	}

}
