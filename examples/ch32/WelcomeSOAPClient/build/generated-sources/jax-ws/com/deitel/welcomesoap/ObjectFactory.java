
package com.deitel.welcomesoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deitel.welcomesoap package. 
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

    private final static QName _WelcomeResponse_QNAME = new QName("http://welcomesoap.deitel.com/", "welcomeResponse");
    private final static QName _Welcome_QNAME = new QName("http://welcomesoap.deitel.com/", "welcome");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deitel.welcomesoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WelcomeResponse }
     * 
     */
    public WelcomeResponse createWelcomeResponse() {
        return new WelcomeResponse();
    }

    /**
     * Create an instance of {@link Welcome }
     * 
     */
    public Welcome createWelcome() {
        return new Welcome();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WelcomeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://welcomesoap.deitel.com/", name = "welcomeResponse")
    public JAXBElement<WelcomeResponse> createWelcomeResponse(WelcomeResponse value) {
        return new JAXBElement<WelcomeResponse>(_WelcomeResponse_QNAME, WelcomeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Welcome }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://welcomesoap.deitel.com/", name = "welcome")
    public JAXBElement<Welcome> createWelcome(Welcome value) {
        return new JAXBElement<Welcome>(_Welcome_QNAME, Welcome.class, null, value);
    }

}
