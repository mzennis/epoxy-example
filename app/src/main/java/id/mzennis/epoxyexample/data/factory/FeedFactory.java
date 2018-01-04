package id.mzennis.epoxyexample.data.factory;

import android.content.Context;

import id.mzennis.epoxyexample.data.mapper.FeedMapper;
import id.mzennis.epoxyexample.data.network.ApiService;
import id.mzennis.epoxyexample.data.source.CloudFirstFeedDataSource;

/**
 * Created by meyta on 03/01/18.
 */

public class FeedFactory {

    private ApiService apiService;
    private FeedMapper feedMapper;

    public FeedFactory(Context context,
                       ApiService apiService,
                       FeedMapper feedMapper) {

        this.apiService = apiService;
        this.feedMapper = feedMapper;
    }

    public CloudFirstFeedDataSource createCloudFirstFeedDataSource() {
        return new CloudFirstFeedDataSource(
                apiService,
                feedMapper);
    }
}
