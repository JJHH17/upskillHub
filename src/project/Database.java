package project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Database {

    private String dbURL;
    private String dbUsername;
    private String dbPassword;

    public Database() {
        // Pulls from credential file
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
        } catch (Exception e) {
            System.out.println("There was a problem fetching credentials from the db.properties file");
            e.printStackTrace();
        }

        this.dbURL = prop.getProperty("db.url");
        this.dbUsername = prop.getProperty("db.username");
        this.dbPassword = prop.getProperty("db.password");
    }

    public void tableCreation(String sql) {
        // Establishing a connection with database
        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.println("Table created successfully");
            connection.close();

        } catch (Exception e) {
            System.out.println("There was a problem creating the database table");
            e.printStackTrace();
        }
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "User_ID SERIAL PRIMARY KEY, " +
                "Username varchar(50) NOT NULL UNIQUE, " +
                "Password varchar(15) NOT NULL, " +
                "Email varchar(50) NOT NULL, " +
                "Desired_Skill varchar(50) NOT NULL);";

        tableCreation(sql);
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users (Username, Password, Email, Desired_Skill) VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
             PreparedStatement prepared = con.prepareStatement(sql)) {

            prepared.setString(1, user.getUsername());
            prepared.setString(2, user.getPassword());
            prepared.setString(3, user.getEmail());
            prepared.setString(4, user.getDesiredSkill());
            prepared.execute();
            System.out.println("User added successfully");

        } catch (SQLException e) {
            System.out.println("There was an error when adding this user to the database");
            e.printStackTrace();
        }
    }

    public void fetchTask(String username, String password) {
        String sql = "SELECT Desired_Skill FROM users WHERE Username = ? AND Password = ?";

        try (Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
             PreparedStatement prepared = con.prepareStatement(sql)) {

            prepared.setString(1, username);
            prepared.setString(2, password);
            ResultSet result = prepared.executeQuery();

            if (result.next()) {
                String skill = result.getString("Desired_Skill");
                System.out.println("Desired skill: " + skill);
            } else {
                System.out.println("Account not found, please try again");
            }

        } catch (SQLException e) {
            System.out.println("There was an error when fetching this user's desired skill from the database");
            e.printStackTrace();
        }
    }
}
