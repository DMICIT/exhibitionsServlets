package com.project.services;

import com.project.dao.impl.UserDaoImpl;
import com.project.entities.User;
import com.project.web.forms.RegistrationForm;

import javax.servlet.http.HttpServletRequest;

public class UserService {

    public static boolean isUserExist(String inputEmail) {

        UserDaoImpl instance = UserDaoImpl.getInstance();
        User userByEmail = instance.getByEmail(inputEmail);
        if (userByEmail != null) {
            return true;
        }
        return false;
    }

    public static void createUser(RegistrationForm form) {

        UserDaoImpl instance = UserDaoImpl.getInstance();
        User user = new User(form.getName(), form.getEmail(), form.getPassword(), "user");
        instance.create(user);

    }
}
