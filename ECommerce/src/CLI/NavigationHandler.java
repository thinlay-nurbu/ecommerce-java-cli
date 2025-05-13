package CLI;

import ECommerce.DataManager;
import ECommerce.User;
import java.util.Scanner;

public class NavigationHandler {
    private Scanner scanner;
    private DataManager dataManager;

    public NavigationHandler(DataManager dataManager){
        this.scanner = new Scanner(System.in);
        this.dataManager = dataManager;
    }

    public void welcome(){
        System.out.println("Welcome to our E-commerce System!");
    }

    public void init(){
        System.out.println("1. Login");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");

        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                new Login(scanner, dataManager, this);
                break;
            case 2:
                new SignUp(scanner, dataManager, this);
                System.out.println("You are now Logging in");
                new Login(scanner, dataManager, this);
                break;
            case 3:
                exit();
                break;
            default:
                System.out.println("Invalid Choice!");
                init();
        }
    }

    public void showMenu(User user){
        int i;
        for(i=0; i<user.getActions().size(); i++){
            System.out.println((i+1)+". "+user.getActions().get(i).getLabel());
        }
        System.out.println((i+1)+". Logout");

        System.out.print("Select any one from the above: ");
        int choice = Input.readInt(scanner)-1;
        if(choice == i){
            System.out.println("You are logging out");
            init();
        } else {
            user.getActions().get(choice).execute(scanner, user, dataManager);
            System.out.println(" ");
            showMenu(user);
        }
    }

    public void exit(){
        System.out.println("Thanks for using our system!");
        System.out.println("Have a nice day :)");
        scanner.close();
    }
}
