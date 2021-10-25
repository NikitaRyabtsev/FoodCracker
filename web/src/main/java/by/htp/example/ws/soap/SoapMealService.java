package by.htp.example.ws.soap;

import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.bean.dao.MealDao;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@WebService(name ="SoapMealService" ,serviceName = "ws/meal")
public class SoapMealService {

    DaoProvider provider = DaoProvider.getInstance();
    MealDao mealDao = provider.getMealDao();

    @WebMethod(operationName = "getMeals")
    public List<Meal> getMeals(@WebParam(name = "userId") int keyUserId) throws ServiceException {
        try {
            return mealDao.getMealsFromDB(keyUserId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @WebMethod(operationName = "addMeal")
    public Meal createMeal(@WebParam(name = "date") String date,
                           @WebParam(name = "time") String time,
                           @WebParam(name = "userId") int id) throws ServiceException{
        try {
            return mealDao.createMealInDB(LocalDate.parse(date),LocalTime.parse(time),
                    id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @WebMethod(operationName = "changeMeal")
    public Meal changeMealCharacteristic(@WebParam(name = "date") String date,
                                         @WebParam(name = "time") String time,
                                         @WebParam(name = "mealId") int mealId) throws ServiceException {
        Meal meal = null;
        try {
            meal = mealDao.changeMealCharacteristicInDB(LocalDate.parse(date)
                    , LocalTime.parse(time), mealId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return meal;
    }

    @WebMethod(operationName = "deleteMeal")
    public void deleteMeal(@WebParam(name = "mealId") int id) throws ServiceException {
        try {
            mealDao.deleteMealFromDB(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @WebMethod(operationName = "getMealById")
    public Meal getMealById(@WebParam(name = "mealId") int id) throws ServiceException {
        try {
            return mealDao.getMealByIdFromDB(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }


    @WebMethod(operationName = "getMealsByDate")
    public List<Meal> getMealByDate(@WebParam(name = "date") String date) throws ServiceException {
        try {
            return mealDao.getMealByDateFromDB(LocalDate.parse(date));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }
}


