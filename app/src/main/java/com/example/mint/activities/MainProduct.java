package com.example.mint.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mint.R;

public class MainProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_product);

    }

    public static class Product extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.item_product);

        }
    }
}