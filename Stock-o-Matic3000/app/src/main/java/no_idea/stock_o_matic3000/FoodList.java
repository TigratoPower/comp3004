package no_idea.stock_o_matic3000;

import java.lang.reflect.Array;
import java.util.*;

public class FoodList{
    private int size; //number of items in the list
    private ArrayList<FoodItem> foodItems;
 
    public FoodList(){
        foodItems = new ArrayList<FoodItem>();
        size = 0;
    }
 
    //constructor using previous food list
    public FoodList(ArrayList<FoodItem> foodItems){
        this.foodItems = foodItems;
        size = this.foodItems.size();
    }
 
    //gets item using a number
    public FoodItem getItem(int itemNum){
        return foodItems.get(itemNum);
    }
 
    //gets the whole list of food items
    public ArrayList<FoodItem> getItems(){
        return foodItems;
    }

    //set entire list of items
    public void setItems(ArrayList<FoodItem> foodItems){
        this.foodItems = foodItems;
        this.size = foodItems.size();
    }
 
    //adds an item
    public void addItem(FoodItem item){
        foodItems.add(item);
        //possibly pass comparator
        //Collections.sort(foodItems, FoodItem.name);
        setSize();
    }
    //removes by item
    public void removeItem(FoodItem item){
        foodItems.remove(item);
        setSize();
    }

    public boolean contains(FoodItem item) { return foodItems.contains(item); }

    //removes by position in the list
    public void removeItem(int index){
        foodItems.remove(index);
        setSize();
    }
    public int getSize(){
        return size;
    }

    private void setSize(){
        size = foodItems.size();
    }

    public String[] toStringArray(){
        ArrayList<String> toss = new ArrayList<>();
        String toStr[] = new String[1];
        if(size == 0){
            return new String[]{"Add Item"};
        }
        else{
            int counter = 1;
            toss.add("Add Item");
            for(FoodItem item : foodItems){
                toss.add(item.getName() + "\n" + "Quantity: " + item.getQuantity() +
                         " Date: " + item.getDate() + '\n');
                counter++;
            }
        }
       toStr = toss.toArray(toStr);
        return toStr;
    }
}