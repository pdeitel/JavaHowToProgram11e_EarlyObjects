
package com.deitel.reservation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deitel.reservation package. 
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

    private final static QName _Reserve_QNAME = new QName("http://reservation.deitel.com/", "reserve");
    private final static QName _ReserveResponse_QNAME = new QName("http://reservation.deitel.com/", "reserveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deitel.reservation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveResponse }
     * 
     */
    public ReserveResponse createReserveResponse() {
        return new ReserveResponse();
    }

    /**
     * Create an instance of {@link Reserve }
     * 
     */
    public Reserve createReserve() {
        return new Reserve();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserve }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reservation.deitel.com/", name = "reserve")
    public JAXBElement<Reserve> createReserve(Reserve value) {
        return new JAXBElement<Reserve>(_Reserve_QNAME, Reserve.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://reservation.deitel.com/", name = "reserveResponse")
    public JAXBElement<ReserveResponse> createReserveResponse(ReserveResponse value) {
        return new JAXBElement<ReserveResponse>(_ReserveResponse_QNAME, ReserveResponse.class, null, value);
    }

}
