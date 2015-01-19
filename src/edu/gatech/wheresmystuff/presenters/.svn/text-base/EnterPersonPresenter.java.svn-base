package edu.gatech.wheresmystuff.presenters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R;
import android.content.SharedPreferences;

import edu.gatech.wheresmystuff.model.ILogin;
import edu.gatech.wheresmystuff.model.IModel;
import edu.gatech.wheresmystuff.model.User;
import edu.gatech.wheresmystuff.model.UserDataSource;
import edu.gatech.wheresmystuff.views.IEnterPersonView;

/**
 * Our presenter.
 * 
 * @author Ses
 *
 */
public class EnterPersonPresenter {
	
	
	/** the view to manipulate */
	private final IEnterPersonView myView;
	/** the model that the presenter pulls data from */
	/** the model that the presenter gets login checks from */
	private final ILogin myLogin;
	
	private UserDataSource userdata;
	/**
	 * Make the presenter
	 * @param view the view to use
	 * @param model the model to use
	 */
	public EnterPersonPresenter(IEnterPersonView view, UserDataSource userdata, ILogin login) {
		myView = view;
		myLogin = login;
		
		this.userdata = userdata;
		userdata.open();
		userdata.updateMap();
		userdata.close();
	}
	
	/**
	 * Handle the login button click in the UI
	 * 
	 * @param name the name of the person
	 * @param uid the id of the person
	 * @param email the email of the person
	 */
	public void onLoginClick(String username, String password) {
		if(UserDataSource.USER_MAP == null) {
			System.out.println("MAP NULL");
			myView.errorAlert("NULL MAP");
			return;
		}
		if(username == null || password == null) {
			System.out.println("USER/PASS NULL");
			myView.errorAlert("You can't leave the username or password empty.");
			return;
		}
		if(myLogin.checkLogin(username, password, UserDataSource.USER_MAP)) {
			myView.advance(1);
		} else {
			if(UserDataSource.USER_MAP.get(username) != null) {
				if(UserDataSource.USER_MAP.get(username).getTries() <= 0) {
					myView.errorAlert(username + " is now locked. Please try again later.");
				}
				else {
					myView.errorAlert("Incorrect Password!");
				}
			} else {
				myView.errorAlert("That account does not exist.");
			}
		}
	}

	/**
	 * Handle a register button click in the ui.
	 * Just advance to the next screen, but don't
	 * do anything to the model.
	 */
	public void onRegisterClick(String uid, String password) {
		if(UserDataSource.USER_MAP != null && UserDataSource.USER_MAP.get(uid) != null) { 
			myView.errorAlert("Username already taken.");
		} else {
			//myModel.addPerson(new User(uid, password));
			userdata.open();
			userdata.createUser(uid, password, false);
			userdata.close();
			myView.advance(2);
		}	
	}

}
