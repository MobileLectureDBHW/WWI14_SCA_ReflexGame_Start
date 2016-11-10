package de.dietzm.reflexgame.db;

import android.provider.BaseColumns;

//Datenbank
public class HighscoreContract {

	
	//Datenbanktabelle
	public class HighscoreEntryContract implements BaseColumns{
		public final static String TABLE_NAME = "highscore_entry";
		public final static String COLUMN_PLAYER_NAME = "player";
		public final static String COLUMN_LEVEL_NAME = "level";
		public final static String COLUMN_POINTS_NAME = "points";
	}

	
}
