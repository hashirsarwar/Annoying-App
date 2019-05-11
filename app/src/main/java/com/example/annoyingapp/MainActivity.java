package com.example.annoyingapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Welcome to Book World");
        ArrayList<String> books = new ArrayList<>();
        books.add("The Lion, the Witch and the Wardrobe");
        books.add("She: A History of Adventure");
        books.add("The Da Vinci Code");
        books.add("Harry Potter and the Chamber of Secrets");
        books.add("The Alchemist");
        books.add("The Catcher in the Rye");
        RecyclerView rv = findViewById(R.id.books);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        BooksAdapter adapter = new BooksAdapter(books);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = new Intent(this, ScaryService.class);
        startService(intent);
    }
}
