package src.com.prasad.learnings;

import src.com.prasad.learnings.builder.FoodBuilder;
import src.com.prasad.learnings.prototype.Movie;
import src.com.prasad.learnings.prototype.PrototypeRegistry;
import src.com.prasad.learnings.singleton.Singleton;

class MainCreational {

    public static void main(String[] args) {
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


    // Our custom implementation
    // Singleton
    Singleton singleton = Singleton.getInstance();
    Singleton singleton1 = Singleton.getInstance();
    // this will not work as its private constructor
    // Singleton test = new Singleton();
    System.out.println(singleton.equals(singleton1));
    //System.out.println(singleton);


    // Builder pattern
    FoodBuilder.Builder builder = new FoodBuilder.Builder();
    builder.bread("wheat").vegies("Tomato").sauce("");
    FoodBuilder foodBuilder = builder.build();

    System.out.println(foodBuilder.getBread());
    System.out.println(foodBuilder.getSauce());
    System.out.println(foodBuilder.getVegies());

    // Prototype pattern
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


    }
}
