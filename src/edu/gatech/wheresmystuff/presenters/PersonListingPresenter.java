package edu.gatech.wheresmystuff.presenters;

import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.views.IPersonListingView;

/**
 * Handle any logic related to the list of people
 * 
 * @author Ses
 *
 */
public class PersonListingPresenter {
	/** the model to pull data from */
	private final  UserDataSource userdata;
	/** the view to display to */
	private final IPersonListingView myView;

	/**
	 * Make a new presenter
	 * @param m the model
	 * @param v the view
	 */
	public PersonListingPresenter(UserDataSource userdata, IPersonListingView v) {
		this.userdata = userdata;
		myView = v;
	}

}
