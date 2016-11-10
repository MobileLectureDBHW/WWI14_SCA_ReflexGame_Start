package de.dietzm.reflexgame;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void registerPlayer(View view){

        EditText playerInput = (EditText) findViewById(R.id.playerInput);
        SeekBar levelSeekbar = (SeekBar) findViewById(R.id.levelSeekbar);

        String playerName = playerInput.getText().toString();
        int level = levelSeekbar.getProgress();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("PLAYER", playerName);
        editor.putInt("LEVEL", level);

        editor.commit();

    }
}
