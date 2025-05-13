package CLI;

import ECommerce.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowUserOrders implements Actionable{
    @Override
    public String getLabel() {
        return "Show Orders";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        ArrayList<Order> orders;
        if(user instanceof Client){
            orders = ((Client) user).getPreviousOrders();
        } else if(user instanceof Seller){
            orders = ((Seller) user).getOrders();
        } else{
            orders = new ArrayList<Order>();
        }

        if(orders.isEmpty()){
            System.out.println("You have no order :(");
            return;
        }

        System.out.println("------Here are the orders--------");
        for(Order order : orders){
            System.out.printf("%-20s%-5d%n", "ID:", order.getID());
            System.out.printf("%-20s%-5s%n", "Order Date:", order.getFormattedDateOrder());
            System.out.printf("%-20s%-5s%n", "Order Time:", order.getFormattedTimeOrder());
            System.out.printf("%-20s%-5d%n", "Number of Products:", order.getProducts().size());
            System.out.printf("%-20s%-5f%n", "Total:", order.getTotalAmount());
            System.out.printf("%-20s%-5s%n", "Order Status:", order.getOrderStatus());
            System.out.println("---------------------------------");
        }

        if(orders.isEmpty()) return;

        System.out.print("Do you want to see order items? (Y/N): ");
        String input = Input.readString(scanner).toUpperCase();
        if(input.equals("N"))
            return;

        System.out.print("Enter order ID: ");
        int ID = Input.readInt(scanner);
        Order order = FindByID.getOrder(ID, dataManager);;
        while(order == null){
            System.out.println("Invalid order ID :(");
            System.out.print("Enter correct order ID: ");
            ID = Input.readInt(scanner);
            order = FindByID.getOrder(ID, dataManager);
        }

        if(order.getProducts().isEmpty()){
            System.out.println("Empty order :(");
            return;
        }
        System.out.println("---Items in "+order.getID()+" ---");
        for(int i=0; i<order.getProducts().size(); i++){
            CartProduct cp = order.getProducts().get(i);
            System.out.printf("%d. %s%n", (i+1), cp.getName());
            System.out.printf("   %s     %f%n", "Price:", cp.getPrice());
            System.out.printf("   %s  %d%n", "Quantity:", cp.getQuantity());
            System.out.println("------------------------");
        }

        if(user instanceof Seller){
            System.out.println("Do you want to change the status of any product? (Y/N): ");
            if(Input.readString(scanner).toUpperCase().equals("N"))
                return;

            System.out.print("Enter item index: ");
            int index = Input.readInt(scanner);
            while(index<=0 || index>order.getProducts().size()){
                System.out.println("Invalid index :(");
                System.out.print("Enter correct item index: ");
                index = Input.readInt(scanner);
            }
            CartProduct cp = order.getProducts().get(index-1);
            new UpdateItemStatus(cp).execute(scanner, user, dataManager);
        }

        if(user instanceof Client){
            System.out.println("Do you want to cancel the order? (Y/N): ");
            String choice = Input.readString(scanner).toUpperCase();
            if(choice.equals("N"))
                return;

            new CancelOrder(order).execute(scanner, user, dataManager);
        }

    }
}
