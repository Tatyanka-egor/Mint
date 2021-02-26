package com.example.mint;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = (Odejda.class),version = 1)
abstract public class AppData extends RoomDatabase {
  public abstract OdejdaDAO odejdaDAO();
}
