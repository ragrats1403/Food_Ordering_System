package com.example.foodorderingsystem;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface Users_DAO {
    @Insert
    Long insertuser(Users user);
}
