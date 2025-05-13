package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

import java.util.Random;
import java.util.Scanner;

public class AddCategory  implements Actionable{

    @Override
    public String getLabel() {
        return "Add new Category";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        int ID = IDGenerator.generateID(dataManager, "category");
        System.out.print("Enter category name: ");
        String name = scanner.nextLine();
        System.out.print("Enter category description: ");
        String description = scanner.nextLine();


        Category newCategory = new Category();
        newCategory.setID(ID);
        newCategory.setName(name);
        newCategory.setDescription(description);
        dataManager.getCategories().add(newCategory);
    }
}
