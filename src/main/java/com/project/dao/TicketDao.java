package com.project.dao;

import com.project.entities.Ticket;

import java.util.List;

public interface TicketDao extends EntityDao<Ticket> {
    List<Ticket> getAllTicketsByUser(int usersId);

}
