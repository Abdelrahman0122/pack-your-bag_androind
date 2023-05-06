package com.example.project.Data;

import android.app.Application;
import android.content.Context;

import com.example.project.Constants.MyConstants;
import com.example.project.Database.RoomDB;
import com.example.project.Models.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {
    RoomDB database;
    String category;
    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 1;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;
        this.context = context;
    }
    public List<Items> getBasicData(){
        category = "Basic Needs";
        List<Items> basicItem = new ArrayList<>();
        basicItem.add(new Items("Visa",category,false));
        basicItem.add(new Items("Passport",category,false));
        basicItem.add(new Items("Tickets",category,false));
        basicItem.add(new Items("Wallet",category,false));
        basicItem.add(new Items("Driving License",category,false));
        basicItem.add(new Items("Currency",category,false));
        basicItem.add(new Items("House Key",category,false));
        basicItem.add(new Items("Book",category,false));
        basicItem.add(new Items("Travel pillow",category,false));
        basicItem.add(new Items("Eye Patch",category,false));
        basicItem.add(new Items("Umbrella",category,false));
        basicItem.add(new Items("Note Book",category,false));

        return basicItem;
    }

    public List<Items> getPersonalCareData() {
        String[] data = {"Tooth-brush", "Tooth-paste", "Floss" , "Mouthwash","Shaving Cream","Razor Blade","soap","fiber"};
        return prepareItemsList(MyConstants.PERSONAL_CARE_CAMEL_CASE,data);
    }
    public List<Items> getClothingData() {
        String[] data = {"Stockings", "Underwear", "pajamas" , "T-Shirts","Evening Dress","Shirt","Cardigan","Vest"};

        return prepareItemsList(MyConstants.CLOTHING_CAMEL_CASE,data);
    }

    public List<Items> getBabyNeedsData() {
        String[] data = {"Snap suit", "Outfit", "Jumpsuit" , "Baby Socks","Baby Ha","Baby pyjamas","Baby Bath Towel"};

        return prepareItemsList(MyConstants.BABY_NEEDS_CAMEL_CASE,data);
    }
    public List<Items> getFoodData() {
        String[] data = {"Snack", "Sandwich", "Juice" , "Tea Bags","coffe","Water"};

        return prepareItemsList(MyConstants.FOOD_CAMEL_CASE,data);
    }
    public List<Items> getHealthData() {
        String[] data = {"Aspirin", "Drugs Used", "Vitamins Used" , "Lens Solution"};

        return prepareItemsList(MyConstants.HEALTH_CAMEL_CASE,data);
    }
    public List<Items> getBeachSuppliesData() {
        String[] data = {"Sea Glasses", "Sea Bed", "Suntan" , "Beach Umbrella"};

        return prepareItemsList(MyConstants.BEACH_SUPPLIES_CAMEL_CASE,data);
    }
    public List<Items> getTechnologyData() {
        String[] data = {"Mobile Phone", "Phone Cover", "E-book Reader" , "Camera"};

        return prepareItemsList(MyConstants.TECHNOLOGY_CAMEL_CASE,data);
    }
    public List<Items> getCarSuppliesData() {
        String[] data = {"Pump", "Car Jack", "Spare Car Key" , "Car Charger"};

        return prepareItemsList(MyConstants.CAR_SUPPLIES_CAMEL_CASE,data);
    }
    public List<Items> getNeedsData() {
        String[] data = {"Backpack", "Daily Bags", "Laundry Bag" , "Sewing Kit"};

        return prepareItemsList(MyConstants.NEEDS_CAMEL_CASE,data);
    }

    public List<Items> prepareItemsList(String category,String []data){
        List<String> list = Arrays.asList(data);
        List<Items> dataList = new ArrayList<>();
        dataList.clear();

        for (int i=0;i<list.size(); i++){
            dataList.add(new Items(list.get(i),category,false ));
        }
        return dataList;
    }
    public List<List<Items>> getAllData(){
        List<List<Items>> listOfAllItems = new ArrayList<>();
        listOfAllItems.clear();
        listOfAllItems.add(getBasicData());
        listOfAllItems.add(getClothingData());
        listOfAllItems.add(getPersonalCareData());
        listOfAllItems.add(getBabyNeedsData());
        listOfAllItems.add(getHealthData());
        listOfAllItems.add(getTechnologyData());
        listOfAllItems.add(getFoodData());
        listOfAllItems.add(getBeachSuppliesData());
        listOfAllItems.add(getCarSuppliesData());
        listOfAllItems.add(getNeedsData());
        return listOfAllItems;
    }
    public void persistAllData(){
        List<List<Items>> listOfAllItems = getAllData();
        for(List<Items> list: listOfAllItems){
            for(Items items:list){
                database.mainDao().saveItem(items);


            }



        }
            System.out.println("Data added.");

    }

}
