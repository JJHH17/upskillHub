package project;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Database {

    private String dbURL;
    private String dbUsername;
    private String dbPassword;

    public void credentialFetch() {
        // Pulls from creds file
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream("db.properties")) {
            prop.load(input);
        } catch (Exception e) {
            System.out.println("There was a problem authenticating");
            e.printStackTrace();
        }

        this.dbURL = prop.getProperty("dbURL");
        this.dbUsername = prop.getProperty("dbUsername");
        this.dbPassword = prop.getProperty("dbPassword");
    }
}
