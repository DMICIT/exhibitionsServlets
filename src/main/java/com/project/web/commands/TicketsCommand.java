package com.project.web.commands;

import com.project.dao.TicketDao;
import com.project.dao.impl.TicketDaoImpl;
import com.project.entities.Ticket;
import com.project.entities.User;
import com.project.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class TicketsCommand extends AbstractCommand{
    @Override
    protected String executeGet(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("usersEmail");
        if (userEmail != null) {

            User userByEmail = UserService.getUserByEmail(userEmail);
            int byEmailId = userByEmail.getId();


            TicketDao ticketDao = TicketDaoImpl.getTicketDao();
            List<Ticket> allTicketsByUser = ticketDao.getAllTicketsByUser(byEmailId);
            request.setAttribute("allTickets", allTicketsByUser);
        }

        return "tickets.jsp";
    }

    @Override
    protected String executePost(HttpServletRequest request, HttpServletResponse response) {

        int idExhibition = Integer.parseInt(request.getParameter("idExhibition"));

        HttpSession session = request.getSession();
        String userEmail = (String) session.getAttribute("usersEmail");
        User userByEmail = UserService.getUserByEmail(userEmail);

        TicketDaoImpl instance = TicketDaoImpl.getTicketDao();
        Ticket ticket = new Ticket(idExhibition, userByEmail.getId(), new Timestamp(new Date().getTime()));
        instance.create(ticket);
        return "tickets.jsp";
    }
}
