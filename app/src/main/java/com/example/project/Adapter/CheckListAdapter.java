package com.example.project.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Constants.MyConstants;
import com.example.project.Database.RoomDB;
import com.example.project.Models.Items;
import com.example.project.R;

import java.util.List;

public class CheckListAdapter extends  RecyclerView.Adapter<CheckListViewHolder> {
    Context context;
    List<Items> itemsList;
    RoomDB database;
    String show;

    //dah constructor
    public CheckListAdapter(Context context, List<Items> itemsList, RoomDB database, String show) {
        this.context = context;
        this.itemsList = itemsList;
        this.database = database;
        this.show = show;

        //make toast message to check when no item exist
        if (itemsList.size() == 0) {
            Toast.makeText(context, "nothing to show", Toast.LENGTH_LONG).show();
        }

    }



    public CheckListAdapter() {
    }

    @NonNull
    @Override
    public CheckListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CheckListViewHolder(LayoutInflater.from(context).inflate(R.layout.check_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListViewHolder holder, int position) {
//set the name by the position from objects
        holder.checkBox.setText(itemsList.get(position).getItemname());
        holder.checkBox.setChecked(itemsList.get(position).getChecked());

        //hide the button when all items selected
        if (MyConstants.FALSE_STRING.equals(show)) {
            holder.btnDelete.setVisibility(View.GONE);
            holder.layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_one));

        } else {
            if (itemsList.get(position).getChecked()) {
                holder.layout.setBackgroundColor(Color.parseColor("#8e546f"));
            } else{
                holder.layout.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.border_one));
        }}

      holder.checkBox.setOnClickListener(new View.OnClickListener(){

          @Override
          public void onClick(View view){
              Boolean check = holder.checkBox.isChecked();
              database.mainDao().checkUncheck(itemsList.get(position).getID(),check);

              if (MyConstants.FALSE_STRING.equals(show)) {
                            itemsList = database.mainDao().getAllSelected(true);
                            notifyDataSetChanged();



              }else {
                  itemsList.get(position).setChecked(check);
                  notifyDataSetChanged();
                  Toast tostMessage =  null ;
                  if (tostMessage!=null){
                      tostMessage.cancel();
                  }
                  if (itemsList.get(position).getChecked()){
                      tostMessage =Toast.makeText(context , "("+holder.checkBox.getText()+") packed ",Toast.LENGTH_SHORT );
                  }else {
                      tostMessage = Toast.makeText(context , "("+holder.checkBox.getText()+")unpacked ",Toast.LENGTH_SHORT );
                  }

                  tostMessage.show();
              }

          }
      } );


        holder.btnDelete.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view ){
                new AlertDialog.Builder(context)
                        .setTitle("delete(" + itemsList.get(position).getItemname()+")")
                        .setMessage("mota2aked ya zmely ??!")
                        .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                database.mainDao().delete(itemsList.get(position));
                                itemsList.remove(itemsList.get(position));
                                notifyDataSetChanged();
                                Toast.makeText(context , "Delleted" , Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                  Toast.makeText(context , "cancelled" , Toast.LENGTH_SHORT).show();
                            }
                        }).setIcon(R.drawable.baseline_delete_forever_24).show();
            }
        });


    }


    //that's return how many rows we want
    @Override
    public int getItemCount() {
        return itemsList.size();


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