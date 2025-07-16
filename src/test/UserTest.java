package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.User;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void objectCreation() {
        user = new User("testUser", "testPassword", "test@test.com");

        // Setting known skills
        HashMap<String, Integer> skill1 = new HashMap<>();
        skill1.put("Java", 5);
        HashMap<String, Integer> skill2 = new HashMap<>();
        skill2.put("C++", 3);
        HashMap<String, Integer> skill3 = new HashMap<>();
        skill3.put("Python", 2);
        user.setKnownSkills(skill1);
        user.setKnownSkills(skill2);
        user.setKnownSkills(skill3);

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
        assertEquals(5, user.getKnownSkills().get(0).get("Java"));
        assertEquals(3, user.getKnownSkills().get(1).get("C++"));
        assertEquals(2, user.getKnownSkills().get(2).get("Python"));
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