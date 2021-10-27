package by.htp.example;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;
import by.htp.example.bean.user.UserWeightInfo;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;


@Local
public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;

    User getAdminAccessInfo(String id ) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void blockUser(User user) throws ServiceException;

    User getUserAccessInfo(String id) throws ServiceException;

    User deleteUser(User user) throws ServiceException;

    void  addUserWeight(String id, String weight, String date) throws ServiceException;

    User EditProfileInDB(String login , String password , String name, String secondName
            , String email, String sex , String dateOfBirth , String id) throws ServiceException;

    List<UserWeightInfo> getWeightFromDB(String id) throws ServiceException;

    void chooseMealPlan(String planId, String id) throws ServiceException;
}