package by.htp.example.rest;

import by.htp.example.MealService;
import by.htp.example.ServiceException;
import by.htp.example.bean.Meal;
import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.dao.DaoProvider;
import by.htp.example.bean.dao.MealDao;
import by.htp.example.command.RequestParameterName;

import javax.ws.rs.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Path("/meal")
@Consumes({"application/json"})
@Produces({"application/json"})
public class MealRestService implements MealService{

    DaoProvider provider = DaoProvider.getInstance();
    MealDao mealDao = provider.getMealDao();

    @Override
    @GET
    @Path("/id")
    public List<Meal> getMeals(String keyUserId) throws ServiceException {
        try {
            return mealDao.getMealsFromDB(Integer.parseInt(keyUserId));
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
    @Override
    @POST
    public Meal createMeal(@PathParam(RequestParameterName.REQ_PARAM_DATE) String date,
                           @PathParam(RequestParameterName.REQ_PARAM_TIME) String time,
                           @PathParam(RequestParameterName.REQ_PARAM_ID) String id) throws ServiceException {
        try {
            return mealDao.createMealInDB(LocalDate.parse(date),
                    LocalTime.parse(time), Integer.parseInt(id));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }
    @Override
    @POST
    public Meal changeMealCharacteristic(String date ,String time, String mealId) throws ServiceException {
        Meal meal = null;
        try {
           meal = mealDao.changeMealCharacteristicInDB(LocalDate.parse(date)
                   ,LocalTime.parse(time), Integer.parseInt(mealId));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
        return meal;
    }
    @Override
    @POST
    public void deleteMeal(String id) throws ServiceException {
        try{
            mealDao.deleteMealFromDB(Integer.parseInt(id));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    @POST
    public Meal getMealById(@PathParam(RequestParameterName.REQ_PARAM_ID) String id) throws ServiceException {
        try{
            return mealDao.getMealByIdFromDB(Integer.parseInt(id));
        }catch(DaoException e){
            throw new ServiceException(e);
        }
    }

    @Override
    @POST
    public List<Meal> getMealByDate(@PathParam(RequestParameterName.REQ_PARAM_DATE) String date) throws ServiceException {
        try{
            return mealDao.getMealByDateFromDB(LocalDate.parse(date));
        }catch(DaoException e){
            throw new ServiceException(e);
        }

    }
}
