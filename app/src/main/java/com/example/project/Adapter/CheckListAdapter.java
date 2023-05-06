package com.example.project.Adapter;

<<<<<<< HEAD
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
=======
>>>>>>> origin/master
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
<<<<<<< HEAD
import android.widget.Toast;
=======
>>>>>>> origin/master

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

<<<<<<< HEAD
import com.example.project.Constants.MyConstants;
import com.example.project.Database.RoomDB;
import com.example.project.Models.Items;
import com.example.project.R;

import java.util.List;

public class CheckListAdapter extends  RecyclerView.Adapter<CheckListViewHolder>{

    Context context;
    List<Items> itemsList;
    RoomDB database;

    //dah constructor

    public CheckListAdapter(Context context, List<Items> itemsList, RoomDB database, String show) {
        this.context = context;
        this.itemsList = itemsList;
        this.database = database;
        this.show = show;

        //make toast message to check when no item exist
        if(itemsList.size()==0){
            Toast.makeText(context,"nothing to show",Toast.LENGTH_LONG).show();
        }


    }

    String show;

    public CheckListAdapter() {

    }

    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckListViewHolder(LayoutInflater.from(context).inflate(R.layout.check_list_item,parent,false));
=======
import com.example.project.R;

public class CheckListAdapter extends  RecyclerView.Adapter<CheckListViewHolder>{
    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
>>>>>>> origin/master
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder holder, int position) {
<<<<<<< HEAD
//set the name by the position from objects
        holder.checkBox.setText(itemsList.get(position).getItemname());
        holder.checkBox.setChecked(itemsList.get(position).getChecked());

        //hide the button when all items selected
        if(MyConstants.FALSE_STRING.equals(show)){
            holder.btnDelete.setVisibility(View.GONE);
            holder.layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_one));

        }else{
            if(itemsList.get(position).getChecked()){
                holder.layout.setBackgroundColor(Color.parseColor("8e546f"));
            }else holder.layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_one));
        }
    }
//that's return how many rows we want
    @Override
    public int getItemCount() {
        return itemsList.size();
=======

    }

    @Override
    public int getItemCount() {
        return 0;
>>>>>>> origin/master
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