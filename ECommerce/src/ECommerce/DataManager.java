package ECommerce;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<User> users;
    private ArrayList<Category> categories;
    private ArrayList<Product> products;
    private ArrayList<Order> orders;

    public DataManager(ArrayList<User> users, ArrayList<Category> categories,
                       ArrayList<Product> products, ArrayList<Order> orders){
        this.users = users;
        this.categories = categories;
        this.products = products;
        this.orders = orders;
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    public ArrayList<Category> getCategories(){
        return this.categories;
    }

    public ArrayList<Product> getProducts(){
        return this.products;
    }

    public ArrayList<Order> getOrders(){
        return this.orders;
    }
}
