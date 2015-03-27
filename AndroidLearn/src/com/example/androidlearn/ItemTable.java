package com.example.androidlearn;



import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ItemTable {
	static final String TABLENAME = "item";
	static final String Column_Id = "id";
	static final String Column_Item = "itemdescription";
	static public void onCreate(SQLiteDatabase db)
	{
		StringBuilder sb =new StringBuilder();
		sb.append("CREATE TABLE "+TABLENAME+"(");
		sb.append(Column_Id + " integer primary key autoincrement,");
		sb.append(Column_Item + " text not null );");
		try{
		db.execSQL(sb.toString());
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}		
	}
	
	static public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS "+ TABLENAME);
		ItemTable.onCreate(db);
	}


}
