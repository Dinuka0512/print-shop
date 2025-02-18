package com.edu.ijse.print_shop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static DBConnection dbConnection;
    public static Connection connection;

    private final String url = "jdbc:mysql://localhost:3306/printShop";
    private final String user = "root";
    private final String password = "0512";

    private DBConnection()  throws SQLException, ClassNotFoundException{
        connection = DriverManager.getConnection(url,user,password);
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException{
        if(dbConnection == null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
