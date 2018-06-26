package com.example.kamil.miwoklanguage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();


    public WordAdapter(Activity context, ArrayList<Word> word) {
        super(context,0, word);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView primaryItem = (TextView) listItemView.findViewById(R.id.textViewPrimary);
        TextView secondaryItem = (TextView) listItemView.findViewById(R.id.textViewSecondary);

        primaryItem.setText(currentWord.getMiwokTranslation());
        secondaryItem.setText(currentWord.getDefaultTranslation());

        return listItemView;
    }
}
