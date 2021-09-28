package by.htp.example.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerManager {

//	static DBResourceManager dbResourceManager = DBResourceManager.getInstance();
	
	public static Connection getConnection() throws SQLException{
		
		
		return DriverManager.getConnection(DBParameters.DB_URL,	DBParameters.DB_USER,DBParameters.DB_PASSWORD);
//	return DriverManager.getConnection(dbResourceManager.getValue(DBParameters.DB_URL),
//				dbResourceManager.getValue(DBParameters.DB_USER), dbResourceManager.getValue(DBParameters.DB_PASSWORD));
//	}
	}
}
