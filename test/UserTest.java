import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import project.User;

public class UserTest {

    @Test
    void testUsername() {
        User user = new User("samantha", "password", "Samantha.Smith@aol.com");
        assertEquals("samantha", user.getUsername());
    }
}