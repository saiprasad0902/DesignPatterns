package src.com.prasad.learnings.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    /*
    * Used to get the unique instance of the same object
    * Concepts
    * Avoids costly creation
    * Avoids subclassing
    * Typically doesnt use 'new'
    * Often utilizes an interface
    * Usually implemented with a Registry
    * API : java.lang.Object#clone()
    */
 private Map<String,Item > itemMap = new HashMap<String, Item>();

 public PrototypeRegistry(){
     loadItems();
 }

 public Item createItem(String type){
     // core prototype logic goes here
     Item item = null;
 try{
     item = (Item) (itemMap.get(type).clone());
 }catch (CloneNotSupportedException e){
     e.printStackTrace();
 }
     return item;
 }

    private void loadItems() {
     Movie movie = new Movie();
     movie.setTitle("Title");
     movie.setRunTime("100");
     movie.setPrice(22.44);
     itemMap.put("Movie", movie);

     Book book = new Book();
     book.setNumberOfPages(100);
     book.setPrice(100.32);
     book.setTitle("Book awesome");
     itemMap.put("Book", book);
    }


}
