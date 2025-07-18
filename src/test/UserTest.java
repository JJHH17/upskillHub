package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void objectCreation() {
        user = new User("testUser", "testPassword", "test@test.com");

        // Setting known skills
        user.setKnownSkill("music");

        // Setting desired skills
        user.setDesiredSkill("guitar");
    }

    @Test
    void testUsername() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    void testPassword() {
        assertEquals("testPassword", user.getPassword());
    }

    @Test
    void testEmail() { assertEquals("test@test.com", user.getEmail());
    }

    @Test
    void testKnownSkillsValues() {
        assertEquals("music", user.getKnownSkill());
    }

    @Test
    void testDesiredSkillsValues() {
        assertEquals("guitar", user.getDesiredSkill());
    }
}