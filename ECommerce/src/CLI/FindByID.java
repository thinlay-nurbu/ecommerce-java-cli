package CLI;

import ECommerce.Category;
import ECommerce.DataManager;
import ECommerce.Order;

public class FindByID {

    public static Order getOrder(int ID, DataManager dataManager){
        Order order = null;
        for(Order o : dataManager.getOrders()){
            if(o.getID() == ID){
                order = o;
                break;
            }
        }
        return order;
    }
}
