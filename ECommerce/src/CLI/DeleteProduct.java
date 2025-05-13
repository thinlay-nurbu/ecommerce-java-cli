package CLI;

import ECommerce.DataManager;
import ECommerce.Product;
import ECommerce.Seller;
import ECommerce.User;

import java.util.Scanner;

public class DeleteProduct implements Actionable{
    private Product product;

    public DeleteProduct(Product product){
        this.product = product;
    }

    @Override
    public String getLabel() {
        return "Delete Product";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(this.product == null){
            System.out.println("Product is unavailable");
            return;
        }

        if(!(user instanceof Seller)){
            System.out.println("Only seller can delete a product");
            return;
        }

        if(this.product.getSeller().getID() != user.getID()){
            System.out.println("Can't delete this product");
            return;
        }

        System.out.println("Are you sure that you want to delete this product? (Y/N): ");
        String input = Input.readString(scanner).toUpperCase();
        if(input.equals("Y")){
            this.product.getCategory().getProducts().remove(this.product);
            dataManager.getProducts().remove(this.product);
            System.out.println("Product is deleted sucessfully");
        } else {
            System.out.println("Operation is cancelled");
        }
    }
}
