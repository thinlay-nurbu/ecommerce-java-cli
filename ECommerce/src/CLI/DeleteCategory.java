package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public class DeleteCategory implements Actionable{
    private Category category;

    public DeleteCategory(Category category){
        this.category = category;
    }
    @Override
    public String getLabel() {
        return "Delete Category";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(category == null){
            System.out.println("Category unavailable");
            return;
        }

        System.out.println("Are you sure that you want to delete this category with all its products? (Y/N): ");
        String input = scanner.next().toUpperCase();
        scanner.nextLine();
        if(input.equals("Y")){
            dataManager.getProducts().removeAll(this.category.getProducts());
            dataManager.getCategories().remove(this.category);
            System.out.println("Category sucessfully deleted");
        }
        else{
            System.out.println("Operation cancelled");
        }
    }
}
