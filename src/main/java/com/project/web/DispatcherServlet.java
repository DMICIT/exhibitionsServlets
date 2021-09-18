package com.project.web;

import com.project.services.UserService;
import com.project.services.ValidatorService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private final static Logger LOG = Logger.getLogger(DispatcherServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");

        if (ValidatorService.validate(req)) {

            if (!UserService.isUserExist(email)) {
                UserService.createUser(req);
            } else {
                LOG.info("Already exist user with this email: " + email);
                req.setAttribute("errorMessage", "User already exist");
            }
        }
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }
}
