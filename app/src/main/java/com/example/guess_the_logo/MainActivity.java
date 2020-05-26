package com.example.guess_the_logo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
                String shareBody = "I play https://i.diawi.com/Dbt5Gg and "+"my highScore is:" + getHighScore();
                myIntent.putExtra( Intent.EXTRA_SUBJECT, shareBody );
                myIntent.putExtra( Intent.EXTRA_TEXT, shareBody );
                startActivity( Intent.createChooser( myIntent, "Share using" ) );
                break;


        }
        return super.onOptionsItemSelected( item );
    }

    private void setHighScore(int score) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt( "highScore", score );
        editor.commit();
    }

    private int getHighScore() {

        Log.e( null, String.valueOf( sharedPreferences.getInt( "highScore", 0 ) ) );
        return sharedPreferences.getInt( "highScore", 0 );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case GAME_HIGHSCORE_RESULT: {
                setHighScore( data.getIntExtra( "highScore", getHighScore() ) );
            }
        }
        super.onActivityResult( requestCode, resultCode, data );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        sharedPreferences = getPreferences( MODE_PRIVATE );
        TextView highScoreView = findViewById( R.id.highScoreView );
        highScoreView.setText( "Your high score is " + sharedPreferences.getInt( "highScore", 0 ) );


    }

}

