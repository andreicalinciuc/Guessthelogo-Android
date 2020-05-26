package com.example.guess_the_logo;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guess_the_logo.Common.Common;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class newGame extends AppCompatActivity {

    public List<String> suggestSource = new ArrayList<>();

    public ImageView imgViewQuestion;

    int[] image_list = {

            R.drawable.blogger,
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
            R.drawable.youtube
    };

    public char[] answer;
    public int score=0;

    String correct_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.new_game );
        //Init View
//        initView();
    }

//    private void initView() {
//        gridViewAnswer = (GridView) findViewById( R.id.gridViewAnswer );
//        gridViewSuggest = (GridView) findViewById( R.id.gridViewSuggest );
//        imgViewQuestion = (ImageView) findViewById( R.id.imgLogo );
//
//        setupList();
//
//        btnSubmit = (Button) findViewById( R.id.btnSubmit );
//        btnSubmit.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String result = "";
//                for (int i = 0; i < Common.user_submit.length; i++)
//                    result += String.valueOf( Common.user_submit[i] );
//                if (result.equals( correct_answer )) {
//                    Toast.makeText( getApplicationContext(), "Greate  ! This is corect: " + result, Toast.LENGTH_SHORT ).show();
//
//                    //Reset
//                    Common.count = 0;
//                    Common.user_submit = new char[correct_answer.length()];
//
//                    //set new logo
//                    Answer answerAdapter = new Answer( setupNullList(), getApplicationContext() );
//                    gridViewAnswer.setAdapter( answerAdapter );
//                    answerAdapter.notifyDataSetChanged();
//
//                    Suggest suggestAdapter = new Suggest( suggestSource, getApplicationContext(), newGame.this ,score);
//                    gridViewSuggest.setAdapter( suggestAdapter );
//                    suggestAdapter.notifyDataSetChanged();
//
//                    setupList();
//                } else {
//                    Toast.makeText( newGame.this, "Incorrect!!!", Toast.LENGTH_SHORT ).show();
//                }
//            }
//        } );
//    }

//    private void setupList() {
//        //get random logo
//        Random random = new Random();
//        int imageSelected = image_list[random.nextInt( image_list.length )];
//        imgViewQuestion.setImageResource( imageSelected );
//
//        correct_answer = getResources().getResourceName( imageSelected );
//        correct_answer = correct_answer.substring( correct_answer.lastIndexOf( "/" ) + 1 );
//
//        answer = correct_answer.toCharArray();
//
//        Common.user_submit = new char[answer.length];
//
//        //add Answer character
//        suggestSource.clear();
//        for (char item : answer) {
//            //Add logo name to list
//            suggestSource.add( String.valueOf( item ) );
//        }
//
//        //random add some character
//        for (int i = answer.length; i < answer.length * 2; i++)
//            suggestSource.add( Common.alphabet[random.nextInt( Common.alphabet.length )] );
//
//        //sort random
//        Collections.shuffle( suggestSource );
//
//        //set for GridView
//        answerAdapter = new Answer( setupNullList(), this );
//        suggestAdapter = new Suggest( suggestSource, this, this ,score);
//
//        answerAdapter.notifyDataSetChanged();
//        suggestAdapter.notifyDataSetChanged();
//
//        gridViewSuggest.setAdapter( suggestAdapter );
//        gridViewAnswer.setAdapter( answerAdapter );
//
//    }
//
//    private char[] setupNullList() {
//        char result[] = new char[answer.length];
//        for (int i = 0; i < answer.length; i++)
//            result[i] = ' ';
//        return result;
//    }
}

