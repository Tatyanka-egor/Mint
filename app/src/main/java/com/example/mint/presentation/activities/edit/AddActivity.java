package com.example.mint.presentation.activities.edit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.mint.AppData;
import com.example.mint.R;
import com.example.mint.presentation.activities.database.entity.Odejda;
import com.example.mint.databinding.ActivityAddBinding;

public class AddActivity extends AppCompatActivity {

    AppData appData;
    ActivityAddBinding binding;
    Odejda meodejda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        binding=ActivityAddBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        appData =  AppData.getInstance(getApplicationContext());

        appData.loadImage("",binding.PicView);

        int id=getIntent().getIntExtra(AppData.ID,-1);
        if(id==-1){
            meodejda=new Odejda();
        }
        else{
            appData.db.odejdaDAO().findById(id).observe(this, new Observer<Odejda>() {
                @Override
                public void onChanged(Odejda odejda) {
                    if(odejda==null)
                        finish();
                    meodejda=odejda;
                    binding.Nametv.setText(odejda.Title);
                    binding.Proizvodtv.setText(odejda.Manufacturer);
                    binding.Kategortv.setText(odejda.Category);
                    binding.Saletv.setText(odejda.Price);
                    binding.Materialtv.setText(odejda.Material);
                    appData.loadImage(odejda.Picture,binding.PicView);
                    binding.photoTexturl.setText(odejda.Picture);
                }
            });
            binding.delbut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Вы уверены?")
                            .setTitle("Удаление пользователя")
                            .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    appData.db.odejdaDAO().delete(meodejda);
                                    finish();
                                }
                            }).setNegativeButton("Отмена",null);
                    builder.show();

                }
            });
        }









        binding.photoTexturl.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                appData.loadImage(binding.photoTexturl.getText().toString(),binding.PicView);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        binding.butttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (meodejda!=null){
                    meodejda.Title=binding.Nametv.getText().toString();
                    meodejda.Category=binding.Kategortv.getText().toString();
                    meodejda.Manufacturer=binding.Proizvodtv.getText().toString();
                    meodejda.Price=binding.Saletv.getText().toString();
                    meodejda.Picture=binding.photoTexturl.getText().toString();
                    appData.db.odejdaDAO().insert(meodejda);
                    finish();
                }
            }
        });
    }
}