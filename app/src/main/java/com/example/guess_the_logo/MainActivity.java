package com.example.guess_the_logo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.guess_the_logo.Game.GameActivity;


public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    private static final int GAME_HIGHSCORE_RESULT = 200;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.newGame:
                startActivityForResult( new Intent( this, GameActivity.class ), GAME_HIGHSCORE_RESULT );
                break;

            case R.id.share:
                Intent myIntent = new Intent( Intent.ACTION_SEND );
                myIntent.setType( "text/plain" );
                String shareBody = "I play https://i.diawi.com/Dbt5Gg and " + "my highScore is:" + sharedPreferences.getInt( "highScore", 0 );
                myIntent.putExtra( Intent.EXTRA_SUBJECT, shareBody );
                myIntent.putExtra( Intent.EXTRA_TEXT, shareBody );
                startActivity( Intent.createChooser( myIntent, "Share using" ) );
                break;


        }
        return super.onOptionsItemSelected( item );
    }

    private void setHighScore(int score) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt( "highScore", score ).commit();

    }

    private int getHighScore() {

        return sharedPreferences.getInt( "highScore", 0 );

    }
    @Override
    public void onResume(){
        super.onResume();

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.e( "on acrtivity:", String.valueOf( data.getIntExtra( "highScore", getHighScore()  )));
        switch (requestCode) {
            case GAME_HIGHSCORE_RESULT: {
                assert data != null;
                if (sharedPreferences.getInt( "highScore", 0 ) < data.getIntExtra( "highScore", getHighScore() ))
                    setHighScore( data.getIntExtra( "highScore", getHighScore() ) );
            }
        }
        super.onActivityResult( requestCode, resultCode, data );
    }


    @Override
    protected void onStart() {
        super.onStart();
        TextView highScoreView = findViewById( R.id.highScoreView );
        Integer highScore = getHighScore();
        highScoreView.setText( "Your high score is  " + highScore );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getPreferences(MODE_PRIVATE);
    }


}

