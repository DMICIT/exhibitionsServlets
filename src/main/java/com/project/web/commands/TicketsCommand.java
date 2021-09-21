package com.project.web.commands;

import com.mysql.cj.Session;
import com.project.dao.impl.TicketDao;
import com.project.entities.Ticket;
import com.project.entities.User;
import com.project.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

public class TicketsCommand extends AbstractCommand{
    @Override
    protected String executeGet(HttpServletRequest request, HttpServletResponse response) {
    executePost(request, response);
        return "tickets.jsp";
    }

    @Override
    protected String executePost(HttpServletRequest request, HttpServletResponse response) {

        int idExhibition = Integer.parseInt(request.getParameter("idExhibition"));

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("user");
        User userByEmail = UserService.getUserByEmail(userEmail);

        TicketDao instance = TicketDao.getTicketDao();
        Ticket ticket = new Ticket(idExhibition, userByEmail.getId(), new Timestamp(new Date().getTime()));
        instance.create(ticket);
        return "tickets.jsp";
    }
}
