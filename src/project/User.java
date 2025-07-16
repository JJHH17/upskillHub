package project;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<HashMap<String, Integer>> knownSkills;
    private ArrayList<HashMap<String, Integer>> desiredSkills;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.knownSkills = new ArrayList<>();
        this.desiredSkills = new ArrayList<>();
    }

    public String getUsername() { return this.username;}
}
