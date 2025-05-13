package CLI;

import ECommerce.*;

import java.util.Scanner;

public class UpdateItemStatus implements Actionable{
    private CartProduct cp;

    public UpdateItemStatus(CartProduct cp){
        this.cp = cp;
    }

    @Override
    public String getLabel() {
        return "Change Item Status";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Seller)){
            System.out.println("Error occrred :(");
            return;
        }

        System.out.println("------Product-------");
        System.out.printf("%-20s%s%n", "Name:", cp.getName());
        System.out.printf("%-20s%s%n", "Description:", cp.getDescription());
        System.out.printf("%-20s%d%n", "Quantity:", cp.getQuantity());
        System.out.printf("%-20s%s%n", "Status:", cp.getItemStatus());
        System.out.println("-----------------------");

        int statusIndex;
        do{
            System.out.println("1. PENDING");
            System.out.println("2. SHIPPED");
            System.out.println("3. DELIVERED");
            System.out.println("4. CANCELED");
            statusIndex = Input.readInt(scanner);
        } while(statusIndex<=0 || statusIndex>4);

        OrderStatus status;
        switch(statusIndex){
            case 1:
                status = OrderStatus.PENDING;
                break;
            case 2:
                status = OrderStatus.SHIPPED;
                break;
            case 3:
                status = OrderStatus.DELIVERED;
                break;
            case 4:
                status = OrderStatus.CANCELED;
                break;
            default:
                status = cp.getItemStatus();
                break;
        }

        cp.setItemStatus(status);
        System.out.println("Item status updated sucessfully :)");
    }
}
