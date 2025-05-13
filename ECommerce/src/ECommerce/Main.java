package ECommerce;

import CLI.AddProduct;
import CLI.NavigationHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Category> categories = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();

        DataManager dataManager = new DataManager(users, categories, products, orders);
        NavigationHandler navigationHandler = new NavigationHandler(dataManager);
        navigationHandler.welcome();
        navigationHandler.init();
    }
}
