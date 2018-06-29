
package packt.jee.eclipse.ws.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the packt.jee.eclipse.ws.soap.client package. 
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

    private final static QName _Courses_QNAME = new QName("http://soap.ws.eclipse.jee.packt/", "courses");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: packt.jee.eclipse.ws.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Courses }
     * 
     */
    public Courses createCourses() {
        return new Courses();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Courses }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.ws.eclipse.jee.packt/", name = "courses")
    public JAXBElement<Courses> createCourses(Courses value) {
        return new JAXBElement<Courses>(_Courses_QNAME, Courses.class, null, value);
    }

}
