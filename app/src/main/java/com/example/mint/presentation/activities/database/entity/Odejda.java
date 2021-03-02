package com.example.mint.presentation.activities.database.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Odejda {
    // public int id;
    //public String title,size,category,material,manufacturer,picture,price;
    @PrimaryKey(autoGenerate = true)
    public int OdejID;

    public String Title;

    public  String SizePr;

    public  String Category;

    public  String Material;

    public  String Manufacturer;

    public  String Picture;

    public  String Price;

}
