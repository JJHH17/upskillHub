package project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.HashMap;
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
                "Username varchar(50) PRIMARY KEY, " +
                "Password varchar(15) NOT NULL, " +
                "Email varchar(50) NOT NULL);";

        tableCreation(sql);
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users (Username, Password, Email) VALUES (?, ?, ?);";

        tableCreation(sql);
    }

    public void createDesiredSkillsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS desiredSkills (" +
                "desired_ID SERIAL PRIMARY KEY, " +
                "skillName varchar(50) NOT NULL);";

        tableCreation(sql);
    }

    public void createKnownSkillsTable() {
        String sql = "CREATE TABLE IF NOT EXISTS knownSkills ("
                + "known_id SERIAL PRIMARY KEY, "
                + "skillName varchar(50) NOT NULL);";

        tableCreation(sql);
    }

    public void userSkillsMapped() {
        String sql = "CREATE TABLE IF NOT EXISTS userSkillsMapped ("
                + "Username varchar(50) NOT NULL, "
                + "known_id INTEGER NOT NULL, "
                + "FOREIGN KEY (Username) REFERENCES users(Username), "
                + "FOREIGN KEY (known_id) REFERENCES knownSkills(known_id), "
                + " PRIMARY KEY (Username, known_id));";

        tableCreation(sql);
    }

    public void desiredSkillsMapped() {
        String sql = "CREATE TABLE IF NOT EXISTS knownSkillsMapped ("
                + "Username varchar(50) NOT NULL, "
                + "desired_ID INTEGER NOT NULL, "
                + "FOREIGN KEY (Username) REFERENCES users(Username), "
                + "FOREIGN KEY (desired_ID) REFERENCES desiredSkills(desired_ID), "
                + " PRIMARY KEY (Username, desired_ID));";

        tableCreation(sql);
    }
}
