package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.UserInsertDTO;
import gr.aueb.cf.schoolapp.dto.UserUpdateDTO;
import gr.aueb.cf.schoolapp.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserValidator {

    public UserValidator() {

    }

    public static Map<String, String> validate(UserInsertDTO userInsertDTO) {
        Map<String, String> errors = new HashMap<>();

        if (userInsertDTO.getUsername().length() < 2 || userInsertDTO.getUsername().length() > 32) {
            errors.put("username", "size");
        }

        if (userInsertDTO.getPassword().matches("^.*\\s+.*$")) {
            errors.put("password", "whitespaces");
        }
//
//        if (userInsertDTO.getUsername().length() < 2 || userInsertDTO.getUsername().length() > 32) {
//            errors.put("lastname", "size");
//        }
//
//        if (userInsertDTO.getUsername().matches("^.*\\s+.*$")) {
//            errors.put("lastname", "whitespaces");
//        }
        return errors;
    }

    public static Map<String, String> validate(UserUpdateDTO userUpdateDTO) {
        Map<String, String> errors = new HashMap<>();

        if (userUpdateDTO.getUsername().length() < 2 || userUpdateDTO.getUsername().length() > 32) {
            errors.put("username", "size");
        }

        if (userUpdateDTO.getPassword().length() < 2 || userUpdateDTO.getPassword().length() > 32) {
            errors.put("password", "whitespaces");
        }
        return errors;
    }
}
