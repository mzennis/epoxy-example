package id.mzennis.epoxyexample.domain.model;

/**
 * @author by nisie on 10/26/17.
 */

public class InspirationItemDomain {

    private final String id;

    private final String name;

    private final String url;

    private final String click_url;

    private final String app_url;

    private final String image_url;

    private final String price;

    private final String recommendationType;

    public InspirationItemDomain(String id, String name, String url,
                                 String click_url, String app_url, String image_url,
                                 String price, String recommendationType) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.click_url = click_url;
        this.app_url = app_url;
        this.image_url = image_url;
        this.price = price;
        this.recommendationType = recommendationType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getClickUrl() {
        return click_url;
    }

    public String getAppUrl() {
        return app_url;
    }

    public String getImageUrl() {
        return image_url;
    }

    public String getPrice() {
        return price;
    }

    public String getRecommendationType() {
        return recommendationType;
    }
}
