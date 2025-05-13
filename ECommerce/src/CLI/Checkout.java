package CLI;

import ECommerce.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkout implements Actionable{

    @Override
    public String getLabel() {
        return "Checkout";
    }

    @Override
    public void execute(Scanner scanner, User user, DataManager dataManager) {
        if(!(user instanceof Client)){
            System.out.println("Only client can checkout");
            return;
        }

        Cart cart = ((Client) user).getCart();
        if(cart.getProducts().isEmpty()){
            System.out.println("Cart is empty");
            return;
        }

        System.out.println("-------Cart Products-------");
        for(int i=0; i<cart.getProducts().size(); i++){
            System.out.printf("%d. %s%n", (i + 1), cart.getProducts().get(i).getName());
            System.out.printf("%-3s%-10s %d%n%n", "", "Quantity:",
                    cart.getProducts().get(i).getQuantity());
            System.out.println("---------------------------");
        }

        System.out.print("Do you want to remove any product from the cart? (Y/N): ");
        String input = Input.readString(scanner).toUpperCase();
        if(input.equals("Y")){
            System.out.print("Select product: ");
            int choice;
            do{
                choice = Input.readInt(scanner);
            } while(choice<=0 || choice>cart.getProducts().size());

            CartProduct p = cart.getProducts().get(choice-1);
            cart.getProducts().remove(p);
            System.out.println(p.getName() + " is removed successfully");
        }

        System.out.println("Total amount:  "+cart.calculateTotal());
        String paymentMethod = ((Client) user).getPaymentMethod();
        System.out.println("Payment method:  "+paymentMethod);
        System.out.print("Do you want to change the payment method? (Y/N): ");
        input = Input.readString(scanner);
        if(input.equals("Y")){
            System.out.print("Enter payment method: ");
            String newPaymentMethod = Input.readStringLine(scanner);
            ((Client) user).setPaymentMethod(newPaymentMethod);
            System.out.println("Payment method is updated successfully");
        }

        String address = ((Client) user).getAddress();
        System.out.println("Address:  "+address);
        System.out.print("Do you want to change the address? (Y/N): ");
        input = Input.readString(scanner).toUpperCase();
        if(input.equals("Y")){
            System.out.print("Enter address: ");
            String newAddress = Input.readStringLine(scanner);
            ((Client) user).setAddress(newAddress);
            System.out.println("Address is updated successfully");
        }

        int ID = IDGenerator.generateID(dataManager, "order");
        Client client = (Client) user;
        ArrayList<Seller> sellers = new ArrayList<>();
        for(CartProduct cp : cart.getProducts()){
            sellers.add(cp.getSeller());
        }
        Order order = new Order(ID, client, sellers, cart);
        dataManager.getOrders().add(order);
        ((Client) user).getPreviousOrders().add(order);
        for(Seller seller : order.getSellers()){
            seller.getOrders().add(order);
        }

        cart.reset();

        System.out.println("Order placed successfully :)");
    }
}
