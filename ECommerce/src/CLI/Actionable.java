package CLI;

import ECommerce.DataManager;
import ECommerce.User;

import java.util.Scanner;

public interface Actionable {
    String getLabel();
    void execute(Scanner scanner, User user, DataManager dataManager);
}
