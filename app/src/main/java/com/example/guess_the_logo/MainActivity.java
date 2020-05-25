package com.example.guess_the_logo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.newGame:
                startActivity(new Intent(this, newGame.class));
                break;

            case R.id.heightScore:
                startActivity(new Intent(this, hightScore.class));
                break;

            case R.id.share:
                Toast.makeText( this, "3", Toast.LENGTH_SHORT ).show();
                break;


        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

    }

}

