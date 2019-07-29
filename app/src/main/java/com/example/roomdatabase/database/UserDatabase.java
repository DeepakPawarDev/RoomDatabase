package com.example.roomdatabase.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.dao.UserDAO;
import com.example.roomdatabase.room.entities.User;

@Database(version = 1, entities = {User.class})
public abstract  class UserDatabase extends RoomDatabase {

    public static UserDatabase userDatabase;
    abstract public UserDAO userDAO();

    public static UserDatabase getUserDatabase(Context context){

        if (userDatabase==null){

            userDatabase= Room.databaseBuilder(context,UserDatabase.class,"user_db").allowMainThreadQueries().build();
        }
        return  userDatabase;
    }
}
