
package by.htp.example.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMealById complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMealById">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mealId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMealById", propOrder = {
    "mealId"
})
public class GetMealById {

    protected String mealId;

    /**
     * Gets the value of the mealId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealId() {
        return mealId;
    }

    /**
     * Sets the value of the mealId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealId(String value) {
        this.mealId = value;
    }

}
