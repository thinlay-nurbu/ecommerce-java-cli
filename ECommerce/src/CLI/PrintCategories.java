package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public class PrintCategories implements Actionable{
    private Category category;


    @Override
    public String getLabel() {
        return "Print Categories";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(dataManager.getCategories().isEmpty()){
            System.out.println("No categories available");
            return;
        }

        System.out.println("---------Categories---------");
        for(int i=0; i<dataManager.getCategories().size(); i++){
            System.out.println((i+1)+". "+dataManager.getCategories().get(i).getName());
        }
        int index;
        do{
            System.out.print("Select category: ");
            index = Input.readInt(scanner)-1;
        } while(index<0 || index>=dataManager.getCategories().size());
        this.category = dataManager.getCategories().get(index);
    }

    public Category getCategory(){
        return this.category;
    }
}
