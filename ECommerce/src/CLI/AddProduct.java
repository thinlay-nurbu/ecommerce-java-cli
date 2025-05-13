package CLI;

import ECommerce.*;

import java.util.Scanner;

public class AddProduct implements Actionable{
    private Category category;

    public AddProduct(Category category){
        this.category = category;
    }

    @Override
    public String getLabel() {
        return "Add New Product";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Seller)){
            System.out.println("Only sellers can add new products");
            return;
        }

        System.out.print("Enter product name: ");
        String name = Input.readStringLine(scanner);
        System.out.print("Enter product description: ");
        String description = Input.readStringLine(scanner);
        System.out.print("Enter product price (double): ");
        double price = Input.readDouble(scanner);
        System.out.print("Enter product stock quantity (int): ");
        int stockQuantity = Input.readInt(scanner);

        Product newProduct = new Product();
        newProduct.setID(IDGenerator.generateID(dataManager, "product"));
        newProduct.setName(name);
        newProduct.setDescription(description);
        newProduct.setPrice(price);
        newProduct.setStockQuantity(stockQuantity);
        newProduct.setCategory(this.category);
        newProduct.setSeller((Seller) user);

        dataManager.getProducts().add(newProduct);
        this.category.getProducts().add(newProduct);
        System.out.println("Product is added successfully :)");
    }
}
