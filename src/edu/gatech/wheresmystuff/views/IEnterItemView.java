package edu.gatech.wheresmystuff.views;

import android.view.View;
import android.widget.EditText;

/**
 * Interface for view for entering items
 * @author John
 */
public interface IEnterItemView {
	
	/**
	 * Advance to the next screen based on screenID
	 * @param screenID
	 */
	void advance(int screenID);
	/**
	 * Error alert box popup with a given message
	 * @param message
	 */
	void errorAlert(String message);

}
