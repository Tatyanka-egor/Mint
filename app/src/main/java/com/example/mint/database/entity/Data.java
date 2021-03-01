package com.example.mint.database.entity;

import android.content.Context;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mint.AppData;
import com.example.mint.R;

import java.util.List;

public class Data {
    private static Data instanse;
    public AppData data;
     RequestManager glade;

    private Data(Context context){
        data= Room.databaseBuilder(context,AppData.class,"Magazin").allowMainThreadQueries().build();

    }
    public static Data getInstance(Context context){
        if (instanse==null)instanse=new Data(context);
        return instanse;
    }

    public LiveData<List<Odejda>> GetAllOdejda(){ return data.odejdaDAO().getAll(); }

    public static void loadImage(String url, ImageView view){
        glade.load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(view);
    }

}
