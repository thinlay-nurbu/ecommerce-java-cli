package CLI;

import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public class Login {

    public Login(Scanner scanner, DataManager dataManager, NavigationHandler navigationHandler){
        System.out.print("\nEnter your email: ");
        String email = scanner.next();
        System.out.print("\nEnter your password: ");
        String password = scanner.next();

        boolean loggedIn = false;
        for(User user : dataManager.getUsers()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                loggedIn = true;
                navigationHandler.showMenu(user);
                break;
            }
        }

        if(!loggedIn){
            System.out.println("Email or Password doesn't match");
            navigationHandler.init();
        }


    }
}
