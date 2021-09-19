package com.project.web;

import com.project.factory.CommandFactory;
import com.project.services.UserService;
import com.project.services.ValidatorService;
import com.project.web.commands.Command;
import com.project.web.commands.LoginCommand;
import com.project.web.commands.RegistrationCommand;
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

        processRequest(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getPath(req);

        Command command = CommandFactory.getCommand(path);
        String page = command.execute(req,resp);

        req.getRequestDispatcher("/WEB-INF/pages/" + page).forward(req, resp);
    }

    private String getPath(HttpServletRequest request){
        String requestUri = request.getRequestURI();
        int lastSymbol = requestUri.lastIndexOf('/');
        return requestUri.substring(lastSymbol + 1);

    }
}
