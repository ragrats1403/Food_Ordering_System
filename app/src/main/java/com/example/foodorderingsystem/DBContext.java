package com.example.foodorderingsystem;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Users.class},version = 1)
public abstract class DBContext extends RoomDatabase {

    public abstract Users_DAO usersdao();
    private static DBContext INSTANCE;
    public static DBContext getInstance(Context context)
    {
      if(INSTANCE == null)
      {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DBContext.class, "FoodOrderingSystem").allowMainThreadQueries().build();
      }
        return INSTANCE;
    }

    public static void destroyInstance()
    {
        INSTANCE = null;
    }
}
