package com.example.mint;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mint.database.dao.OdejdaDAO;
import com.example.mint.database.entity.Odejda;

@Database(entities = (Odejda.class),version = 1)
abstract public class AppData extends RoomDatabase {
  public abstract OdejdaDAO odejdaDAO();
}
