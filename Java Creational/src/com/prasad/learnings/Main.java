package src.com.prasad.learnings;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import src.com.prasad.learnings.abstractfactory.CardType;
import src.com.prasad.learnings.abstractfactory.CreditCard;
import src.com.prasad.learnings.abstractfactory.CreditCardFactory;
import src.com.prasad.learnings.builder.FoodBuilder;
import src.com.prasad.learnings.factrotymethod.Website;
import src.com.prasad.learnings.factrotymethod.WebsiteFactory;
import src.com.prasad.learnings.factrotymethod.WebsiteType;
import src.com.prasad.learnings.prototype.Movie;
import src.com.prasad.learnings.prototype.PrototypeRegistry;
import src.com.prasad.learnings.singleton.Singleton;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;

class MainCreational {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    // Singletone example using JAVA API
	Runtime runtimeObj1 = Runtime.getRuntime();
	System.out.println(runtimeObj1);
    Runtime runtimeObj2 = Runtime.getRuntime();
    System.out.println(runtimeObj2);

    // Builder example using JAVA API

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Great");
    stringBuilder.append("builder");
    stringBuilder.append(42);
    System.out.println(stringBuilder.toString());

    // Factory Method : Using Java API

    Calendar cal =  Calendar.getInstance();
    System.out.println(cal);
    System.out.println(cal.get(Calendar.DAY_OF_MONTH));

    // Abstract Factory Java API [DocumentBuilderFactory]
        String xml = "<document> <body> <stock> AAPL  </stock> </body> </document>";
        ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(bais);

        document.getDocumentElement().normalize();
        System.out.println("Root element" + document.getDocumentElement().getNodeName());
        System.out.println(documentBuilderFactory.getClass());
        System.out.println(documentBuilder.getClass());



    /* Our custom implementation  the singleton pattern
    is a software design pattern that restricts the instantiation of a class
    to one "single" instance. This is useful when exactly one object is needed to coordinate actions
    across the system.*/

    Singleton singleton = Singleton.getInstance();
    Singleton singleton1 = Singleton.getInstance();
    // this will not work as its private constructor
    // Singleton test = new Singleton();
    System.out.println(singleton.equals(singleton1));
    //System.out.println(singleton);


    // Builder pattern
    /*
    * Builder pattern aims to “Separate the construction of a complex object from its representation so
    * that the same construction process can create different representations.” It is used to construct
    * a complex object step by step and the final step will return the object.
    * */

    FoodBuilder.Builder builder = new FoodBuilder.Builder();
    builder.bread("wheat").vegies("Tomato").sauce("");
    FoodBuilder foodBuilder = builder.build();

    System.out.println(foodBuilder.getBread());
    System.out.println(foodBuilder.getSauce());
    System.out.println(foodBuilder.getVegies());

    // Prototype pattern
        /**
         * The prototype design pattern enables you to create a new instance of a class from an existing instance.
         * You can take advantage of this design pattern to create a clone of an object when the object creation
         * process itself is a costly affair
         */

        PrototypeRegistry prototypeRegistry = new PrototypeRegistry();
        // Unique instance will ge give back for the movie
        Movie movie = (Movie) prototypeRegistry.createItem("Movie");
        movie.setTitle("Prototype pattern java");

        System.out.println(movie);
        System.out.println(movie.getRunTime());
        System.out.println(movie.getPrice());
        System.out.println(movie.getTitle());

        Movie anotherMovie = (Movie) prototypeRegistry.createItem("Movie");
        anotherMovie.setTitle("Gang of four");
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRunTime());
        System.out.println(anotherMovie.getPrice());
        System.out.println(anotherMovie.getTitle());

      // Factory Method Demo
        /**
         * that uses factory methods to deal with the problem of creating objects without having
         * to specify the exact class of the object that will be created
         */

        Website website = WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(website.getPages());

        website = WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println(website.getPages());


        // Abstract Factory demo
        CreditCardFactory abstractFactory = CreditCardFactory.getCreditCardFactory(651);
        CreditCard card = abstractFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(card.getClass());

        abstractFactory = CreditCardFactory.getCreditCardFactory(600);
        CreditCard card2 = abstractFactory.getCreditCard(CardType.GOLD);
        System.out.println(card2.getClass());
    }
}
