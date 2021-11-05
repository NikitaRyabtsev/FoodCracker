
package by.htp.example.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addMeal complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="addMeal">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addMeal", propOrder = {
        "date",
        "time",
        "userId"
})
public class AddMeal {

    protected String date;
    protected String time;
    protected String userId;

    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the userId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
