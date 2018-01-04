package id.mzennis.epoxyexample.data.repository;

import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import io.reactivex.Observable;

/**
 * Created by meyta on 03/01/18.
 */

public interface FeedRepository {
    Observable<FeedDomain> getFirstPageFeedsFromCloud(String id);
}
