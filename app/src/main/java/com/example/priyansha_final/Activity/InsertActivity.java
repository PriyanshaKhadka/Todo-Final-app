package com.example.priyansha_final.Activity;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.Toast;

import com.example.priyansha_final.Database.Todo;
import com.example.priyansha_final.Database.TodoViewModel;
import com.example.priyansha_final.databinding.ActivityInsertBinding;

import java.util.Date;

public class InsertActivity extends AppCompatActivity {

    ActivityInsertBinding binding;

    String title, description;
    TodoViewModel todoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        binding.doneBtn.setOnClickListener(v -> {
            title = binding.title.getText().toString();
            description = binding.description.getText().toString();

            CreateItem(title, description);
        });
    }

    private void CreateItem(String title, String description) {

        Date date = new Date();
        CharSequence seq = DateFormat.format("MMMM, d, yyyy", date.getTime());

        Todo todos = new Todo();
        todos.title = this.title;
        todos.description = this.description;
        todos.date = seq.toString();

        todoViewModel.insertLists(todos);

        Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}
