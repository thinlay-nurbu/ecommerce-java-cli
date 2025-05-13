package ECommerce;

public class Product {
    private int ID;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private Category category;
    private Seller seller;

    public Product(){

    }

    public Product(int ID, String name, String description, double price,
                   int stockQuantity, Category category, Seller seller){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.seller = seller;
    }


    //getter and setters
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

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getStockQuantity(){
        return this.stockQuantity;
    }

    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }

    public boolean isInStock(){
        return this.stockQuantity>0;
    }

    public Category getCategory(){
        return this.category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public Seller getSeller(){
        return this.seller;
    }

    public void setSeller(Seller seller){
        this.seller = seller;
    }

}
