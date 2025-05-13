package CLI;

import ECommerce.DataManager;
import ECommerce.Product;
import ECommerce.User;

import java.util.Scanner;

public class ShowProductDetails implements Actionable{
    private Product product;

    public ShowProductDetails(Product product){
        this.product = product;
    }

    @Override
    public String getLabel() {
        return "Show Product Details";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(product == null){
            System.out.println("Product is not available");
            return;
        }

        System.out.println("================================");
        System.out.println("Here is the product details: ");
        System.out.printf("%-20s %s%n", "ID:", this.product.getID());
        System.out.printf("%-20s %s%n", "Name:", this.product.getName());
        System.out.printf("%-20s %s%n", "Description:", this.product.getDescription());
        System.out.printf("%-20s %s%n", "Price:", this.product.getPrice());
        System.out.printf("%-20s %s%n", "Stock Quantity:", this.product.getStockQuantity());
        System.out.printf("%-20s %s%n", "Category:", this.product.getCategory().getName());
        System.out.printf("%-20s %s%n", "Seller:", this.product.getSeller().getFullName());
        System.out.println("================================");
    }
}
