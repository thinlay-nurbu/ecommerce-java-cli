package ECommerce;

import CLI.Checkout;
import CLI.Explore;
import CLI.ShowUserOrders;

import java.util.ArrayList;

public class Client extends User{
    private ArrayList<Order> previousOrders;
    private Cart cart;
    private String address;
    private String paymentMethod;

    public Client(){
        this.previousOrders = new ArrayList<>();
        actions = new ArrayList<>();
        this.cart = new Cart();
        actions.add(new Explore());
        actions.add(new Checkout());
        actions.add(new ShowUserOrders());
    }

    public Client(ArrayList<Order> previousOrders, Cart cart, String address, String paymentMethod){
        this.previousOrders = previousOrders;
        this.cart = cart;
        this.address = address;
        this.paymentMethod = paymentMethod;
    }

    //getters and setters
    public ArrayList<Order> getPreviousOrders(){
        return this.previousOrders;
    }

    public void setPreviousOrders(ArrayList<Order> previousOrders){
        this.previousOrders = previousOrders;
    }

    public Cart getCart(){
        return this.cart;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public String getAddress(){
        return this.address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
}
