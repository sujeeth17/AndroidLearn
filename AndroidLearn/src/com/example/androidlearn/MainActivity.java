package com.example.androidlearn;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
     DatabaseDataManager dm;
	 private Button mDoneButton;
     final ArrayList<String> items=new ArrayList<String>();
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        dm = new DatabaseDataManager(this);
	        
	        setContentView(R.layout.activity_main);
	        mDoneButton = (Button) findViewById(R.id.button1);
	        mDoneButton.setOnClickListener(this);
	        
	        items.add("apple");
	        items.add("banana");
	        items.add("carrot");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        items.add("custard");
	        
	        for(int i=0;i< items.size(); i++)
	    	{
	        	Item item = new Item();
	        	item.setItemName(items.get(i));
	    		dm.saveNote(item);
	    	}
	        
	        ArrayList<Item> getItems = (ArrayList<Item>) dm.getAllNotes();
	        Log.d("All items", getItems.toString());
	    }

	    @Override
	    public void onClick(View v) {
	    	
//	        //converting array to charSequence and initializing object
	    	final CharSequence[] listItems = items.toArray(new CharSequence[items.size()]);;
	    	for(int i=0;i< items.size(); i++)
	    	{
	    		listItems[i]=items.get(i).toString();
	    	}

	        AlertDialog.Builder builder = new AlertDialog.Builder(this);
	        builder.setTitle("Make your selection");
	        builder.setItems(listItems, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int item) {
	                // Do something with the selection
	                mDoneButton.setText(listItems[item]);
	            }
	        });
	        AlertDialog alert = builder.create();
	        alert.show();
	    }
}
