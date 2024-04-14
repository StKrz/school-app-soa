package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.UserDAOImpl;
import gr.aueb.cf.schoolapp.dao.exceptions.TeacherDAOException;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dao.util.DBHelper;
import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherUpdateDTO;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.dto.UserUpdateDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.exceptions.TeacherNotFoundException;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private static IUserDAO userDAO;
    private static IUserService userService;


    @BeforeAll
    public static void setupClass() {
        userDAO = new UserDAOImpl();
        userService = new UserServiceImpl(userDAO);
    }

    @BeforeEach
    public void setup() throws UserDAOException {
        createDummyUsers();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        DBHelper.eraseData();
    }

    @Test
    public void insertAndGetUser() throws UserDAOException {
        UserInsertDTO dto = new UserInsertDTO("Krug", "12345");
        userService.insertUser(dto);

        List<User> users = userService.getUserByUsername("Krug");
        assertEquals(1, users.size());
    }

    @Test
    public void updateUser() throws UserNotFoundException, UserDAOException {
        UserUpdateDTO dto = new UserUpdateDTO(1, "Andreas", "1233654");
        userService.updateUser(dto);

        List<User> users = userService.getUserByUsername("Andreas");
        assertEquals(dto.getUsername(), users.get(0).getUsername());
        assertEquals(dto.getPassword(), users.get(0).getPassword());
    }

    @Test
    public void updateInvalidUser() {
        UserUpdateDTO dto = new UserUpdateDTO(10, "Andreas", "123654");

        assertThrows(UserNotFoundException.class, () -> {
            userService.updateUser(dto);
        });
    }

    @Test
    public void deleteUser() throws UserNotFoundException, UserDAOException {
        int id = 1;
        userService.deleteUser(id);

        List<User> users = userService.getUserByUsername("Androu");
        assertEquals(0, users.size());
    }

    @Test
    public void deleteInvalidUser() {
        int id = 20;
        assertThrows(UserNotFoundException.class, () -> userService.deleteUser(id));
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