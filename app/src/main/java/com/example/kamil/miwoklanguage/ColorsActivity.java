package com.example.kamil.miwoklanguage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi"));
        words.add(new Word("mustard yellow", "chiwiiṭә"));
        words.add(new Word("dusty yellow", "ṭopiisә"));
        words.add(new Word("green", "chokokki"));
        words.add(new Word("brown", "ṭakaakki"));
        words.add(new Word("gray", "ṭopoppi"));
        words.add(new Word("black", "kululli"));
        words.add(new Word("white", "kelelli"));

        ListView listView = (ListView) findViewById(R.id.wordList);

        WordAdapter wordAdapter = new WordAdapter(this, words);
        listView.setAdapter(wordAdapter);
    }
}
