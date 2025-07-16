package project;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private String username;
    private String password;
    private String email;
    private ArrayList<HashMap<String, Integer>> knownSkills;
    private ArrayList<String> desiredSkills;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.knownSkills = new ArrayList<>();
        this.desiredSkills = new ArrayList<>();
    }

    public String getUsername() { return this.username;}

    public String getPassword() { return this.password;}

    public String getEmail() { return this.email;}

    public void setKnownSkills(HashMap<String, Integer> knownSkills) {
        this.knownSkills.add(knownSkills);
    }

    public void setDesiredSkills(String desiredSkill) {
        this.desiredSkills.add(desiredSkill);
    }

    public ArrayList<HashMap<String, Integer>> getKnownSkills() { return this.knownSkills;}

    public ArrayList<String> getDesiredSkills() {
        return desiredSkills;
    }
}
