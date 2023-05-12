package com.example.priyansha_final.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.priyansha_final.Database.Todo;
import com.example.priyansha_final.Database.TodoViewModel;
import com.example.priyansha_final.R;
import com.example.priyansha_final.databinding.ActivityUpdateBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Date;

public class UpdateActivity extends AppCompatActivity {

    ActivityUpdateBinding binding;
    String ntitle, ndesc;
    TodoViewModel todoViewModel;
    int nid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        todoViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        nid = getIntent().getIntExtra("id", 0);
        ntitle = getIntent().getStringExtra("title");
        ndesc = getIntent().getStringExtra("description");

        binding.updateTitle.setText(ntitle);
        binding.updateDesc.setText(ndesc);

        binding.updateBtn.setOnClickListener(v ->{
            String title = binding.updateTitle.getText().toString();
            String description = binding.updateDesc.getText().toString();

            UpdateItem(title, description);
        });
    }

    private void UpdateItem(String title, String description) {
        Date date = new Date();
        CharSequence seq = DateFormat.format("MMMM, d, yyyy", date.getTime());

        Todo updateTodo = new Todo();
        updateTodo.id = nid;
        updateTodo.title = title;
        updateTodo.description = description;
        updateTodo.date = seq.toString();

        todoViewModel.updateLists(updateTodo);

        Toast.makeText(this, "Item updated successfully", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.delete_item)
        {
            BottomSheetDialog sheetDialog = new BottomSheetDialog(UpdateActivity.this);
            View view = LayoutInflater.from(UpdateActivity.this).
                    inflate(R.layout.delete_confirm, (LinearLayout)findViewById(R.id.confirm_del));

            sheetDialog.setContentView(view);

            TextView yes, no;

            yes = view.findViewById(R.id.del_yes);
            no = view.findViewById(R.id.del_no);

            yes.setOnClickListener(v->{
                todoViewModel.deleteLists(nid);
                finish();
            });

            no.setOnClickListener(v->{
                sheetDialog.dismiss();
            });

            sheetDialog.show();

        }
        return true;
    }
}