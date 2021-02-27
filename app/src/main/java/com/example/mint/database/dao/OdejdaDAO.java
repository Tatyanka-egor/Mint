package com.example.mint.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mint.database.entity.Odejda;

import java.util.List;

public interface OdejdaDAO {
    @Update
    void update(Odejda... odejdas);
    @Insert
    void insertAll(Odejda... odejdas);

    @Delete
    void delete(Odejda odejda);

    @Query("SELECT * FROM Odejda")
    LiveData<List<Odejda>> getAll();
}
