package project;

public class User {
    private String username;
    private String password;
    private String email;
    private String desiredSkill;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() { return this.username;}

    public String getPassword() { return this.password;}

    public String getEmail() { return this.email;}

    public void setDesiredSkill(String desiredSkill) {
        this.desiredSkill = desiredSkill;
    }

    public String getDesiredSkill() {
        return desiredSkill;
    }
}
