package CLI;

import ECommerce.Client;
import ECommerce.DataManager;
import ECommerce.Seller;
import ECommerce.User;

import java.util.Random;
import java.util.Scanner;

public class SignUp {

    public SignUp(Scanner scanner, DataManager dataManager, NavigationHandler navigationHandler){
        int ID = IDGenerator.generateID(dataManager, "user");
        System.out.print("\nEnter first name: ");
        String firstName = scanner.next();
        System.out.print("\nEnter last name: ");
        String lastName = scanner.next();
        System.out.print("\nEnter email: ");
        String email = scanner.next();
        System.out.print("\nEnter password: ");
        String password = scanner.next();
        System.out.print("\nConfirm password: ");
        String confirmPassword = scanner.next();

        while(!password.equals(confirmPassword)){
            System.out.println("Password doesn't match");
            System.out.print("Enter password again: ");
            password = scanner.next();
            System.out.print("\nConfirm password: ");
            confirmPassword = scanner.next();
        }
        System.out.print("\nEnter Phone number: ");
        String phoneNumber = scanner.next();

        System.out.print("\nAre you signing up as a client or seller? (S/C): ");
        String accType = scanner.next();
        User user;
        if(accType.equalsIgnoreCase("S")){
            user = new Seller();
        } else{
            user = new Client();
            System.out.print("\nEnter address: ");
            String address = scanner.next();
            System.out.print("\nEnter payment Method: ");
            String paymentMethod = scanner.next();

            ((Client) user).setAddress(address);
            ((Client) user).setPaymentMethod(paymentMethod);
        }

        user.setID(ID);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        dataManager.getUsers().add(user);
    }
}
