package CLI;

import ECommerce.DataManager;

import java.util.Random;

public class IDGenerator {

    public static int generateID(DataManager dataManager, String type){
        int start;
        int bound;
        switch(type.toLowerCase()){
            case "category":
                start = 500;
                bound = 1000;
                break;
            case "product":
                start = 2000;
                bound = 3000;
                break;
            case "user":
                start = 1000;
                bound = 2000;
                break;
            default:
                start = 100000;
                bound = 200000;
                break;
        }

        Random random = new Random();
        int ID;
        do{
            ID = random.nextInt(start, bound);
        } while(!isUniqueID(dataManager, ID, type));
        return ID;
    }

    private static boolean isUniqueID(DataManager dataManager, int ID, String type){
        switch(type.toLowerCase()){
            case "category":
                return dataManager.getCategories().stream().noneMatch(c -> c.getID() == ID);
            case "product":
                return dataManager.getProducts().stream().noneMatch(p -> p.getID() == ID);
            case "user":
                return dataManager.getUsers().stream().noneMatch(u -> u.getID() == ID);
            case "order":
                return dataManager.getOrders().stream().noneMatch(o -> o.getID() == ID);
            default:
                return true;
        }
    }
}
