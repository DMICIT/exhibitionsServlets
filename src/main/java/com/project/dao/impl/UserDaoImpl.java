package com.project.dao.impl;

import com.project.dao.EntityDao;
import com.project.dao.UserDao;
import com.project.entities.User;
import com.project.persistance.DataSourceFactory;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    private static final String ROLE = "role";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM users";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM users WHERE id =?";
    private static final String CREATE_QUERY = "INSERT INTO users (name, email, password, role) VALUES ( ?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE users SET (name, email, password, role) VALUES ( ?,?,?)";
    public static final String SELECT_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    private static UserDaoImpl instance;

    private UserDaoImpl() {}

    public static synchronized UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String role = resultSet.getString(ROLE);
                User userData = new User(id, name, email, password, role);
                result.add(userData);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public User getById(int inputtId) {
        User userData = null;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID_QUERY);) {
            preparedStatement.setInt(1, inputtId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String role = resultSet.getString(ROLE);
                userData = new User(id, name, email, password, role);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return userData;
    }

    @Override
    public User getByEmail(String inputEmail) {
        User userData = null;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_EMAIL);) {
            preparedStatement.setString(1, inputEmail);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(ID);
                String name = resultSet.getString(NAME);
                String email = resultSet.getString(EMAIL);
                String password = resultSet.getString(PASSWORD);
                String role = resultSet.getString(ROLE);
                userData = new User(id, name, email, password, role);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return userData;
    }

    @Override
    public int create(User entity) {

        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getRole());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public int update(User entity) {

        int result = 0;
        try (Connection connection = DataSourceFactory.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getPassword());
            preparedStatement.setString(4, entity.getRole());
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return result;
    }
}
