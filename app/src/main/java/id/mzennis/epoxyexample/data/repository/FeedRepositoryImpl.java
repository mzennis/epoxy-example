package id.mzennis.epoxyexample.data.repository;

import id.mzennis.epoxyexample.data.factory.FeedFactory;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import io.reactivex.Observable;

/**
 * Created by meyta on 03/01/18.
 */

public class FeedRepositoryImpl implements FeedRepository {

    private FeedFactory feedFactory;

    public FeedRepositoryImpl(FeedFactory feedFactory) {
        this.feedFactory = feedFactory;
    }

    @Override
    public Observable<FeedDomain> getFirstPageFeedsFromCloud(String id) {
        return feedFactory.createCloudFirstFeedDataSource().getFirstPageFeedsList(id);
    }
}
