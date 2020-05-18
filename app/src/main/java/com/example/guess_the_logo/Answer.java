package com.example.guess_the_logo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;

public class Answer extends BaseAdapter {
    private  char [] answerCharacter;
    private Context context;

    public Answer(char[] answerCharacter, Context context) {
        this.answerCharacter = answerCharacter;
        this.context = context;
    }

    @Override
    public int getCount() {
        return answerCharacter.length;
    }

    @Override
    public Object getItem(int i) {
        return answerCharacter[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        if(view ==null){
            button = new Button(context);
            button.setLayoutParams( new GridView.LayoutParams( 80,80 ) );
            button.setPadding( 8,8,8,8);
            button.setBackgroundColor( Color.GRAY );
            button.setTextColor( Color.GREEN );
            button.setText(String.valueOf( answerCharacter[i] ));
        }
        else
            button = (Button) view;
        return button;
    }
}
