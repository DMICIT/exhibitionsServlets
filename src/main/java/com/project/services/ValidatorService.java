package com.project.services;

import javax.servlet.http.HttpServletRequest;

public class ValidatorService {
    public static boolean validate(HttpServletRequest request) {

        boolean result = true;

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        if (email.length() < 3) {
            result = false;
            request.setAttribute("errorMessage", "False email");
        }
        if (!password.equals(confirmPassword)) {
            result = false;
            request.setAttribute("errorMessage", "Passwords are not same");
        }
        return result;
    }
}
