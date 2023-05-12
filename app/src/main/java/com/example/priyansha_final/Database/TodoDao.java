package com.example.priyansha_final.Database;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface TodoDao {

    @Query("SELECT * FROM todo_db")
    public LiveData<List<Todo>> getallToDo();

    @Query("SELECT * FROM todo_db ORDER BY title ASC")
    public LiveData<List<Todo>> getallSortedToDo();

    @Insert
    public void insertList(Todo... todo);

    @Query("DELETE FROM todo_db WHERE id=:id")
    public void deleteList(int id);

    @Query("DELETE FROM todo_db")
    public void deleteAll();

    @Update
    public void updateList(Todo todo);

}

