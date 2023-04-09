package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Storage storage;

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvListItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(getApplicationContext(), storage.getItems());
        recyclerView.setAdapter(adapter);

        Button sortByTime = findViewById(R.id.sortByTime);
        sortByTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Storage.getInstance().sortByDateAdded();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });

        Button sortByAlphabet = findViewById(R.id.sortByAlphabet);
        sortByAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage.getInstance().sortByAlphabeticalOrder();
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        });


    }

    public void switchToAddItem(View view) {
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
