
package by.htp.example.soap;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SoapMealService", targetNamespace = "http://soap.ws.example.htp.by/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SoapMealService {


    /**
     * 
     * @param userId
     * @return
     *     returns java.util.List<by.htp.example.main.soap.Meal>
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMeals", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMeals")
    @ResponseWrapper(localName = "getMealsResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMealsResponse")
    public List<Meal> getMeals(
        @WebParam(name = "userId", targetNamespace = "")
        String userId)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param mealId
     * @throws ServiceException_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteMeal", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.DeleteMeal")
    @ResponseWrapper(localName = "deleteMealResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.DeleteMealResponse")
    public void deleteMeal(
        @WebParam(name = "mealId", targetNamespace = "")
        String mealId)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param date
     * @param time
     * @param userId
     * @return
     *     returns by.htp.example.main.soap.Meal
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addMeal", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.AddMeal")
    @ResponseWrapper(localName = "addMealResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.AddMealResponse")
    public Meal addMeal(
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "time", targetNamespace = "")
        String time,
        @WebParam(name = "userId", targetNamespace = "")
        String userId)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param mealId
     * @return
     *     returns by.htp.example.main.soap.Meal
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMealById", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMealById")
    @ResponseWrapper(localName = "getMealByIdResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMealByIdResponse")
    public Meal getMealById(
        @WebParam(name = "mealId", targetNamespace = "")
        String mealId)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param date
     * @return
     *     returns java.util.List<by.htp.example.main.soap.Meal>
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMealsByDate", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMealsByDate")
    @ResponseWrapper(localName = "getMealsByDateResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.GetMealsByDateResponse")
    public List<Meal> getMealsByDate(
        @WebParam(name = "date", targetNamespace = "")
        String date)
        throws ServiceException_Exception
    ;

    /**
     * 
     * @param date
     * @param mealId
     * @param time
     * @return
     *     returns by.htp.example.main.soap.Meal
     * @throws ServiceException_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "changeMeal", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.ChangeMeal")
    @ResponseWrapper(localName = "changeMealResponse", targetNamespace = "http://soap.ws.example.htp.by/", className = "by.htp.example.main.soap.ChangeMealResponse")
    public Meal changeMeal(
        @WebParam(name = "date", targetNamespace = "")
        String date,
        @WebParam(name = "time", targetNamespace = "")
        String time,
        @WebParam(name = "mealId", targetNamespace = "")
        String mealId)
        throws ServiceException_Exception
    ;

}