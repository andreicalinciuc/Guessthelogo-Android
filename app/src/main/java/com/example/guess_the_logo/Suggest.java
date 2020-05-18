package com.example.guess_the_logo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

import java.util.List;

public class Suggest  extends BaseAdapter
{

    private List<String> suggest;
    private Context context;
    private  MainActivity mainActivity;

    public Suggest(List<String> suggest, Context context, MainActivity mainActivity) {
        this.suggest = suggest;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public int getCount() {
        return suggest.size();
    }

    @Override
    public Object getItem(int i) {
        return suggest.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Button button;
        if(view ==null){
            if(suggest.get( i ).equals( "null" )){
                button = new Button( context );
                button.setLayoutParams( new GridView.LayoutParams( 80,80 ) );
                button.setPadding( 8,8,8,8 );
                button.setBackgroundColor( Color.GRAY );
            }
            else{
                button = new Button( context );
                button.setLayoutParams( new GridView.LayoutParams( 80,80 ) );
                button.setPadding( 8,8,8,8 );
                button.setBackgroundColor( Color.GRAY );
                button.setTextColor( Color.GREEN );
                button.setText( suggest.get(i) );
                button.setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
//
                    }
                } );
            }

        }
        else{
            button = (Button) view;
        }


        return button;
    }
}
