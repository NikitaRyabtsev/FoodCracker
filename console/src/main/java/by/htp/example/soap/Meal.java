
package by.htp.example.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for meal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="meal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="keyUserId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mealId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DateOfEating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timeOfEating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="calories" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meal", propOrder = {
    "keyUserId",
    "mealId",
    "dateOfEating",
    "timeOfEating",
    "calories"
})
public class Meal {

    protected int keyUserId;
    protected int mealId;
    @XmlElement(name = "DateOfEating")
    protected String dateOfEating;
    protected String timeOfEating;
    protected double calories;

    /**
     * Gets the value of the keyUserId property.
     * 
     */
    public int getKeyUserId() {
        return keyUserId;
    }

    /**
     * Sets the value of the keyUserId property.
     * 
     */
    public void setKeyUserId(int value) {
        this.keyUserId = value;
    }

    /**
     * Gets the value of the mealId property.
     * 
     */
    public int getMealId() {
        return mealId;
    }

    /**
     * Sets the value of the mealId property.
     * 
     */
    public void setMealId(int value) {
        this.mealId = value;
    }

    /**
     * Gets the value of the dateOfEating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfEating() {
        return dateOfEating;
    }

    /**
     * Sets the value of the dateOfEating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfEating(String value) {
        this.dateOfEating = value;
    }

    /**
     * Gets the value of the timeOfEating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeOfEating() {
        return timeOfEating;
    }

    /**
     * Sets the value of the timeOfEating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeOfEating(String value) {
        this.timeOfEating = value;
    }

    /**
     * Gets the value of the calories property.
     * 
     */
    public double getCalories() {
        return calories;
    }

    /**
     * Sets the value of the calories property.
     * 
     */
    public void setCalories(double value) {
        this.calories = value;
    }

}
