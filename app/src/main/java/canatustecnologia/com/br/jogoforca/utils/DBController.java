package canatustecnologia.com.br.jogoforca.utils;

import java.util.ArrayList;
import java.util.HashMap;

import android.util.Log;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBController  extends SQLiteOpenHelper {
	private static final String LOGCAT = null;

	public DBController(Context applicationcontext) {
        super(applicationcontext, "androidsqlite.db", null, 2);
        Log.d(LOGCAT,"Criado");
    }
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		String query;
		query = "CREATE TABLE palavra ( id INTEGER PRIMARY KEY, descricao TEXT, dica TEXT)";
        database.execSQL(query);
        Log.d(LOGCAT,"Tabela palavra criada com sucesso!");
	}
	@Override
	public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
		String query;
		query = "DROP TABLE IF EXISTS palavra";
		database.execSQL(query);
        onCreate(database);
	}
	
	public void insertPalavra(HashMap<String, String> queryValues) {
		SQLiteDatabase database = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("descricao", queryValues.get("descricao"));
		values.put("dica", queryValues.get("dica"));
		database.insert("palavra", null, values);
		database.close();
	}
	
	public int updatePalavra(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put("descricao", queryValues.get("descricao"));
		values.put("dica", queryValues.get("dica"));
	    return database.update("palavra", values, "id" + " = ?", new String[] { queryValues.get("id") });
	}
	
	public void deletePalavra(String id) {
		Log.d(LOGCAT,"delete");
		SQLiteDatabase database = this.getWritableDatabase();	 
		String deleteQuery = "DELETE FROM  palavra WHERE id='"+ id +"'";
		Log.d("query",deleteQuery);		
		database.execSQL(deleteQuery);
	}
	
	public ArrayList<HashMap<String, String>> getAllPalavras() {
		ArrayList<HashMap<String, String>> wordList;
		wordList = new ArrayList<HashMap<String, String>>();
		String selectQuery = "SELECT  * FROM palavra";
	    SQLiteDatabase database = this.getWritableDatabase();
	    Cursor cursor = database.rawQuery(selectQuery, null);
	    if (cursor.moveToFirst()) {
	        do {
	        	HashMap<String, String> map = new HashMap<String, String>();
	        	map.put("id", cursor.getString(0));
	        	map.put("descricao", cursor.getString(1));
				map.put("dica", cursor.getString(2));
                wordList.add(map);
	        } while (cursor.moveToNext());
	    }
	 
	    // return contact list
	    return wordList;
	}
	
	public HashMap<String, String> getPalavraInfo(String id) {
		HashMap<String, String> wordList = new HashMap<String, String>();
		SQLiteDatabase database = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM palavra where id='"+id+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
	        do {
	        	wordList.put("descricao", cursor.getString(1));
				wordList.put("dica", cursor.getString(2));
	        } while (cursor.moveToNext());
	    }				    
	return wordList;
	}	
}
