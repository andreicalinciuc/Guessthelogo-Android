package com.example.guess_the_logo.Game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guess_the_logo.GameModel;
import com.example.guess_the_logo.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    GameModel game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        getSupportActionBar().setDisplayShowHomeEnabled( true );
        game = new GameModel( new ArrayList<Integer>( Arrays.asList( R.drawable.blogger,
                R.drawable.deviantart,
                R.drawable.digg,
                R.drawable.dropbox,
                R.drawable.evernote,
                R.drawable.facebook,
                R.drawable.flickr,
                R.drawable.google,
                R.drawable.googleplus,
                R.drawable.hyves,
                R.drawable.instagram,
                R.drawable.linkedin,
                R.drawable.myspace,
                R.drawable.picasa,
                R.drawable.pinterest,
                R.drawable.reddit,
                R.drawable.rss,
                R.drawable.skype,
                R.drawable.soundcloud,
                R.drawable.stumbleupon,
                R.drawable.twitter,
                R.drawable.vimeo,
                R.drawable.wordpress,
                R.drawable.yahoo,
                R.drawable.youtube ) ), getResources(), null ) {
            @Override
            public void onNewRound() {
                TextView scoreView = findViewById( R.id.scoreView );
                scoreView.setText( "Score:" + this.getScore() );
                ImageView logoView = findViewById( R.id.logoView );
                logoView.setImageResource( this.getCurrentLogo() );
            }
        };

        Button submitView = findViewById( R.id.submitView );
        submitView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText logoInput = findViewById( R.id.logoInput );
                String logoInputValue = logoInput.getText().toString();
                game.checkName( logoInputValue );
                logoInput.setText( "" );
            }
        } );

    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent();
        intent.putExtra( "highScore", game.getHighScore() );
        setResult( RESULT_OK, intent );
        finish();
        return true;
    }
}