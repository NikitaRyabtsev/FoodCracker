package by.htp.example;

import by.htp.example.impl.MealServiceImpl;
import by.htp.example.impl.UserServiceImpl;
import by.htp.example.impl.FoodServiceImpl;

public class ServiceProvider {

    private static final ServiceProvider instance = new ServiceProvider();

    ServiceProvider() {
    }

    public static ServiceProvider getInstance() {
        return instance;
    }

    private final MealService mealService = new MealServiceImpl();

    private final UserService userService = new UserServiceImpl();

    private final FoodService foodService = new FoodServiceImpl();

    public FoodService getFoodService() {
        return foodService;
    }

    public MealService getServiceMeal() {
        return mealService;
    }

    public UserService getUserService() {
        return userService;
    }

}
