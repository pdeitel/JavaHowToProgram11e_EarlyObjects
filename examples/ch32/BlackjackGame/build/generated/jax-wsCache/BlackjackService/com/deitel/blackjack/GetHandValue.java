
package com.deitel.blackjack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHandValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHandValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hand" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHandValue", propOrder = {
    "hand"
})
public class GetHandValue {

    protected String hand;

    /**
     * Gets the value of the hand property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHand() {
        return hand;
    }

    /**
     * Sets the value of the hand property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHand(String value) {
        this.hand = value;
    }

}
