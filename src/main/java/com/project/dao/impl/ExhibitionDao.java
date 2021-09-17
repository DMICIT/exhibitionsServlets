package com.project.dao.impl;

import com.project.dao.EntityDao;
import com.project.entities.Exhibition;
import com.project.persistance.DataSourceFactory;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionDao implements EntityDao<Exhibition> {
    private static final Logger LOG = Logger.getLogger(ExhibitionDao.class);
    private static final String ID = "id";
    private static final String ID_THEME = "id_theme";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String START_TIME = "start_time";
    private static final String END_TIME = "end_time";
    private static final String ENTRY_COST = "entry_cost";
    private static final String STATUS = "status";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM exhibitions";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM exhibitions where id = ?";
    private static final String CREATE_QUERY = "INSERT INTO exhibitions (id_theme, start_date, end_date, start_time, end_time, entry_cost, status) VALUES (?, ?, ?, ?, ?, ?, ? )";
    private static final String UPDATE_QUERY = "UPDATE exhibitions SET(id_theme, start_date, end_date, start_time, end_time, entry_cost, status) VALUES (?, ?, ?, ?, ?, ?, ? )";

    @Override
    public List<Exhibition> getAll() {
        List<Exhibition> result = new ArrayList<>();
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int idTheme = resultSet.getInt(ID_THEME);
                Date startDate = resultSet.getDate(START_DATE);
                Date endDate = resultSet.getDate(END_DATE);
                Time startTime = resultSet.getTime(START_TIME);
                Time endTime = resultSet.getTime(END_TIME);
                int cost = resultSet.getInt(ENTRY_COST);
                String status = resultSet.getString(STATUS);
                Exhibition exhibitionData = new Exhibition(id, idTheme, startDate, endDate, startTime, endTime, cost, status);
                LOG.info(exhibitionData);
                result.add(exhibitionData);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Exhibition getById(int inputId) {
        Exhibition exhibition = null;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            preparedStatement.setInt(1, inputId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int idTheme = resultSet.getInt(ID_THEME);
                Date startDate = resultSet.getDate(START_DATE);
                Date endDate = resultSet.getDate(END_DATE);
                Time startTime = resultSet.getTime(START_TIME);
                Time endTime = resultSet.getTime(END_TIME);
                int cost = resultSet.getInt(ENTRY_COST);
                String status = resultSet.getString(STATUS);
                exhibition = new Exhibition(id, idTheme, startDate, endDate, startTime, endTime, cost, status);
            }
        } catch (SQLException throwables) {
            LOG.error(throwables.getMessage(), throwables);
        }
        return exhibition;
    }

    @Override
    public int create(Exhibition entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);) {
            preparedStatement.setInt(1, entity.getIdTheme());
            preparedStatement.setDate(2, entity.getStartDate());
            preparedStatement.setDate(3, entity.getEndDate());
            preparedStatement.setTime(4, entity.getStartTime());
            preparedStatement.setTime(5, entity.getEndTime());
            preparedStatement.setInt(6, entity.getCost());
            preparedStatement.setString(7, entity.getStatus());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;

    }

    @Override
    public int update(Exhibition entity) {

        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {

            preparedStatement.setInt(1, entity.getIdTheme());
            preparedStatement.setDate(2, entity.getStartDate());
            preparedStatement.setDate(3, entity.getEndDate());
            preparedStatement.setTime(4, entity.getStartTime());
            preparedStatement.setTime(5, entity.getEndTime());
            preparedStatement.setInt(6, entity.getCost());
            preparedStatement.setString(7, entity.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
