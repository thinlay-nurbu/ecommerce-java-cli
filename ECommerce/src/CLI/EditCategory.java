package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public class EditCategory implements Actionable{
    private Category category;

    public EditCategory(Category category){
        this.category = category;
    }
    @Override
    public String getLabel() {
        return "Edit Category";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(category == null){
            System.out.println("Category not avialable");
            return;
        }

        System.out.print("Enter new category name (-1 to keep "+category.getName()+"): ");
        String newName = scanner.nextLine();
        System.out.print("Enter new category description (-1 to keep "+category.getDescription()+"): ");
        String newDescription = scanner.nextLine();

        if(!newName.equals("-1"))
            category.setName(newName);
        if(!newDescription.equals("-1"))
            category.setDescription(newDescription);
    }
}
