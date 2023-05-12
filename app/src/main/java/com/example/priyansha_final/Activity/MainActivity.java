package com.example.priyansha_final.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.priyansha_final.Database.TodoViewModel;
import com.example.priyansha_final.R;
import com.example.priyansha_final.TodoAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton add_new;
    TodoViewModel todoViewModel;
    RecyclerView recycler;
    TodoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_new = findViewById(R.id.add_new);
        recycler = findViewById(R.id.recycler);
        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel.class);

        add_new.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, InsertActivity.class));
        });

        //using observer provided by live data
        todoViewModel.getallTodo.observe(this, todo ->{
            recycler.setLayoutManager(new GridLayoutManager(this, 2));
            adapter = new TodoAdapter(MainActivity.this, todo);
            recycler.setAdapter(adapter);
        });
    }
}