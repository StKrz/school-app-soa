package gr.aueb.cf.schoolapp.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void gettersSetters() {
        User user = new User();
        user.setId(1);
        user.setUsername("Thanassis");
        user.setPassword("456789876");

        assertEquals(1, user.getId());
        assertEquals("Thanassis", user.getUsername());
        assertEquals("456789876", user.getPassword());
    }

    @Test
    void overloadedConstructorAndToString() {
        User user = new User(2, "Anna", "123654");
        assertEquals(2, user.getId());
        assertEquals("Anna", user.getUsername());
        assertEquals("123654", user.getPassword());

        String expected = "2, Anna, 123654";
        String actual = user.toString();
        assertEquals(expected, actual);
    }
}