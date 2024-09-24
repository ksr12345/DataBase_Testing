package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.BeforeTest;


public class ConnectionBaseClass {

    public static Connection connection;
    String username="root";
    String password ="kau$stubh";
    String url="jdbc:mysql://localhost:3306/Jdbc_example";



    @BeforeTest
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void close() throws SQLException {
        connection.close();
    }

}
