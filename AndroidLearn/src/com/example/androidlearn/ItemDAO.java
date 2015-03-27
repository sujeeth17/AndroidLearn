package com.example.androidlearn;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class ItemDAO {

	private SQLiteDatabase db;
	
	public ItemDAO(SQLiteDatabase db)
	{
		this.db = db;
	}
	
	public long save(Item item)
	{
		ContentValues values = new ContentValues();
		values.put(ItemTable.Column_Item, item.getItemName());		
		return db.insert(ItemTable.TABLENAME, null, values);
	}
	
	public boolean update(Item item)
	{
		ContentValues values = new ContentValues();
		values.put(ItemTable.Column_Item, item.getItemName());
		
        return db.update(ItemTable.TABLENAME, values, ItemTable.Column_Id+ "=?",new String[]{item.get_id()+""}) >0 ;
        
	}
    
	public boolean delete(Item item)
	{
		return db.delete(ItemTable.TABLENAME, ItemTable.Column_Id+ "=?",new String[]{item.get_id()+""})> 0;
	}
	
	public Item get(long id)
	{
		Item item = null;
		
		Cursor cursor = db.query( ItemTable.TABLENAME, new String[]{ItemTable.Column_Id, ItemTable.Column_Item},  null, null, null, null, null);
		if(cursor != null && cursor.moveToFirst())
		{
			item = buildItemFromCursor(cursor);
			if(!cursor.isClosed())
			{
			cursor.close();
			}
		}
		return item;
	}
	

	public List<Item> getAll()
	{
		List<Item> notes = new ArrayList<Item>();
		Cursor cursor = db.query(ItemTable.TABLENAME, new String[]{ItemTable.Column_Id, ItemTable.Column_Item}, null, null, null, null, null);
		if(cursor != null && cursor.moveToFirst())
		{
			do{
				Item note = buildItemFromCursor(cursor);
				if(note!= null)
				{
					notes.add(note);
				}
			}
			while(cursor.moveToNext());
			if(!cursor.isClosed())
			{
			cursor.close();
			}
		
		}
		return notes;
	}
	
	public Item buildItemFromCursor(Cursor c)
	{
		Item item = null;
		if(c != null)
		{
			item = new Item();
			item.set_id(c.getLong(0));
			item.setItemName(c.getString(1));	
		}
		return item;		
	}
}
