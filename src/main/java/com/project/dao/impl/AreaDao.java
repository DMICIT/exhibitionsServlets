package com.project.dao.impl;
import com.project.dao.EntityDao;
import com.project.entities.Area;
import com.project.persistance.DataSourceFactory;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDao implements EntityDao<Area> {
    private static final Logger LOG = Logger.getLogger(AreaDao.class);
    private static final String ID = "id";
    private static final String AREA = "area";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM areas";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM areas WHERE id = ?";
    private static final String CREATE_QUERY = "INSERT INTO areas(area) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE areas SET(area) VALUES (?)";


    @Override
    public List<Area> getAll() {
        List<Area> result = new ArrayList<>();
        try (Connection connection = DataSourceFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);){
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int area = resultSet.getInt(AREA);
                Area areaData = new Area(id, area);
                result.add(areaData);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Area getById(int inputId) {
        Area areaData = null;

        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY);){
            preparedStatement.setInt(1, inputId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID);
                int area = resultSet.getInt(AREA);
                areaData = new Area(id, area);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return areaData;
    }

    @Override
    public int create(Area entity) {

        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);){
            preparedStatement.setInt(1, entity.getArea());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public int update(Area entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {
            preparedStatement.setInt(1, entity.getArea());
            result = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
