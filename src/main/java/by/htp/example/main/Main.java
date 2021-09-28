package by.htp.example.main;

import java.sql.SQLException;

import by.htp.example.bean.Meal;
import by.htp.example.dao.DaoException;
import by.htp.example.dao.MealDao;
import by.htp.example.dao.impl.SQLMealDao;
import by.htp.example.service.ServiceException;
//import by.htp.example.dao.connection.DriverManagerManager;
import by.htp.example.view.AdminMenu;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		AdminMenu menu = new AdminMenu();
		menu.viewMenu();

		System.out.println("END");
		// DBResourceManager dbResourceManager = DBResourceManager.getInstance();

//	String sql = "INSERT INTO User(Name) VALUES(?)
		// Class.forName("com.mysql.cj.jdbc.Driver");
		// Connection con =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/foodtracker?serverTimezone=Europe/Moscow&useSSL=false",
		// "root","7768");
////			PreparedStatement ps = con.prepareStatement(sql);
////			ps.setString(1, "Петр" );
////			ps.setString(2, "Петров");
////			ps.setString(3, "228");
////			ps.executeUpdate();
////			ps.close();
////			con.close();
////		
//			Meal meal = new Meal();
//			MealDao mealDao = new SQLMealDao();
//			try {
//				mealDao.getMeals();
//			} catch (DaoException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		// mealDao.createMeal(meal);
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery("SELECT * FROM User");
//			while(rs.next()) {
//			System.out.println(rs.getInt(1));
//			}
//			rs.close();
//			st.close();

	}

}
