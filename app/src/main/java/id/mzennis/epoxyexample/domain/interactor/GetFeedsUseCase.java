package id.mzennis.epoxyexample.domain.interactor;


import id.mzennis.epoxyexample.data.repository.FeedRepository;
import id.mzennis.epoxyexample.domain.executor.PostExecutionThread;
import id.mzennis.epoxyexample.domain.executor.ThreadExecutor;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import io.reactivex.Observable;

/**
 * @author ricoharisin .
 */

public class GetFeedsUseCase extends UseCase<FeedDomain, String> {

    protected FeedRepository feedRepository;

    public GetFeedsUseCase(ThreadExecutor threadExecutor,
                           PostExecutionThread postExecutionThread,
                           FeedRepository feedRepository) {
        super(threadExecutor, postExecutionThread);
        this.feedRepository = feedRepository;
    }

    @Override
    Observable<FeedDomain> buildUseCaseObservable(String s) {
        return feedRepository.getFirstPageFeedsFromCloud(s);
    }
}
