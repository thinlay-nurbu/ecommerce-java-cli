package ECommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CartProduct extends Product {
    private int quantity;
    private LocalDateTime timeAdded;
    private OrderStatus itemStatus;

    public CartProduct(Product p, int qty){
        super(p.getID()/2, p.getName(), p.getDescription(), p.getPrice(),
            p.getStockQuantity(), p.getCategory(), p.getSeller());
        this.quantity = qty;
        this.itemStatus = OrderStatus.PENDING;
        this.timeAdded = LocalDateTime.now();
    }

    public CartProduct(int quantity, LocalDateTime timeAdded, OrderStatus itemStatus){
        this.quantity = quantity;
        this.timeAdded = timeAdded;
        this.itemStatus = itemStatus;
    }

    //getters and setters
    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public LocalDateTime getTimeAdded(){
        return this.timeAdded;
    }

    public void setTimeAdded(LocalDateTime timeAdded){
        this.timeAdded = timeAdded;
    }

    public String getFormattedDateAdded(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return this.timeAdded.format(formatter);
    }

    public String getFormattedTimeAdded(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        return this.timeAdded.format(formatter);
    }

    public boolean canAddToCart(){
        return super.getStockQuantity()>=this.getQuantity();
    }

    public OrderStatus getItemStatus(){
        return this.itemStatus;
    }

    public void setItemStatus(OrderStatus itemStatus){
        this.itemStatus = itemStatus;
    }

}
