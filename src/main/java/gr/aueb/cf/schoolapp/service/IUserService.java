package gr.aueb.cf.schoolapp.service;

import gr.aueb.cf.schoolapp.dao.exceptions.UserDAOException;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.dto.UserUpdateDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {
    User insertUser(UserInsertDTO dto) throws UserDAOException;
    User updateUser(UserUpdateDTO dto) throws UserDAOException, UserNotFoundException;
    void deleteUser(Integer id) throws  UserDAOException, UserNotFoundException;
    User getUserById(Integer id) throws UserDAOException, UserNotFoundException;
    List<User> getUserByUsername(String username) throws UserDAOException;
}
