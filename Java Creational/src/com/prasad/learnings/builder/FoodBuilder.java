package src.com.prasad.learnings.builder;

public class FoodBuilder {
    /*
    * Flexibility over telescoping constructors
    * Static inner class
    * calls appropriate constructors
    * negates the need for exposed setters
    * can take advantage of generics
    * API example string builder
    *
    * Builder handles complex constructors
    * No interface required
    * Can be a separate class
    * Works with legacy code
    *
    * */

    private String bread;
    private String vegies;
    private String sauce;

    public FoodBuilder(Builder builder) {
        this.bread = builder.bread;
        this.vegies = builder.vegies;
        this.sauce = builder.sauce;
    }

    public static class Builder{
        private String bread;
        private String vegies;
        private String sauce;

        public Builder(){}

        public FoodBuilder build(){
            return new FoodBuilder(this);

        }

        public Builder bread(String bread){
            this.bread = bread;
            return this;
        }
        public Builder vegies(String vegies){
            this.vegies = vegies;
            return this;
        }
        public Builder sauce(String sauce){
            this.sauce = sauce;
            return this;
        }

    }

    public String getBread() {
        return bread;
    }

    public String getVegies() {
        return vegies;
    }

    public String getSauce() {
        return sauce;
    }


}
