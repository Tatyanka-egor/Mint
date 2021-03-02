package com.example.mint;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mint.presentation.activities.database.dao.OdejdaDAO;
import com.example.mint.presentation.activities.database.entity.Odejda;

@Database(entities = {Odejda.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract OdejdaDAO odejdaDAO();
}
