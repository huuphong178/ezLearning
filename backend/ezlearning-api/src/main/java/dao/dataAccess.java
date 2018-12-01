/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import app.config.AppConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap10538
 */
public class dataAccess {

    private static Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://";

    private static dataAccess XLdata;

    private dataAccess() {
        getConnect();
    }

    public static Connection getConnect() {
        try {
            Class.forName(MYSQL_DRIVER);
            connection = (Connection) DriverManager.getConnection(MYSQL_URL + AppConfig.DBNAME, AppConfig.USERNAME, AppConfig.PASSWORD);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public static dataAccess getInstance() throws ClassNotFoundException {
        if (XLdata == null) {
            XLdata = new dataAccess();
        }
        return XLdata;
    }

    public ArrayList<String[]> loadData(String sql) {
        ArrayList<String[]> result = new ArrayList<>();
        try {
            statement = (Statement) connection.createStatement();
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int numberOfColumns = rsmd.getColumnCount();
            while (resultSet.next()) {
                String[] row = new String[numberOfColumns];
                for (int i = 0; i < numberOfColumns; i++) {
                    row[i] = resultSet.getString(i + 1);
                }
                result.add(row);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int runSQL(String sql) {
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(dataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            XLdata = null;
        } catch (Exception e) {
        }
    }
}
