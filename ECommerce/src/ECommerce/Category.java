package ECommerce;

import java.util.ArrayList;

public class Category {
    private int ID;
    private String name;
    private String description;
    private ArrayList<Product> products;

    public Category(){
        this.products = new ArrayList<>();
    }

    public Category(int ID, String name, String description, ArrayList<Product> products){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    //getters and setters
    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

}
