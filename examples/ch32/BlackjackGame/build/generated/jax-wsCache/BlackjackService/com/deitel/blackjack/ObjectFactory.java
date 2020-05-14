
package com.deitel.blackjack;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deitel.blackjack package. 
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

    private final static QName _GetHandValue_QNAME = new QName("http://blackjack.deitel.com/", "getHandValue");
    private final static QName _DealCardResponse_QNAME = new QName("http://blackjack.deitel.com/", "dealCardResponse");
    private final static QName _DealCard_QNAME = new QName("http://blackjack.deitel.com/", "dealCard");
    private final static QName _Shuffle_QNAME = new QName("http://blackjack.deitel.com/", "shuffle");
    private final static QName _GetHandValueResponse_QNAME = new QName("http://blackjack.deitel.com/", "getHandValueResponse");
    private final static QName _ShuffleResponse_QNAME = new QName("http://blackjack.deitel.com/", "shuffleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deitel.blackjack
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetHandValue }
     * 
     */
    public GetHandValue createGetHandValue() {
        return new GetHandValue();
    }

    /**
     * Create an instance of {@link GetHandValueResponse }
     * 
     */
    public GetHandValueResponse createGetHandValueResponse() {
        return new GetHandValueResponse();
    }

    /**
     * Create an instance of {@link ShuffleResponse }
     * 
     */
    public ShuffleResponse createShuffleResponse() {
        return new ShuffleResponse();
    }

    /**
     * Create an instance of {@link Shuffle }
     * 
     */
    public Shuffle createShuffle() {
        return new Shuffle();
    }

    /**
     * Create an instance of {@link DealCard }
     * 
     */
    public DealCard createDealCard() {
        return new DealCard();
    }

    /**
     * Create an instance of {@link DealCardResponse }
     * 
     */
    public DealCardResponse createDealCardResponse() {
        return new DealCardResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHandValue }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "getHandValue")
    public JAXBElement<GetHandValue> createGetHandValue(GetHandValue value) {
        return new JAXBElement<GetHandValue>(_GetHandValue_QNAME, GetHandValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DealCardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "dealCardResponse")
    public JAXBElement<DealCardResponse> createDealCardResponse(DealCardResponse value) {
        return new JAXBElement<DealCardResponse>(_DealCardResponse_QNAME, DealCardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DealCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "dealCard")
    public JAXBElement<DealCard> createDealCard(DealCard value) {
        return new JAXBElement<DealCard>(_DealCard_QNAME, DealCard.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Shuffle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "shuffle")
    public JAXBElement<Shuffle> createShuffle(Shuffle value) {
        return new JAXBElement<Shuffle>(_Shuffle_QNAME, Shuffle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetHandValueResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "getHandValueResponse")
    public JAXBElement<GetHandValueResponse> createGetHandValueResponse(GetHandValueResponse value) {
        return new JAXBElement<GetHandValueResponse>(_GetHandValueResponse_QNAME, GetHandValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShuffleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://blackjack.deitel.com/", name = "shuffleResponse")
    public JAXBElement<ShuffleResponse> createShuffleResponse(ShuffleResponse value) {
        return new JAXBElement<ShuffleResponse>(_ShuffleResponse_QNAME, ShuffleResponse.class, null, value);
    }

}
