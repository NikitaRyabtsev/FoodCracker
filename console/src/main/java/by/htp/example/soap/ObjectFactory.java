
package by.htp.example.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.htp.example.main.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddMealResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "addMealResponse");
    private final static QName _DeleteMeal_QNAME = new QName("http://soap.ws.example.htp.by/", "deleteMeal");
    private final static QName _AddMeal_QNAME = new QName("http://soap.ws.example.htp.by/", "addMeal");
    private final static QName _ChangeMealResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "changeMealResponse");
    private final static QName _GetMealById_QNAME = new QName("http://soap.ws.example.htp.by/", "getMealById");
    private final static QName _GetMealsByDate_QNAME = new QName("http://soap.ws.example.htp.by/", "getMealsByDate");
    private final static QName _GetMealsByDateResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "getMealsByDateResponse");
    private final static QName _GetMealsResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "getMealsResponse");
    private final static QName _DeleteMealResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "deleteMealResponse");
    private final static QName _GetMeals_QNAME = new QName("http://soap.ws.example.htp.by/", "getMeals");
    private final static QName _GetMealByIdResponse_QNAME = new QName("http://soap.ws.example.htp.by/", "getMealByIdResponse");
    private final static QName _ServiceException_QNAME = new QName("http://soap.ws.example.htp.by/", "ServiceException");
    private final static QName _ChangeMeal_QNAME = new QName("http://soap.ws.example.htp.by/", "changeMeal");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.htp.example.main.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChangeMealResponse }
     * 
     */
    public ChangeMealResponse createChangeMealResponse() {
        return new ChangeMealResponse();
    }

    /**
     * Create an instance of {@link AddMeal }
     * 
     */
    public AddMeal createAddMeal() {
        return new AddMeal();
    }

    /**
     * Create an instance of {@link AddMealResponse }
     * 
     */
    public AddMealResponse createAddMealResponse() {
        return new AddMealResponse();
    }

    /**
     * Create an instance of {@link DeleteMeal }
     * 
     */
    public DeleteMeal createDeleteMeal() {
        return new DeleteMeal();
    }

    /**
     * Create an instance of {@link GetMealsResponse }
     * 
     */
    public GetMealsResponse createGetMealsResponse() {
        return new GetMealsResponse();
    }

    /**
     * Create an instance of {@link GetMealById }
     * 
     */
    public GetMealById createGetMealById() {
        return new GetMealById();
    }

    /**
     * Create an instance of {@link GetMealsByDate }
     * 
     */
    public GetMealsByDate createGetMealsByDate() {
        return new GetMealsByDate();
    }

    /**
     * Create an instance of {@link GetMealsByDateResponse }
     * 
     */
    public GetMealsByDateResponse createGetMealsByDateResponse() {
        return new GetMealsByDateResponse();
    }

    /**
     * Create an instance of {@link GetMealByIdResponse }
     * 
     */
    public GetMealByIdResponse createGetMealByIdResponse() {
        return new GetMealByIdResponse();
    }

    /**
     * Create an instance of {@link ServiceException }
     * 
     */
    public ServiceException createServiceException() {
        return new ServiceException();
    }

    /**
     * Create an instance of {@link DeleteMealResponse }
     * 
     */
    public DeleteMealResponse createDeleteMealResponse() {
        return new DeleteMealResponse();
    }

    /**
     * Create an instance of {@link GetMeals }
     * 
     */
    public GetMeals createGetMeals() {
        return new GetMeals();
    }

    /**
     * Create an instance of {@link ChangeMeal }
     * 
     */
    public ChangeMeal createChangeMeal() {
        return new ChangeMeal();
    }

    /**
     * Create an instance of {@link Meal }
     * 
     */
    public Meal createMeal() {
        return new Meal();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMealResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "addMealResponse")
    public JAXBElement<AddMealResponse> createAddMealResponse(AddMealResponse value) {
        return new JAXBElement<AddMealResponse>(_AddMealResponse_QNAME, AddMealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "deleteMeal")
    public JAXBElement<DeleteMeal> createDeleteMeal(DeleteMeal value) {
        return new JAXBElement<DeleteMeal>(_DeleteMeal_QNAME, DeleteMeal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "addMeal")
    public JAXBElement<AddMeal> createAddMeal(AddMeal value) {
        return new JAXBElement<AddMeal>(_AddMeal_QNAME, AddMeal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeMealResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "changeMealResponse")
    public JAXBElement<ChangeMealResponse> createChangeMealResponse(ChangeMealResponse value) {
        return new JAXBElement<ChangeMealResponse>(_ChangeMealResponse_QNAME, ChangeMealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMealById")
    public JAXBElement<GetMealById> createGetMealById(GetMealById value) {
        return new JAXBElement<GetMealById>(_GetMealById_QNAME, GetMealById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealsByDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMealsByDate")
    public JAXBElement<GetMealsByDate> createGetMealsByDate(GetMealsByDate value) {
        return new JAXBElement<GetMealsByDate>(_GetMealsByDate_QNAME, GetMealsByDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealsByDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMealsByDateResponse")
    public JAXBElement<GetMealsByDateResponse> createGetMealsByDateResponse(GetMealsByDateResponse value) {
        return new JAXBElement<GetMealsByDateResponse>(_GetMealsByDateResponse_QNAME, GetMealsByDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMealsResponse")
    public JAXBElement<GetMealsResponse> createGetMealsResponse(GetMealsResponse value) {
        return new JAXBElement<GetMealsResponse>(_GetMealsResponse_QNAME, GetMealsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMealResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "deleteMealResponse")
    public JAXBElement<DeleteMealResponse> createDeleteMealResponse(DeleteMealResponse value) {
        return new JAXBElement<DeleteMealResponse>(_DeleteMealResponse_QNAME, DeleteMealResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMeals }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMeals")
    public JAXBElement<GetMeals> createGetMeals(GetMeals value) {
        return new JAXBElement<GetMeals>(_GetMeals_QNAME, GetMeals.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "getMealByIdResponse")
    public JAXBElement<GetMealByIdResponse> createGetMealByIdResponse(GetMealByIdResponse value) {
        return new JAXBElement<GetMealByIdResponse>(_GetMealByIdResponse_QNAME, GetMealByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "ServiceException")
    public JAXBElement<ServiceException> createServiceException(ServiceException value) {
        return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChangeMeal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.example.htp.by/", name = "changeMeal")
    public JAXBElement<ChangeMeal> createChangeMeal(ChangeMeal value) {
        return new JAXBElement<ChangeMeal>(_ChangeMeal_QNAME, ChangeMeal.class, null, value);
    }

}
