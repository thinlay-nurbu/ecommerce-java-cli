package ECommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private int ID;
    private Client client;
    private ArrayList<Seller> seller;
    private LocalDateTime orderTime;
    private ArrayList<CartProduct> products;
    private double totalAmount;
    private String paymentMethod;

    public Order(){
        this.seller = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    public Order(int ID, Client client, ArrayList<Seller> seller, Cart cart){
        this.ID = ID;
        this.client = client;
        this.seller = seller;
        this.orderTime = LocalDateTime.now();
        this.products = cart.getProducts();
        this.totalAmount = cart.calculateTotal();
        this.paymentMethod = client.getPaymentMethod();
    }

    public Order(int ID, Client client, ArrayList<Seller> seller, LocalDateTime orderTime,
                 ArrayList<CartProduct> products, double totalAmount, String paymentMethod){
        this.ID = ID;
        this.client = client;
        this.seller = seller;
        this.orderTime = orderTime;
        this.products = products;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    //getters and setters
    public int getID(){
        return this.ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public ArrayList<Seller> getSellers(){
        return this.seller;
    }

    public void setSellers(ArrayList<Seller> seller){
        this.seller = seller;
    }

    public LocalDateTime getOrderTime(){
        return this.orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime){
        this.orderTime = orderTime;
    }

    public String getFormattedDateOrder(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.orderTime.format(formatter);
    }

    public String getFormattedTimeOrder(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return this.orderTime.format(formatter);
    }

    public ArrayList<CartProduct> getProducts(){
        return this.products;
    }

    public void setProducts(ArrayList<CartProduct> products){
        this.products = products;
    }

    public OrderStatus getOrderStatus(){
        OrderStatus status = OrderStatus.DELIVERED;
        int canceled = 0;
        for(CartProduct cp : products){
            if(cp.getItemStatus() == OrderStatus.SHIPPED && status != OrderStatus.PENDING)
                status = OrderStatus.SHIPPED;
            if(cp.getItemStatus() == OrderStatus.PENDING)
                status = OrderStatus.PENDING;
            if(cp.getItemStatus() == OrderStatus.CANCELED)
                canceled++;
        }

        if(canceled == products.size())
            return OrderStatus.CANCELED;
        return status;
    }

    public double getTotalAmount(){
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount){
        this.totalAmount = totalAmount;
    }

    public String getPaymentMethod(){
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    public void calculateTotalAmount(){
        this.totalAmount = this.products.stream()
                .mapToDouble(cp -> cp.getPrice()*cp.getQuantity())
                .sum();
    }

}
