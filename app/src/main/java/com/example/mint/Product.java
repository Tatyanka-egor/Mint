package com.example.mint;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.text.DecimalFormat;

public class Product {
   // public int id;
    //public String title,size,category,material,manufacturer,picture,price;
 @PrimaryKey
    public final static String Title="title";
 @ColumnInfo
    public final static String SizePr="sizePr";
 @ColumnInfo
    public final static String Category="category";
 @ColumnInfo
    public final static String Material="material";
 @ColumnInfo
    public final static String Manufacturer="manufacturer";
 @ColumnInfo
    public final static String Picture="picture";
 @ColumnInfo
    public final static String Price="price";


}
