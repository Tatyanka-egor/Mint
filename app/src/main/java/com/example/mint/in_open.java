package com.example.mint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;

public class in_open extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_open);
        NumberPicker userTypePicker = findViewById(R.id.user_in);
        userTypePicker.setMaxValue(1);
        userTypePicker.setMinValue(0);
        userTypePicker.setDisplayedValues(new String[]{"User","Admin"});
    }

    public void OnClickin(View view) {
        Intent mainActivity =new Intent(in_open.this,MainActivity.class);
        startActivity(mainActivity);
    }

}