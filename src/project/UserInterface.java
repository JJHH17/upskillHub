package project;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    Database database;

    public UserInterface() {
        scanner = new Scanner(System.in);
        database = new Database();
        database.createTable();
    }

    public void start() {
        while (true) {
            System.out.println("Welcome to UpskillHub!");
            System.out.println("'Login' to Login, or 'create' to create an account? 'quit' to quit");
            String loginOrCreate = scanner.nextLine().toLowerCase();

            switch (loginOrCreate) {
                case "create":
                    System.out.println("Please enter your username");
                    String usernameCreate = scanner.nextLine();
                    System.out.println("Please enter your password");
                    String passwordCreate = scanner.nextLine();
                    System.out.println("Please enter your email address");
                    String emailCreate = scanner.nextLine();
                    System.out.println("Please enter the skill you would like to learn");
                    String desiredSkillCreate = scanner.nextLine();
                    User user = new User(usernameCreate, passwordCreate, emailCreate, desiredSkillCreate);
                    database.addUser(user);
                    break;

                case "login":
                    System.out.println("Please enter your username");
                    String usernameLogin = scanner.nextLine();
                    System.out.println("Please enter your password");
                    String passwordLogin = scanner.nextLine();
                    database.fetchTask(usernameLogin, passwordLogin);
                    break;

                case "quit":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
