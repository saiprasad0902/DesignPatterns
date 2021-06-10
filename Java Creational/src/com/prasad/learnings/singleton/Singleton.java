package src.com.prasad.learnings.singleton;

public class Singleton {
    //  1. eagerly loaded and not thread safe,  we are creating the instance even if we not using it
    // private static Dbsingleton instance = new Dbsingleton();

    // 2. to make it lazy load but still not thread safe
    // private static Dbsingleton instance = null;

    // 3. to make it thread safe use volatile
    private static volatile Singleton instance = null;



     // not letting people use new keyword to create new instance
     private Singleton(){
         // protection from reflection class creating an object
         if(instance != null){
             throw new RuntimeException("Use getInstance() method to create");
         }
     }

    // to grab the instance back
    public static Singleton getInstance(){
         // return  instance [impl 1];

          /* [impl 2 ] if(instance == null){
                instance = new Dbsingleton();
            }
            return instance;*/

        if(instance == null){
            synchronized (Singleton.class){
                 if(instance == null){
                     instance = new Singleton();
                 }
            }
        }
        return instance;
    }
}
