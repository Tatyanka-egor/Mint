package com.example.mint.presentation.activities.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.mint.presentation.activities.MainProduct;
import com.example.mint.presentation.activities.edit.AddActivity;
import com.example.mint.AppData;
import com.example.mint.presentation.activities.database.entity.Odejda;
import com.example.mint.databinding.ActivityMainBinding;
import com.example.mint.databinding.ItemProductBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    AppData appData;
    List<Odejda>meodejda=new ArrayList<>();
    OdejdaAdapter adapter;
    LayoutInflater inflater;
   ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater=getLayoutInflater();
        binding=ActivityMainBinding.inflate(inflater);
        setContentView(binding.getRoot());

        appData=AppData.getInstance(getApplicationContext());
        InitOdejdaAdapter();




        binding.addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity_add=new Intent(MainActivity.this, AddActivity.class);
                startActivity(activity_add);

            }
        });


    }

    private void InitOdejdaAdapter() {
        adapter=new OdejdaAdapter();
        binding.recyclerView.setAdapter(adapter);
        appData.db.odejdaDAO().getAll().observe(this, new Observer<List<Odejda>>() {
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
        public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

            final Odejda odejda=meodejda.get(position);
            holder.itemProductBinding.naming.setText(odejda.Title);
            holder.itemProductBinding.saletext.setText(odejda.Price);
            appData.loadImage(odejda.Picture,holder.itemProductBinding.imageprod);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent MainProduct = new Intent(MainActivity.this, MainProduct.class);
                    MainProduct.putExtra(AppData.ID,odejda.OdejID);
                    ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,holder.itemProductBinding.imageprod,"trans");
                     startActivity(MainProduct,options.toBundle());
                }
            });
        }

        @Override
        public int getItemCount() {
            return meodejda.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ItemProductBinding itemProductBinding;
           public ViewHolder(ItemProductBinding itemView){
               super(itemView.getRoot());
               this.itemProductBinding=itemView;

           }
        }
    }
}