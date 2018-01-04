package id.mzennis.epoxyexample.domain.model.feed;

import java.util.List;

import javax.annotation.Nullable;

import id.mzennis.epoxyexample.domain.model.recentview.RecentViewProductDomain;

/**
 * @author ricoharisin .
 */

public class FeedDomain {

    @Nullable
    private final List<DataFeedDomain> data;

    @Nullable
    private final boolean hasNext;

    @Nullable
    private List<RecentViewProductDomain> recentProduct;

    public FeedDomain(@Nullable List<DataFeedDomain> data,
                      boolean hasNext) {
        this.data = data;
        this.hasNext = hasNext;
    }

    @Nullable
    public List<DataFeedDomain> getListFeed() {
        return data;
    }

    public boolean isHasNext() {
        return hasNext;
    }

//    @Nullable
//    public List<DataInspirationDomain> getListInspiration() {
//        return listInspiration;
//    }

    public void setRecentProduct(@Nullable List<RecentViewProductDomain> recentProduct) {
        this.recentProduct = recentProduct;
    }

    @Nullable
    public List<RecentViewProductDomain> getRecentProduct() {
        return recentProduct;
    }
}
