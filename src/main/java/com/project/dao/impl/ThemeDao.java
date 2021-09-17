package com.project.dao.impl;
import com.project.dao.EntityDao;
import com.project.entities.Theme;
import com.project.persistance.DataSourceFactory;
import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThemeDao implements EntityDao<Theme> {
    private static final Logger LOG = Logger.getLogger(ThemeDao.class);
    private static final String ID = "id";
    private static final String THEME = "theme";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM themes";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM themes WHERE id =?";
    private static final String CREATE_QUERY = "INSERT INTO themes (theme) VALUES (?)";
    private static final String UPDATE_QUERY = "UPDATE themes SET(theme) VALUES (?)";

    @Override
    public List<Theme> getAll() {
        List<Theme> result = new ArrayList<>();

        try (Connection connection = DataSourceFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String theme = resultSet.getString(THEME);
                Theme themeData = new Theme(id, theme);
                result.add(themeData);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Theme getById(int inputtId) {
        Theme themeData = null;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            preparedStatement.setInt(1, inputtId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String theme = resultSet.getString(THEME);
                themeData = new Theme(id, theme);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return themeData;
    }

    @Override
    public int create(Theme entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);) {
            preparedStatement.setString(1, entity.getTheme());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public int update(Theme entity) {
        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);) {
            preparedStatement.setString(1, entity.getTheme());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
