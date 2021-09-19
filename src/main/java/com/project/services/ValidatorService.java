package com.project.services;

import com.project.web.forms.RegistrationForm;

import javax.servlet.http.HttpServletRequest;

public class ValidatorService {
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
}
