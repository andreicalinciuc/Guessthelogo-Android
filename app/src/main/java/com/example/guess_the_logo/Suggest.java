package com.example.guess_the_logo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.guess_the_logo.Common.Common;

import java.util.List;

public class Suggest extends BaseAdapter {

    private List<String> suggest;
    private Context context;
    private newGame mainActivity;
    private int score;

    public Suggest(List<String> suggest, Context context, newGame mainActivity,int score) {
        this.suggest = suggest;
        this.context = context;
        this.mainActivity = mainActivity;
        this.score=score;
    }

    @Override
    public int getCount() {
        return suggest.size();
    }

    @Override
    public Object getItem(int i) {
        return suggest.get( i );
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        Button button;
        if (view == null) {
            if (suggest.get( i ).equals( "null" )) {
                button = new Button( context );
                button.setLayoutParams( new GridView.LayoutParams( 80, 80 ) );
                button.setPadding( 8, 8, 8, 8 );
                button.setBackgroundColor( Color.GRAY );
            } else {
                button = new Button( context );
                button.setLayoutParams( new GridView.LayoutParams( 80, 80 ) );
                button.setPadding( 8, 8, 8, 8 );
                button.setBackgroundColor( Color.GRAY );
                button.setTextColor( Color.GREEN );
                button.setText( suggest.get( i ) );
                button.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (String.valueOf( mainActivity.answer ).contains( suggest.get( i ) )) {

                            char compare = suggest.get( i ).charAt( 0 );

                            for (int index = 0; index < mainActivity.answer.length; index++) {
                                if (compare == mainActivity.answer[index]) {
                                    Common.user_submit[index] = compare;
                                }
                            }

                            //update
                            Answer answerAdapter = new Answer( Common.user_submit, context );
                            mainActivity.gridViewAnswer.setAdapter( answerAdapter );
                            answerAdapter.notifyDataSetChanged();

                            //remove suggest

                            mainActivity.suggestSource.set( i, "null" );
                            mainActivity.suggestAdapter = new Suggest( mainActivity.suggestSource, context, mainActivity ,score+1);
                            mainActivity.gridViewSuggest.setAdapter( mainActivity.suggestAdapter );
                            mainActivity.suggestAdapter.notifyDataSetChanged();

                        } else {
                            mainActivity.suggestSource.set( i, "null" );
                            mainActivity.suggestAdapter = new Suggest( mainActivity.suggestSource, context, mainActivity,score-1 );
                            mainActivity.gridViewSuggest.setAdapter( mainActivity.suggestAdapter );
                            mainActivity.suggestAdapter.notifyDataSetChanged();
                        }

                    }
                } );
            }

        } else {

            button = (Button) view;
        }

        System.out.println(score);

        return button;
    }
}
