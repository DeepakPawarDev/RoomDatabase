package com.example.roomdatabase.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomdatabase.room.entities.User;

@Dao
public interface UserDAO {

    @Insert
    public void inserUser(User user);
    @Query("SELECT * FROM user")
    public User[] loadAllUsers();
}
