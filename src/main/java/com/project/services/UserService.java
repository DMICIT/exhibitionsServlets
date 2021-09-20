package com.project.services;

import com.project.dao.impl.UserDaoImpl;
import com.project.entities.User;
import com.project.web.forms.RegistrationForm;


public class UserService {
    public static User getUserByEmail(String inputEmail){
        UserDaoImpl instance = UserDaoImpl.getInstance();
        return instance.getByEmail(inputEmail);
    }

    public static boolean isUserExist(String inputEmail) {
        User userByEmail = getUserByEmail(inputEmail);
        return userByEmail != null;
    }

    public static void createUser(RegistrationForm form) {

        UserDaoImpl instance = UserDaoImpl.getInstance();
        User user = new User(form.getName(), form.getEmail(), form.getPassword(), "user");
        instance.create(user);

    }
}
