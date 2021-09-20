package com.project.services;

import com.project.web.forms.LoginForm;
import com.project.web.forms.RegistrationForm;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorService {

    private static Pattern patternEmailValidation = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean validate(RegistrationForm form) {

        boolean result = true;


        if (form.getEmail().length() < 3) {
            result = false;
        }
        if (!form.getPassword().equals(form.getConfirmPassword())) {
            result = false;
        }
        return result;
    }

    public static boolean validate(LoginForm form) {
        boolean result = true;

        Matcher matcher = patternEmailValidation.matcher(form.getEmail());
        if (!matcher.matches()) {
            result = false;
        }
        return result;
    }
}
