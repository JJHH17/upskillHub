package project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Database {

    private String dbURL;
    private String dbUsername;
    private String dbPassword;

    public void credentialFetch() {
        // Pulls from credential file
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
        } catch (Exception e) {
            System.out.println("There was a problem fetching credentials from the db.properties file");
            e.printStackTrace();
        }

        this.dbURL = prop.getProperty("dbURL");
        this.dbUsername = prop.getProperty("dbUsername");
        this.dbPassword = prop.getProperty("dbPassword");
    }

    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "Username varchar(50) PRIMARY KEY, " +
                "Password varchar(15) NOT NULL, " +
                "Email varchar(50) NOT NULL);";

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
}
