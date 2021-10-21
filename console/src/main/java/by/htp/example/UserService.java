package by.htp.example;

import by.htp.example.bean.user.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface UserService {

    User authorization(String login, String password) throws ServiceException;

    void registration(User user) throws ServiceException;

    User getAdminAccessInfo(int id) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void blockUser(User user) throws ServiceException;

    User getUserAccessInfo(int id) throws ServiceException;

    User deleteUser(User user) throws ServiceException;

    User addUserWeight(String id ,String weight, String date) throws ServiceException;
}
