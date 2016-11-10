package de.dietzm.reflexgame.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelperKlasse extends SQLiteOpenHelper {

	private Context context;

	public DBHelperKlasse(Context context) {
		super(context, "HIGHSCORE", null, 1);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sql = "CREATE TABLE " + HighscoreContract.HighscoreEntryContract.TABLE_NAME + " ("
				+ HighscoreContract.HighscoreEntryContract._ID + " INTEGER PRIMARY KEY,"
				+ HighscoreContract.HighscoreEntryContract.COLUMN_PLAYER_NAME + " TEXT,"
				+ HighscoreContract.HighscoreEntryContract.COLUMN_LEVEL_NAME + " INTEGER,"
				+ HighscoreContract.HighscoreEntryContract.COLUMN_POINTS_NAME + " INTEGER )";

		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//Nothing to do so far
	}

	public HighscoreEntry[] loadHighscoreData() {

        SQLiteDatabase db = getReadableDatabase();

		String[] cols = { HighscoreContract.HighscoreEntryContract.COLUMN_PLAYER_NAME,
				HighscoreContract.HighscoreEntryContract.COLUMN_LEVEL_NAME,
				HighscoreContract.HighscoreEntryContract.COLUMN_POINTS_NAME,
				HighscoreContract.HighscoreEntryContract._ID };

		Cursor cur = db.query(HighscoreContract.HighscoreEntryContract.TABLE_NAME, cols, null,
				null, null, null, null);

		String players = "";
		ArrayList<HighscoreEntry> entries = new ArrayList<HighscoreEntry>();

		while (cur.moveToNext()) {
			String name = cur.getString(0);
			int level = cur.getInt(1);
			int points = cur.getInt(2);
			HighscoreEntry entry = new HighscoreEntry();
			entry.setPlayerName(name);
			entry.setLevel(level);
			entry.setPoints(points);
			entries.add(entry);
		}

		return entries.toArray(new HighscoreEntry[entries.size()]);

	}

	public long createHighscoreEntry(HighscoreEntry entry){

		SQLiteDatabase db = getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(HighscoreContract.HighscoreEntryContract.COLUMN_PLAYER_NAME, entry.getPlayerName());
		cv.put(HighscoreContract.HighscoreEntryContract.COLUMN_LEVEL_NAME, entry.getLevel());
		cv.put(HighscoreContract.HighscoreEntryContract.COLUMN_POINTS_NAME, entry.getPoints());

		long newRowId = db.insert(HighscoreContract.HighscoreEntryContract.TABLE_NAME, null, cv);
		return newRowId;
	}
}
