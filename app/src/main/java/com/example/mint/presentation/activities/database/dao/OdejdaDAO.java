package com.example.mint.presentation.activities.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mint.presentation.activities.database.entity.Odejda;

import java.util.List;

public interface OdejdaDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Odejda... odejdas);
    @Insert
    void insertAll(Odejda... odejdas);

    @Delete
    void delete(Odejda odejda);

    @Query("SELECT * FROM Odejda")
    LiveData<List<Odejda>> getAll();

    @Query("SELECT * FROM odejda WHERE OdejID == :Id")
    LiveData<Odejda> findById(int Id);


}

