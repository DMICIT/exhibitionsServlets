package com.project.services;

import com.project.dao.impl.UserDaoImpl;
import com.project.entities.User;

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

    public static void createUser(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDaoImpl instance = UserDaoImpl.getInstance();
        User user = new User(name, email, password, "user");
        instance.create(user);

        request.setAttribute("errorMessage", "User created");

    }
}
