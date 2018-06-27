package com.example.kamil.miwoklanguage;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int backgroundColorId;


    public WordAdapter(Activity context, ArrayList<Word> word, int backgroundColorId) {
        super(context,0, word);

        this.backgroundColorId = backgroundColorId;
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
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.textContainer);

        primaryItem.setText(currentWord.getMiwokTranslation());
        secondaryItem.setText(currentWord.getDefaultTranslation());
        linearLayout.setBackgroundColor(ContextCompat.getColor(getContext(), backgroundColorId));

        if(currentWord.getImageResourceId() != 0) {
            imageView.setImageResource(currentWord.getImageResourceId());

        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
