package CLI;

import ECommerce.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CancelOrder implements Actionable{
    private Order order;

    public CancelOrder(Order order){
        this.order = order;
    }

    @Override
    public String getLabel() {
        return "Cancel Order";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Client)){
            System.out.println("Error occurred :(");
            return;
        }

        if(order == null){
            System.out.println("Order is unavailable");
            return;
        }

        if(order.getOrderStatus() != OrderStatus.PENDING){
            System.out.println("Order can't be cancelled or already cancelled :(");
            return;
        }

        for(CartProduct cp : order.getProducts()){
            cp.setItemStatus(OrderStatus.CANCELED);
        }

        System.out.println("Order canceled successfully");
    }
}
