package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.project.Adapter.CheckListAdapter;
import com.example.project.Constants.MyConstants;
import com.example.project.Database.RoomDB;
import com.example.project.Models.Items;

import java.util.ArrayList;
import java.util.List;

public class CheckList extends AppCompatActivity {



    RecyclerView recyclerView;
    CheckListAdapter checkListAdapter;
    RoomDB database ;
    List<Items> itemsList = new ArrayList<>();
    String header , show ;

    EditText editText;
    Button btnAdd ;
    LinearLayout linearLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);


        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        header = intent.getStringExtra(MyConstants.HEADER_SMALL);
        show = intent.getStringExtra(MyConstants.SHOW_SMALL);

        getSupportActionBar().setTitle(header);

//        editText.findViewById(R.id.txtAdd);

        recyclerView = findViewById(R.id.recyclerView);


        database = RoomDB.getInstance(this);
        if (MyConstants.FALSE_STRING.equals(show)){
       //     linearLayout.setVisibility(View.GONE);
            itemsList = database.mainDao().getAllSelected(true);

        }else {
            itemsList = database.mainDao().getAll(header);
        }

        updateRecycle(itemsList);

    }



private void addedNewItem(String itemName){

        Items item = new Items();
    item.setChecked(false);
    item.setCategory(header);
    item.setItemname(itemName);
    item.setAddedby(MyConstants.USER_SMALL);
    database.mainDao().saveItem(item);
    updateRecycle(itemsList);
    recyclerView.scrollToPosition(checkListAdapter.getItemCount()-1);
    editText.setText("");


}
     private void updateRecycle(List<Items>itemList){
      recyclerView.setHasFixedSize(true);
      recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1 , LinearLayoutManager.VERTICAL));
      checkListAdapter = new CheckListAdapter(CheckList.this , itemList, database , show);
      recyclerView.setAdapter(checkListAdapter);
     }


}