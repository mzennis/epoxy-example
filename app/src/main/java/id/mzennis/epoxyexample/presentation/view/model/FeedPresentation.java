package id.mzennis.epoxyexample.presentation.view.model;

import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;

/**
 * Created by meyta on 04/01/18.
 */

public class FeedPresentation {

    private FeedDomain feedDomain;
    private int dataSource;
    public static final int SOURCE_LOCAL = 1;
    public static final int SOURCE_CLOUD = 2;
    private boolean hasNext;

    public FeedPresentation(FeedDomain feedDomain, int dataSource, boolean hasNext) {
        this.feedDomain = feedDomain;
        this.dataSource = dataSource;
        this.hasNext = hasNext;
    }

    public FeedDomain getFeedDomain() {
        return feedDomain;
    }

    public void setFeedDomain(FeedDomain feedDomain) {
        this.feedDomain = feedDomain;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}