package com.example.androidlearn;

public class Item {
	private long _id;
	String itemName;    
	
	Item()
	{
	   System.out.println("test for git hub");
	}
	
    public Item(long _id, String itemName) {
		super();
		this._id = _id;
		this.itemName = itemName;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}	
    
	public Item(String itemName) {
		super();
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [_id=" + _id + ", itemName=" + itemName + "]";
	}        
}
