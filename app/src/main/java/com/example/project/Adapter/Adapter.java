package com.example.project.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder>{
    List<String> titles;
    List<Integer> imagas;
    LayoutInflater inflater;
    Activity activity;

    // dol el constructor
    public Adapter(Context context,List<String> titles, List<Integer> imagas, Activity activity) {
        this.titles = titles;
        this.imagas = imagas;
        this.activity = activity;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.img.setImageResource(imagas.get(position));
        holder.linearLayout.setAlpha(0.8f);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //da betl3 el toast message after we click
                Toast.makeText(activity, "Clicked on card.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    //be3raf e7n 3ndena kam item fe el app
    public int getItemCount() {
        return titles.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView img;
        LinearLayout linearLayout;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.img);
            linearLayout = itemView.findViewById(R.id.linerLayout);

        }
    }
}
