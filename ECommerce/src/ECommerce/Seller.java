package ECommerce;

import CLI.AddCategory;
import CLI.AddProduct;

import CLI.Explore;
import CLI.ShowUserOrders;

import java.util.ArrayList;

public class Seller extends User{
    private int soldItemCount;
    private double profit;
    private String firstName;
    private String lastName;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;
    public Seller(){
        this.products = new ArrayList<>();
        this.orders = new ArrayList<>();
        actions = new ArrayList<>();
        actions.add(new Explore());
        actions.add(new AddCategory());
        actions.add(new ShowUserOrders());
    }

    public Seller(int soldItemCount, double profit, String firstName,
                  String lastName, ArrayList<Product> products, ArrayList<Order> orders){
        this.soldItemCount = soldItemCount;
        this.profit = profit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = products;
        this.orders = orders;
    }

    //getters and setters
    public int getSoldItemCount(){
        return this.soldItemCount;
    }

    public void setSoldItemCount(int soldItemCount){
        this.soldItemCount = soldItemCount;
    }

    public double getProfit(){
        return this.profit;
    }

    public void setProfit(double profit){
        this.profit = profit;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public String getFullName(){
        return this.firstName+" "+this.lastName;
    }
    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }

    public void setOrders(ArrayList<Order> orders){
        this.orders = orders;
    }
}
