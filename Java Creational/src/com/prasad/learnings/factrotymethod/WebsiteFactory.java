package src.com.prasad.learnings.factrotymethod;

public class WebsiteFactory {
    public static Website getWebsite(WebsiteType siteType) {
        switch (siteType) {
            case BLOG: {
                return new Blog();
            }
            case SHOP: {
                return new Shop();
            }
            default:{
                return null;
            }
        }
    }
}
