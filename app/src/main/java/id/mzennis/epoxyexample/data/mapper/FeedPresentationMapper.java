package id.mzennis.epoxyexample.data.mapper;

import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import id.mzennis.epoxyexample.presentation.view.model.FeedPresentation;
import io.reactivex.functions.Function;

/**
 * Created by meyta on 04/01/18.
 */

public class FeedPresentationMapper implements Function<FeedDomain, FeedPresentation> {

    private int dataSource;

    public FeedPresentationMapper(int dataSource) {
        this.dataSource = dataSource;
    }

    public FeedPresentationMapper() {
    }

    @Override
    public FeedPresentation apply(FeedDomain feedDomain) throws Exception {
        return new FeedPresentation(feedDomain, 2, feedDomain.isHasNext());
    }
}
