package com.example.priyansha_final.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TodoRepository {

    public TodoDao dao;
    public LiveData<List<Todo>> getallTodo;

    public LiveData<List<Todo>> getallSortedTodo(){
        return dao.getallSortedToDo();
    };

    public TodoRepository(Application application) {
        TodoDb db = TodoDb.getDatabaseInstance(application);
        dao = db.dao();
        getallTodo = dao.getallToDo();
    }

    public void insertList(Todo todo){
        dao.insertList(todo);
    }

    public void deleteList(int id){
        dao.deleteList(id);
    }

    public void deleteAll(){
        dao.deleteAll();
    }

    public void updateList(Todo todo){
        dao.updateList(todo);
    }
}
