package com.example.priyansha_final.Database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    public TodoRepository repo;
    public LiveData<List<Todo>> getallTodo;

    public LiveData<List<Todo>> getallSortedTodo(){
        return repo.getallSortedTodo();
    };

    public TodoViewModel(@NonNull Application application) {
        super(application);

        repo = new TodoRepository(application);
        getallTodo = repo.getallTodo;
    }

    public void insertLists(Todo todo){
        repo.insertList(todo);
    }

    public void deleteLists(int id){
        repo.deleteList(id);
    }

    public void deleteAll(){
        repo.deleteAll();
    }

    public void updateLists(Todo todo){
        repo.updateList(todo);
    }
}
