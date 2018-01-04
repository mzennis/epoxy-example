package id.mzennis.epoxyexample.data.repository;

import id.mzennis.epoxyexample.presentation.view.model.FeedPresentation;
import io.reactivex.Observable;

/**
 * Created by meyta on 03/01/18.
 */

public interface FeedRepository {
    Observable<FeedPresentation> getFirstPageFeedsFromCloud(String id);
}
