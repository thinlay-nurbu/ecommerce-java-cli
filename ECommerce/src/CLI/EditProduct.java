package CLI;


import ECommerce.*;

import java.util.Scanner;

public class EditProduct implements Actionable{
    private Product product;

    public EditProduct(Product product){
        this.product = product;
    }

    @Override
    public String getLabel() {
        return "Edit Product";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Seller)){
            System.out.println("Only Seller can edit the product");
            return;
        }

        System.out.print("Enter product name (-1 to keep "+product.getName()+"): ");
        String name = Input.readStringLine(scanner);
        System.out.print("Enter product description (-1 to keep "+product.getDescription()+"): ");
        String description = Input.readStringLine(scanner);
        System.out.print("Enter product price (double) (-1 to keep "+product.getPrice()+"): ");
        double price = Input.readDouble(scanner);
        System.out.print("Enter product stock quantity (int) (-1 to keep "+product.getStockQuantity()+"): ");
        int stockQuantity = Input.readInt(scanner);

        if(!name.equals("-1")) this.product.setName(name);
        if(!description.equals("-1")) this.product.setDescription(description);
        if(price != -1) this.product.setPrice(price);
        if(stockQuantity != -1) this.product.setStockQuantity(stockQuantity);

        System.out.print("You want to change the product category? (Y/N): ");
        String input = Input.readString(scanner).toUpperCase();
        if(input.equals("Y")){
            PrintCategories printCategories = new PrintCategories();
            printCategories.execute(scanner, user, dataManager);
            Category category = printCategories.getCategory();
            category.getProducts().add(this.product);
            this.product.getCategory().getProducts().remove(this.product);
            this.product.setCategory(category);
        }

        System.out.println("Product edited sucessfully");

    }
}
