package CLI;

import ECommerce.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowCategoryProducts implements Actionable{
    private Category category;

    public ShowCategoryProducts(Category category){
        this.category = category;
    }

    @Override
    public String getLabel() {
        return "Show Category Products";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(category.getProducts().isEmpty()){
            System.out.println("No products available :(");
            return;
        }

        ArrayList<Product> products = this.category.getProducts();
        System.out.println("We have "+products.size()+" products in this category:");
        for(int i=0; i<products.size(); i++){
            System.out.println((i+1)+". "+products.get(i).getName());
        }

        System.out.print("Select product: ");
        int index = Input.readInt(scanner);
        while(index<=0 || index>products.size()){
            System.out.println("Invalid input! Try again: ");
            index = Input.readInt(scanner);
        }

        Product product = products.get(index-1);
        System.out.println("Product: "+product.getName());

        ArrayList<Actionable> actions = new ArrayList<Actionable>();
        actions.add(new ShowProductDetails(product));
        int choice;
        int limit;
        do{
            System.out.println("1. show details");
            if(user instanceof Seller){
                System.out.println("2. Edit product");
                System.out.println("3. Delete product");
                actions.add(new EditProduct(product));
                actions.add(new DeleteProduct(product));
                limit = 3;
            } else {
                System.out.println("2. Add to cart");
                actions.add(new AddToCart(product));
                limit = 2;
            }
            System.out.println("0. Back");
            System.out.print("Select: ");
            choice = Input.readInt(scanner);
        } while(limit<=0 || limit>3);

        if(choice == 0){
            return;
        }
        choice--;
        actions.get(choice).execute(scanner, user, dataManager);
    }
}
