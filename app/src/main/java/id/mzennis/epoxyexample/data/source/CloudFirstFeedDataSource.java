package id.mzennis.epoxyexample.data.source;

import id.mzennis.epoxyexample.data.mapper.FeedMapper;
import id.mzennis.epoxyexample.data.network.ApiService;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import io.reactivex.Observable;

/**
 * @author by nisie on 7/3/17.
 */

public class CloudFirstFeedDataSource {

    private ApiService apiService;
    private FeedMapper mapper;

    public CloudFirstFeedDataSource(ApiService apiService, FeedMapper mapper) {

        this.apiService = apiService;
        this.mapper = mapper;
    }

    public Observable<FeedDomain> getFirstPageFeedsList(String id) {
        return apiService.getApi().getFeed(id).map(mapper);
    }
}
