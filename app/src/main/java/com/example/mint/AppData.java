package com.example.mint;

import android.content.Context;
import android.widget.ImageView;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mint.presentation.activities.database.dao.OdejdaDAO;
import com.example.mint.presentation.activities.database.entity.Odejda;

import java.util.List;

import static androidx.room.Room.databaseBuilder;


public class AppData  {


        public static final String ID="id";
        private static AppData instanse;


     public static AppData getInstance(Context context){
         if (instanse==null)
             instanse=new AppData(context);
         return instanse;
     }

     public AppDataBase db;
      RequestManager glade;

     private AppData(Context context){

            db= Room.databaseBuilder(context,
                    AppDataBase.class,"Magazin")
                    .allowMainThreadQueries().build();
            glade= Glide.with(context);

        }


        public  void loadImage(String url, ImageView view){
            glade.load(url).placeholder(R.drawable.ic_launcher_foreground).into(view);
        }



    }

