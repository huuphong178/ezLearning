/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lap10538
 */
public class dataAccess1 {

    public static Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    public static final String MYSQL_URL = "jdbc:mysql://localhost:3306/ezlearning?useUnicode=true&characterEncoding=UTF-8";
    ;
    private final String userName = "root";
    private final String passWord = "123456";

    public Connection connect() {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = (Connection) DriverManager.getConnection(MYSQL_URL, userName, passWord);
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public ResultSet loadData(String sql) {
        try {
            Class.forName(MYSQL_DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection = (Connection) DriverManager.getConnection(MYSQL_URL, userName, passWord);
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            statement = (Statement) connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                System.out.println(username);

            }

        } catch (SQLException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultSet;

    }

    public int RunSQL(String sql) {
        try {
            connect();
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            return preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(dataAccess1.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception e) {
        }
    }
}
