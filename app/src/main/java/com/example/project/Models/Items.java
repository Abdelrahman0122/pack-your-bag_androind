package com.example.project.Models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName ="items")
public class Items implements Serializable {

    //Whenever we add an item it will generate's the ID
    @PrimaryKey(autoGenerate = true)
    int ID = 0;

    @ColumnInfo(name="itemname")
    String itemname;

    @ColumnInfo(name = "category")
    String category;


    @ColumnInfo(name = "addedby")
    String addedby;

    @ColumnInfo(name = "checked")
    Boolean checked=false;

    public Items() {
    }

    public Items(String itemname, String category, Boolean checked) {
        this.addedby="system";
        this.itemname = itemname;
        this.category = category;
        this.checked = checked;
    }

    public Items(String itemname, String category, String addedby, Boolean checked) {
        this.itemname = itemname;
        this.category = category;
        this.addedby = addedby;
        this.checked = checked;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
