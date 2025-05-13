package ECommerce;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartProduct> products;

    public Cart(){
        this.products = new ArrayList<>();
    }

    public Cart(ArrayList<CartProduct> products){
        this.products = products;
    }

    public ArrayList<CartProduct> getProducts(){
        return this.products;
    }

    public void setProducts(ArrayList<CartProduct> products){
        this.products = products;
    }

    //calculateTotal method yet to be written
    public double calculateTotal(){
        return products.stream()
                .mapToDouble(cp -> cp.getPrice()*cp.getQuantity())
                .sum();
    }

    public void reset(){
        this.products = new ArrayList<>();
    }
}
