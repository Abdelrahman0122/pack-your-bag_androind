package com.example.project.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;

public class CheckListAdapter extends  RecyclerView.Adapter<CheckListViewHolder>{
    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}


class CheckListViewHolder extends RecyclerView.ViewHolder{

    LinearLayout layout;
    CheckBox checkBox;
    Button btnDelete;

    public CheckListViewHolder(@NonNull View itemView){

        super(itemView);
        layout = itemView.findViewById(R.id.linerLayout);
        checkBox = itemView.findViewById(R.id.checkbox);
        btnDelete =itemView.findViewById(R.id.btnDelete);



    }





}