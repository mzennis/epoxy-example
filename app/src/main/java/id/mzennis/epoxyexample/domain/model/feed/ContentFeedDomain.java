package id.mzennis.epoxyexample.domain.model.feed;

import java.util.List;

import javax.annotation.Nullable;

import id.mzennis.epoxyexample.domain.model.TopPicksDomain;
import id.mzennis.epoxyexample.domain.model.officialstore.OfficialStoreDomain;

/**
 * @author ricoharisin .
 */

public class ContentFeedDomain {

    @Nullable
    private final
    String type;

    @Nullable
    private final
    int total_product;

    @Nullable
    private final
    List<ProductFeedDomain> products;

    @Nullable
    private final
    List<PromotionFeedDomain> promotions;

    @Nullable
    private final
    String status_activity;

    @Nullable
    private final List<OfficialStoreDomain> officialStores;

    @Nullable
    private final List<TopPicksDomain> topPicksDomains;

    @Nullable
    private final List<InspirationDomain> inspirationDomains;

    @Nullable
    private final KolPostDomain kolPostDomain;

    @Nullable
    private final KolRecommendationDomain kolRecommendations;

    @Nullable
    private final FavoriteCtaDomain favoriteCtaDomain;

    public ContentFeedDomain(@Nullable String type, @Nullable int total_product,
                             @Nullable List<ProductFeedDomain> products,
                             @Nullable List<PromotionFeedDomain> promotions,
                             @Nullable List<OfficialStoreDomain> officialStores,
                             @Nullable List<TopPicksDomain> topPicksDomains,
                             @Nullable List<InspirationDomain> inspirationDomains,
                             @Nullable KolPostDomain kolPostDomain,
                             @Nullable KolRecommendationDomain kolRecommendations,
                             @Nullable FavoriteCtaDomain favoriteCtaDomain,
                             @Nullable String status_activity) {
        this.type = type;
        this.total_product = total_product;
        this.products = products;
        this.promotions = promotions;
        this.status_activity = status_activity;
        this.topPicksDomains = topPicksDomains;
        this.officialStores = officialStores;
        this.inspirationDomains = inspirationDomains;
        this.kolPostDomain = kolPostDomain;
        this.kolRecommendations = kolRecommendations;
        this.favoriteCtaDomain = favoriteCtaDomain;
    }

    @Nullable
    public String getType() {
        return type;
    }

    @Nullable
    public int getTotalProduct() {
        return total_product;
    }

    @Nullable
    public List<ProductFeedDomain> getProducts() {
        return products;
    }

    @Nullable
    public List<PromotionFeedDomain> getPromotions() {
        return promotions;
    }

    @Nullable
    public String getStatusActivity() {
        return status_activity;
    }

    @Nullable
    public List<OfficialStoreDomain> getOfficialStores() {
        return officialStores;
    }

    @Nullable
    public List<TopPicksDomain> getTopPicksDomains() {
        return topPicksDomains;
    }

    @Nullable
    public List<InspirationDomain> getInspirationDomains() {
        return inspirationDomains;
    }

    @Nullable
    public KolPostDomain getKolPostDomain() {
        return kolPostDomain;
    }

    @Nullable
    public KolRecommendationDomain getKolRecommendations() {
        return kolRecommendations;
    }

    @Nullable
    public FavoriteCtaDomain getFavoriteCtaDomain() {
        return favoriteCtaDomain;
    }
}
