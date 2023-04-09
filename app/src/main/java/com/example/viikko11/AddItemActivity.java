package com.example.viikko11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText Item;
    private EditText Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void addItem(View view) {
        Item = findViewById(R.id.idItem);
        Info = findViewById(R.id.idInfo);
        Item item = new Item(Item.getText().toString(), Info.getText().toString());
        Storage.getInstance().addItem(item);

    }


}