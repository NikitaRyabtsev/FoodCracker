package by.htp.example;

import by.htp.example.bean.dao.DaoException;
import by.htp.example.bean.user.User;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;


@Local
public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;

    User getAdminAccessInfo(int id) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void blockUser(User user) throws ServiceException;

    User getUserAccessInfo(String id ,  String weightId) throws ServiceException;

    User deleteUser(User user) throws ServiceException;

    User addUserWeight(String id, String weight, String date) throws ServiceException;

    User EditProfileInDB(String login , String password , String name, String secondName
            , String email, String sex , String dateOfBirth , String id) throws ServiceException;

    User getWeightFromDB(String id, String date) throws ServiceException;
}