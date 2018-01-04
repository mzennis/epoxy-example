package id.mzennis.epoxyexample.data.repository;

import id.mzennis.epoxyexample.data.factory.FeedFactory;
import id.mzennis.epoxyexample.data.mapper.FeedPresentationMapper;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import id.mzennis.epoxyexample.presentation.view.model.FeedPresentation;
import io.reactivex.Observable;

/**
 * Created by meyta on 03/01/18.
 */

public class FeedRepositoryImpl implements FeedRepository {

    private FeedFactory feedFactory;
    private FeedPresentationMapper feedPresentationMapper;

    public FeedRepositoryImpl(FeedFactory feedFactory, FeedPresentationMapper feedPresentationMapper) {
        this.feedFactory = feedFactory;
        this.feedPresentationMapper = feedPresentationMapper;
    }

    @Override
    public Observable<FeedPresentation> getFirstPageFeedsFromCloud(String id) {
        return feedFactory
                .createCloudFirstFeedDataSource()
                .getFirstPageFeedsList(id)
                .map(feedPresentationMapper);
    }
}
