package src.com.prasad.learnings.factrotymethod;

public class Shop extends Website{

    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new ItemPage());
        pages.add(new SearchPage());
    }
}
