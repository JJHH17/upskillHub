package project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
                "Email varchar(50) NOT NULL);";

        tableCreation(sql);
    }

    public void createSkillsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS skills (" +
                "Skill_ID SERIAL PRIMARY KEY, " +
                "Skill_Name varchar(50) NOT NULL UNIQUE);";

        tableCreation(sql);
    }

    public void createUserSkillsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS user_skills (" +
                "User_ID INT, " +
                "Skill_ID INT, " +
                "PRIMARY KEY (User_ID, Skill_ID)," +
                "FOREIGN KEY (User_ID) REFERENCES users(User_ID)," +
                "FOREIGN KEY (Skill_ID) REFERENCES skills(Skill_ID));";

        tableCreation(sql);
    }

    public void createDesiredSkillsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS desired_skills (" +
                "User_ID INT, " +
                "Skills_ID INT, " +
                "PRIMARY KEY (User_ID, Skill_ID), " +
                "FOREIGN KEY (User_ID) REFERENCES users(User_ID), " +
                "FOREIGN KEY (Skills_ID) REFERENCES skills(Skill_ID));";

        tableCreation(sql);
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users (Username, Password, Email) VALUES (?, ?, ?);";

        try (Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
             PreparedStatement prepared = con.prepareStatement(sql)) {

            prepared.setString(1, user.getUsername());
            prepared.setString(2, user.getPassword());
            prepared.setString(3, user.getEmail());
            prepared.execute();
            System.out.println("User added successfully");

        } catch (SQLException e) {
            System.out.println("There was an error when adding this user");
            e.printStackTrace();
        }
    }

    public void addSkill(String skillName) {
        String sql = "INSERT INTO skills (Skill_Name) VALUES (?);";

        try (Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
             PreparedStatement prepared = con.prepareStatement(sql)) {

            prepared.setString(1, skillName);
            prepared.execute();
            System.out.println("Skill added successfully");

        } catch (SQLException e) {
            System.out.println("There was an error when adding this skill");
            e.printStackTrace();
        }
    }
}
