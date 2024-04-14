package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.IUserDAO;
import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.dto.UserUpdateDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService {
    private final IUserDAO userDAO;

    public UserServiceImpl(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User insertUser(UserInsertDTO dto) throws UserDAOException {
        if (dto == null) return null;
        // User user = null;

        try {
            return Optional.of(userDAO.insert(map(dto)))
                    .orElseThrow(() -> new RuntimeException(""));
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User updateUser(UserUpdateDTO dto) throws UserDAOException, UserNotFoundException {
        if (dto == null) return null;
        User user = null;

        try {
            user = map(dto);

            User existingUser = Optional.ofNullable(userDAO.getById(user.getId()))
                    .orElseThrow(() -> new UserNotFoundException("User not found"));

            return Optional.of(userDAO.update(user))
                    .orElseThrow(() -> new RuntimeException("runtime exception"));
        } catch (UserDAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUser(Integer id) throws UserDAOException, UserNotFoundException {
        if (id == null) return;

        try {
            User existingUser = Optional.ofNullable(userDAO.getById(id))
                    .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
            userDAO.delete(existingUser.getUsername());
        } catch (UserDAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User getUserById(Integer id) throws UserDAOException, UserNotFoundException {
        User user;

        try {
            return Optional.ofNullable(userDAO.getById(id))
                    .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
        } catch (UserDAOException | UserNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> getUserByUsername(String username) throws UserDAOException {

        try {
            return Optional.ofNullable(userDAO.getByUsername(username))
                    .orElseThrow(() -> new RuntimeException("User not found"));
        } catch (UserDAOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private User map(UserInsertDTO dto) {
        return new User(null, dto.getUsername(), dto.getPassword());
    }

    private User map(UserUpdateDTO dto) {
        return new User(dto.getId(), dto.getUsername(), dto.getPassword());
    }
}
