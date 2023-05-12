package com.example.priyansha_final.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1)
public abstract class TodoDb extends RoomDatabase {
    public abstract TodoDao dao();

    public static TodoDb INSTANCE;

    public static TodoDb getDatabaseInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), TodoDb.class,
                    "todo_db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
