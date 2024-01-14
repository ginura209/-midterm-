package package1;


import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

    private static int id;
    private static String name;
    private static String yob;
    private static int sugar_level;

    private static final ArrayList<BloodSugar> users = new ArrayList();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("**Blood Sugar Monitor** ");

        int input;

        while (true) {
            displayMenu();
            input = scanner.nextInt();

            switch (input) {
                case 0 -> exit();
                case 1 -> create();
                case 2 -> index();
                case 3 -> {
                    System.out.println("Enter Client Id");
                    input = scanner.nextInt();
                    view(input);
                }
                case 4 -> delete();

            }
        }

    }

    public static void displayMenu() {
        System.out.println("Main Menu...");
        System.out.println("1 - client Record");
        System.out.println("2 - All clients");
        System.out.println("3 - View client");
        System.out.println("4 - Delete");
        System.out.println("0 - Exit");
    }

    public static void index() {//show all records
        System.out.println("All clients");
        users.forEach(user -> user.display());
    }

    public static void view(int id) { // show onw record
        users.forEach(user -> {
            if (user.getId() == id) {
                user.display();
            }
        });
    }

    public static void create() {//create user
        System.out.println("clients Details");

        System.out.println("client Id");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("client Name");
        name = scanner.nextLine();

        System.out.println("YOB");
        yob = scanner.nextLine();

        System.out.println("Blood Sugar Level");
        sugar_level = scanner.nextInt();

        BloodSugar user = new BloodSugar(id, name, yob, sugar_level);

        users.add(user);
    }

    public static void delete() {//delete user
        System.out.println("All Deleted");
        users.clear();
    }

    public static void exit() {
        System.out.println("Exit");
        System.exit(0);
    }

}
