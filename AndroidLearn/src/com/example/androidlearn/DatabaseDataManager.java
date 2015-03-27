package com.example.androidlearn;

import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseDataManager {

	private Context mContext;
	private DatabaseOpenHelper dbOpenHelper;
	private ItemDAO itemDAO;
	private SQLiteDatabase db;
	
	public DatabaseDataManager(Context mContext)
	{
		this.mContext = mContext;
		dbOpenHelper = new DatabaseOpenHelper(this.mContext);
		db= dbOpenHelper.getWritableDatabase();
		itemDAO = new ItemDAO(db);
	}
	
	public void close(){
		if(db != null)
		{
			db.close();
		}
	}

	public ItemDAO getNoteDAO()
	{
		return this.itemDAO;
	}
	
	public long saveNote(Item item)
	{
		return this.itemDAO.save(item);
		
	}
     
	public boolean updateNote(Item item)
	{
		return this.itemDAO.update(item);
		
	}
	
	public boolean deleteNote(Item item)
	{
		return this.itemDAO.delete(item);
		
	}
	
	public Item getNote(long id) 
	{
		return this.itemDAO.get(id);
		
	}
	
	public List<Item> getAllNotes()
	{
		return this.itemDAO.getAll();
	
	}
	
}
