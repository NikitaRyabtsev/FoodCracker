package by.htp.example.bean.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerManager {

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DBParameters.DB_URL, DBParameters.DB_USER, DBParameters.DB_PASSWORD);


    }
}
