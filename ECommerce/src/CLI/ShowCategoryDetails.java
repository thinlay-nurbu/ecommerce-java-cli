package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public class ShowCategoryDetails implements Actionable{
    Category category;

    public ShowCategoryDetails(Category category){
        this.category = category;
    }

    @Override
    public String getLabel() {
        return "Show Category Details";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        System.out.println("================================");
        System.out.println("Here is the Category details: ");
        System.out.printf("%-20s %s%n", "ID:", this.category.getID());
        System.out.printf("%-20s %s%n", "Name:", this.category.getName());
        System.out.printf("%-20s %s%n", "Description:", this.category.getDescription());
        System.out.printf("%-20s %s%n", "Number of Products:", this.category.getProducts().size());
        System.out.println("================================");
    }
}
