package edu.gatech.wheresmystuff.support;

import java.util.List;

import edu.gatech.wheresmystuff.R;
import edu.gatech.wheresmystuff.model.Item;
import edu.gatech.wheresmystuff.model.User;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DateFormat;

/**
 * This is a custom adapter to use for the list
 * Each item displayed is formatted per row_layout_items.xml
 * 
 * @author Ses
 *
 */
public class ItemListAdapter extends ArrayAdapter<Item> {
	/** The context for the adapter */
	private final Context context;
	/** the items to show in the list */
	private final Item[] items;

	/**
	 * Make the adapter
	 * @param ctx the context to use
 	 * @param i the array of items to display
	 */
	public ItemListAdapter(Context ctx, Item[] i) {
		super(ctx, R.layout.row_layout_items,i);
		context = ctx;
		items = i;
	}

	/**
	 * Lists the items on the screen, listing their name, description, category, and date.
	 * @param position Position in list
	 * @param convertView current view
	 * @param parent parent view group
	 */
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		//Set up the view by creating the widgets out of the xml spec
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.row_layout_items, parent, false);
	    
	    //Grab the two widgets in the view
	    TextView textView =  (TextView) rowView.findViewById(R.id.itemName);
	    TextView textView2 = (TextView) rowView.findViewById(R.id.description);
	    TextView textView3 = (TextView) rowView.findViewById(R.id.category);
	    TextView textView4 = (TextView) rowView.findViewById(R.id.date);
	    
	    //set the widget values
	    textView.setText(items[position].getName() + " (" + items[position].getStatus() +")");
	    textView2.setText(items[position].getDesc());
	    textView3.setText(items[position].getCategory());
	    textView4.setText("Posted " + DateFormat.getDateInstance().format(items[position].getDate()));
	    
	    Log.d("Model", "Got row " + position);
	    
        //lastly return the prepared view for the list to use
	    return rowView;
	  }
}
