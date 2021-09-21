package com.project.dao.impl;

import com.project.dao.EntityDao;
import com.project.entities.Ticket;
import com.project.persistance.DataSourceFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDao implements EntityDao<Ticket> {
    private final static Logger LOG = Logger.getLogger(TicketDao.class);
    public static final String ID = "id";
    public static final String ID_EXHIBITION = "id_exhibition";
    public static final String SOLD_DATE = "sold_date";
    public static final String ID_USER = "id_user";
    public static final String SELECT_ALL_QUERY = "SELECT * FROM tickets";
    public static final String SELECT_BY_ID_QUERY = "SELECT * FROM tickets WHERE ID = ?";
    public static final String CREATE_QUERY = "INSERT INTO tickets(id_exhibition, id_user, sold_date) VALUES (?,?,?)";
    public static final String UPDATE_QUERY = "UPDATE INTO tickets SET(id_exhibition, id_user, sold_date) VALUES (?,?,?)";

    private static TicketDao instance;
    private TicketDao() {}

    public static synchronized TicketDao getTicketDao() {
        if (instance == null) {
            instance = new TicketDao();
        }
        return instance;
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> ticket = new ArrayList<>();

        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int idExhibition = resultSet.getInt(ID_EXHIBITION);
                int idUser = resultSet.getInt(ID_USER);
                Timestamp soldDate = resultSet.getTimestamp(SOLD_DATE);
                Ticket ticketData = new Ticket(id, idExhibition, idUser, soldDate);
                ticket.add(ticketData);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return ticket;

    }

    @Override
    public Ticket getById(int inputId) {

        Ticket ticketData = null;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            preparedStatement.setInt(1, inputId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int idExhibition = resultSet.getInt(ID_EXHIBITION);
                int idUser = resultSet.getInt(ID_USER);
                Timestamp soldDate = resultSet.getTimestamp(SOLD_DATE);
                ticketData = new Ticket(id, idExhibition, idUser, soldDate);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return ticketData;
    }

    @Override
    public int create(Ticket entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY)) {
            preparedStatement.setInt(1, entity.getIdExhibition());
            preparedStatement.setInt(2, entity.getIdUser());
            preparedStatement.setTimestamp(3, entity.getSoldDate());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public int update(Ticket entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setInt(1, entity.getIdExhibition());
            preparedStatement.setInt(2, entity.getIdUser());
            preparedStatement.setTimestamp(3, entity.getSoldDate());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
