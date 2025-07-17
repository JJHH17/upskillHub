package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.User;

import java.util.ArrayList;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void objectCreation() {
        user = new User("testUser", "testPassword", "test@test.com");

        // Setting known skills
        String knownSkill1 = "music";
        String knownSkill2 = "programming";
        String knownSkill3 = "farming";
        user.setKnownSkills(knownSkill1);
        user.setKnownSkills(knownSkill2);
        user.setKnownSkills(knownSkill3);

        // Setting desired skills
        String desiredSkill1 = "guitar";
        String desiredSkill2 = "piano";
        String desiredSkill3 = "cooking";
        user.setDesiredSkills(desiredSkill1);
        user.setDesiredSkills(desiredSkill2);
        user.setDesiredSkills(desiredSkill3);
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
    void testKnownSkillsSize() {
        assertEquals(3, user.getKnownSkills().size());
    }

    @Test
    void testKnownSkillsValues() {
        assertEquals("music", user.getKnownSkills().get(0));
        assertEquals("programming", user.getKnownSkills().get(1));
        assertEquals("farming", user.getKnownSkills().get(2));
    }

    @Test
    void testDesiredSkillsSize() {
        assertEquals(3, user.getDesiredSkills().size());
    }

    @Test
    void testDesiredSkillsValues() {
        assertEquals("guitar", user.getDesiredSkills().get(0));
        assertEquals("piano", user.getDesiredSkills().get(1));
        assertEquals("cooking", user.getDesiredSkills().get(2));
    }
}