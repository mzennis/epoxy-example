package id.mzennis.epoxyexample.presentation.view.model.inspiration;

/**
 * @author by nisie on 6/21/17.
 */

public class InspirationProductModel {

    private String productId;
    private String name;
    private String price;
    private String imageSource;
    private String url;
    private int page;

    public InspirationProductModel(String productId, String name, String price, String
            imageSource, String url, int page) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.imageSource = imageSource;
        this.url = url;
        this.page = page;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageSource() {
        return imageSource;
    }

    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPage() {
        return page;
    }
}
