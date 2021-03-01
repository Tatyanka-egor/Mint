package com.example.mint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.mint.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {
    AppData appData;
    ActivityAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        binding=ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData=AppData.getInstance(this);
        binding.photoTexturl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                appData.loadImage(value.toString);
            }
        });
    }
}