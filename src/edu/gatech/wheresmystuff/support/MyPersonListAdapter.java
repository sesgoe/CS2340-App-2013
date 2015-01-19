package edu.gatech.wheresmystuff.support;

import java.util.List;

import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.User;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This is a custom adapter to use for the list
 * Each item displayed is formatted per row_layout.xml
 * 
 * @author Ses
 *
 */
public class MyPersonListAdapter extends ArrayAdapter<User> {
	/** The context for the adapter */
	private final Context context;
	/** the people to show in the list */
	private final User[] people;

	/**
	 * Make the adapter
	 * @param ctx the context to use
 	 * @param p the array of people to display
	 */
	public MyPersonListAdapter(Context ctx, User[] p) {
		super(ctx, R.layout.row_layout,p);
		context = ctx;
		people = p;
	}

	/**
	 * Lists users
	 * @param position Position in list
	 * @param convertView current view
	 * @param parent parent view group
	 */
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		//Set up the view by creating the widgets out of the xml spec
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.row_layout, parent, false);
	    
	    //Grab the two widgets in the view
	    TextView textView = (TextView) rowView.findViewById(R.id.label);
	    ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
	    
	    //set the widget values
	    textView.setText(people[position].getUid());
	   // Log.d("Model", "Set row for: " + people.get(position).getName());
	    // Change the icon for Windows and iPhone
	    String s = people[position].getUid();
	    if (s.startsWith("r") || s.startsWith("s")
	        || s.startsWith("t")) {
	      imageView.setImageResource(R.drawable.ic_no);
	    } else {
	      imageView.setImageResource(R.drawable.ic_ok);
	    }
	    
	    Log.d("Model", "Got row " + position);
	    
        //lastly return the prepared view for the list to use
	    return rowView;
	  }
}
