package gr.aueb.cf.schoolapp.dao;

import static org.junit.jupiter.api.Assertions.*;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dao.util.DBHelper;
import gr.aueb.cf.schoolapp.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static IUserDAO userDAO;

    @BeforeAll
    public static void setupClass() throws SQLException {
        userDAO = new UserDAOImpl();
        DBHelper.eraseData();
    }

    @BeforeEach
    void setUp() throws UserDAOException {
        createDummyUsers();
    }

    @AfterEach
    void tearDown() throws SQLException {
        DBHelper.eraseData();
    }

    @Test
    void persistAndGetTeacher() throws UserDAOException {
        User user = new User();
        user.setUsername("Bob");
        user.setPassword("12345");
        userDAO.insert(user);

        List<User> users = userDAO.getByUsername("Marl");
        assertEquals(1, users.size());
    }

    @Test
    void update() throws UserDAOException {
        User user = new User();
        user.setId(2);
        user.setUsername("Anna2");
        user.setPassword("12345");
        userDAO.update(user);

        List<User> users = userDAO.getByUsername(user.getUsername());
        assertEquals(users.get(0).getUsername(), "Anna2");
    }

    @Test
    void delete() throws UserDAOException {
        User user = new User();
        String username = user.getUsername();
        userDAO.delete(username);

        User user1 = userDAO.getById(1);
        assertNull(user1);
    }

    @Test
    void getByLastname() throws UserDAOException {
        List<User> users = userDAO.getByUsername("Kape");
        assertEquals(2, users.size());
    }

    @Test
    void getById() throws UserDAOException {
        int id = 4;
        User user = userDAO.getById(4);
        assertNotNull(user);
        assertEquals("Kapetidis", user.getUsername());
    }

    public static void createDummyUsers() throws UserDAOException {
        User user = new User();
        user.setUsername("Athanassios");
        user.setPassword("12345");
        userDAO.insert(user);

        user.setUsername("Anna");
        user.setPassword("54321");
        userDAO.insert(user);

        user.setUsername("Makis");
        user.setPassword("31232");
        userDAO.insert(user);

        user.setUsername("John");
        user.setPassword("19875");
        userDAO.insert(user);
    }
}