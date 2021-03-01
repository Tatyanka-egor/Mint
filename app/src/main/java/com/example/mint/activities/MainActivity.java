package com.example.mint.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.mint.AddActivity;
import com.example.mint.AppData;
import com.example.mint.database.entity.Data;
import com.example.mint.database.entity.Odejda;
import com.example.mint.R;
import com.example.mint.databinding.ActivityMainBinding;
import com.example.mint.databinding.ActivityMainProductBinding;
import com.example.mint.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppData appData;
    List<Odejda>meodejda=new ArrayList<>();
    OdejdaAdapter adapter;
    LayoutInflater inflater;
   ActivityMainBinding binding;
RequestManager glide;


AppData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater=getLayoutInflater();
        binding=ActivityMainBinding.inflate(inflater);
        setContentView(binding.getRoot());
        adapter=new OdejdaAdapter();
        binding.recyclerView.setAdapter(adapter);
        glide=Glide.with(this);
        data= Room.databaseBuilder(getApplicationContext(),AppData.class,
                "DataBilder").build();

        initOdejdaAdapter();
        binding.addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_add=new Intent(MainActivity.this, AddActivity.class);
                startActivity(activity_add);

            }
        });


    }

    private void initOdejdaAdapter() {
        adapter=new OdejdaAdapter();
        binding.recyclerView.setAdapter(adapter);
        appData.odejdaDAO().getAll().observe(this, new Observer<List<Odejda>>() {
            @Override
            public void onChanged(List<Odejda> odejdas) {
                meodejda=odejdas;
                adapter.notifyDataSetChanged();
            }
        });
    }

    private class OdejdaAdapter extends RecyclerView.Adapter <OdejdaAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(ItemProductBinding.inflate(inflater,parent,false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            final Odejda odejda=meodejda.get(position);
            holder.itemProductBinding.naming.setText(odejda.Title);
            holder.itemProductBinding.saletext.setText(odejda.Price);
            Data.loadImage(odejda.Picture,holder.itemProductBinding.imageprod);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,MainProduct.class);
                    intent.putExtra("Id",odejda.OdejID);
                     startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return meodejda.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
           private ItemProductBinding itemProductBinding;
           public ViewHolder(ItemProductBinding itemView){
               super(itemView.getRoot());
               itemProductBinding=itemView;

           }
        }
    }
}