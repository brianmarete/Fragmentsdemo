package com.brianmarete.fragmentsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    int[] numbers = new int[100];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 100; i++) {
            numbers[i] = i;
        }

        RecyclerView numbersList = findViewById(R.id.list);
        NumberListAdapter adapter = new NumberListAdapter(numbers);
        numbersList.setAdapter(adapter);
        numbersList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
