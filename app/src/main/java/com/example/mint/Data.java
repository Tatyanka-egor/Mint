package com.example.mint;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class Data {
    private static Data instanse;
    public AppData data;
    private Data(Context context){
        data= Room.databaseBuilder(context,AppData.class,"Magazin").allowMainThreadQueries().build();
    }
    public static Data getInstance(Context context){
        if (instanse==null)instanse=new Data(context);
        return instanse;
    }
}
