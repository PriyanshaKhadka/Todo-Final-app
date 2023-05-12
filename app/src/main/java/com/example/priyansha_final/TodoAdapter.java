package com.example.priyansha_final;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.priyansha_final.Activity.MainActivity;
import com.example.priyansha_final.Activity.UpdateActivity;
import com.example.priyansha_final.Database.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.todoViewHolder>{
    MainActivity mainActivity;
    List<Todo> todo;

    public TodoAdapter(MainActivity mainActivity, List<Todo> todo) {
        this.mainActivity = mainActivity;
        this.todo = todo;
    }

    @Override
    public TodoAdapter.todoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new todoViewHolder(LayoutInflater.from(mainActivity).inflate(R.layout.todo_item, parent, false));
    }

    @Override
    public void onBindViewHolder(TodoAdapter.todoViewHolder holder, int position) {
        Todo todo1 = todo.get(position);
        holder.title.setText(todo1.title);
        holder.description.setText(todo1.description);
        holder.date.setText(todo1.date);

        holder.itemView.setOnClickListener(v ->{
            Intent intent = new Intent(mainActivity, UpdateActivity.class);

            intent.putExtra("id", todo1.id);
            intent.putExtra("title", todo1.title);
            intent.putExtra("description", todo1.description);

            mainActivity.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return todo.size();
    }

    static class todoViewHolder extends RecyclerView.ViewHolder{

        TextView title, description, date;

        public todoViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.desc);
            date = itemView.findViewById(R.id.date);
        }
    }
}
