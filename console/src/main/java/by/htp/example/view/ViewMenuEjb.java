package by.htp.example.view;

import by.htp.example.MealServiceRemote;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.impl.MealServiceImpl;
import by.htp.example.util.Util;

import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ViewMenuEjb{

    @Inject
    private MealServiceRemote mealServiceRemote = new MealServiceImpl();

    private Scanner scan;

	public void viewMenuEjb() throws NamingException {
		ejbBeans();
		int userChoose = 0;
		String userId = "4";
		while (userChoose != 7) {
			try {
				showMenu();
				userChoose = Util.scanInt();

				switch (userChoose) {
				case 1:
					displayMeals(mealServiceRemote.getMeals(userId));
					break;
				case 2:
					mealServiceRemote.createMeal(String.valueOf(Util.scanDate())
							,String.valueOf(Util.scanTime()),userId);
					break;
				case 3:
					mealServiceRemote.changeMealCharacteristic(String.valueOf
							(Util.scanDate()),String.valueOf(Util.scanTime()),userId);
					break;
				case 4:
					displayMeals(mealServiceRemote.getMeals(userId));
					mealServiceRemote.deleteMeal(String.valueOf(Util.scanInt()));
					break;
				case 5:
					displayMeals(mealServiceRemote.getMeals(userId));
					System.out.println(mealServiceRemote.getMealById(String.valueOf(Util.scanInt())));
					break;
				case 6:
					displayMeals(mealServiceRemote.getMealByDate(String.valueOf(Util.scanDate())));
					break;
				case 7:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println(">>>[Info] Wrong choose");
				}
			} catch (InputMismatchException |  DateTimeException | IllegalArgumentException  | ServiceException ex) {
				ex.getMessage();
			}
		}
	}

	private void showMenu() {
		System.out.println("Choose your options : ");
		System.out.println("1. Просмотерть все приёмы пищи");
		System.out.println("2. Добавить приём пищи");
		System.out.println("3. Изменить приём пищи");
		System.out.println("4. Удалить приём пищи");
		System.out.println("5. Выбрать приём пищи по номеру");
		System.out.println("6. Выбрать приём пищи по дате");
		System.out.println("7. Exit");
	}

	private void displayMeals(List<Meal> meals) {

		if (meals != null && !meals.isEmpty()) {
			for (int i = 0; i < meals.size(); i++) {
				System.out.println(
						"#" + meals.get(i).getId() + " Meals Date: " + meals.get(i).getDate() + " Time: " + meals.get(i).getTime());
			}
		}
	}
	public static void ejbBeans() throws NamingException {
		Properties p = new Properties();
		p.setProperty("java.naming.factory.initial", "org.wildfly.naming.client.WildFlyInitialContextFactory");
		p.setProperty("java.naming.provider.url", "remote+http://localhost:8080");
		p.setProperty("java.naming.security.principal", "jndiuser");
		p.setProperty("java.naming.security.credentials", "jndiuser");

		System.out.println("creating context");
		InitialContext ctx = new InitialContext(p);

		System.out.println("checking on remote");
		MealServiceRemote mealServiceRemote = (MealServiceRemote) ctx.lookup("web-1.0-SNAPSHOT/MealServiceImpl!by.htp.example.MealServiceRemote");

	}
}
