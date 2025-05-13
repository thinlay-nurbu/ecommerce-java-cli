package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.Seller;
import ECommerce.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Explore implements Actionable{


    @Override
    public String getLabel() {
        return "Explore";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        PrintCategories printCategory = new PrintCategories();
        printCategory.execute(scanner, user, dataManager);

        Category category = printCategory.getCategory();
        if(category == null) return;
        System.out.println("Category ----> " + category.getName());
        int choice;
        do{
            System.out.println("1. show details");
            System.out.println("2. show products");
            if(user instanceof Seller){
                System.out.println("3. Edit category");
                System.out.println("4. Delete category");
                System.out.println("5. Add new product");
            }
            System.out.println("0. Back");
            System.out.print("Select any one by inserting its serial number: ");
            choice = Input.readInt(scanner);
        } while(choice<0 || choice>5);

        if(choice == 0){
            return;
        }

        choice--;
        ArrayList<Actionable> actions = new ArrayList<>();
        actions.add(new ShowCategoryDetails(category));
        actions.add(new ShowCategoryProducts(category));
        actions.add(new EditCategory(category));
        actions.add(new DeleteCategory(category));
        actions.add(new AddProduct(category));

        actions.get(choice).execute(scanner, user, dataManager);
    }
}
