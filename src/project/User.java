package project;

public class User {
    private String username;
    private String password;
    private String email;
    private String desiredSkill;

    public User(String username, String password, String email, String desiredSkill) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.desiredSkill = desiredSkill;
    }

    public String getUsername() { return this.username;}

    public String getPassword() { return this.password;}

    public String getEmail() { return this.email;}


    public String getDesiredSkill() {
        return desiredSkill;
    }
}
