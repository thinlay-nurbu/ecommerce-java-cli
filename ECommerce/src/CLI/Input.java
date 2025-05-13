package CLI;

import java.util.Scanner;

public class Input {

    public static String readStringLine(Scanner scanner){
        String line;
        do{
            line = scanner.nextLine();
        } while(line.isEmpty());
        return line;
    }

    public static String readString(Scanner scanner){
        String line;
        do{
            line = scanner.next();
            scanner.nextLine();
        } while(line.isEmpty());
        return line;
    }

    public static double readDouble(Scanner scanner){
        double d = 0;
        boolean isValid = false;
        while(!isValid){
            try{
                String input = readString(scanner);
                d = Double.parseDouble(input);
                isValid = true;
            }catch(Exception e){
                System.out.println("Invalid! Please enter double type!");
            }
        }
        return d;
    }

    public static int readInt(Scanner scanner){
        int value = 0;
        boolean isValid = false;
        while(!isValid){
            try{
                String input = readString(scanner);
                value = Integer.parseInt(input);
                isValid = true;
            } catch(Exception e){
                System.out.println("Invalid! Please enter Integer type!");
            }
        }
        return value;
    }
}
