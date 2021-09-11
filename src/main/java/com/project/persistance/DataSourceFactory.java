package com.project.persistance;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.project.entities.Exhibition;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.*;

public class DataSourceFactory {
    private static final Logger LOG = Logger.getLogger(DataSourceFactory.class);
    private static final DataSourceFactory INSTANCE = new DataSourceFactory();

    private static DataSource dataSource;

    private DataSourceFactory() {
    }

    static {
        try {
            MysqlDataSource mysqlDataSource = new MysqlDataSource();
            mysqlDataSource.setUrl("jdbc:mysql://localhost:3306/exhibitions?useUnicode=true&serverTimezone=UTC&useSSL=false");
            mysqlDataSource.setDatabaseName("exhibitions");
            mysqlDataSource.setCharacterEncoding("UTF-8");
            mysqlDataSource.setUser("root");
            mysqlDataSource.setPassword("rootroot");

            dataSource = mysqlDataSource;

        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DataSourceFactory.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM exhibitions.exhibitions WHERE id = ?");
        preparedStatement.setInt(1,2);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            int id = resultSet.getInt(1);
            int idTheme = resultSet.getInt("id_theme");
            Date startDate = resultSet.getDate("start_date");
            Date endDate = resultSet.getDate(4);
            Time startTime = resultSet.getTime(5);
            Time endTime = resultSet.getTime(6);
            int cost = resultSet.getInt(7);
            String status = resultSet.getString(8);

            Exhibition exhibitionData = new Exhibition(id,idTheme,startDate,endDate,startTime,endTime,cost,status);
            LOG.info(exhibitionData);

        }
    }
}