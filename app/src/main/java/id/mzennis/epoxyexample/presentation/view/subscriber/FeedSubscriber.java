package id.mzennis.epoxyexample.presentation.view.subscriber;

import java.util.ArrayList;
import java.util.List;

import id.mzennis.epoxyexample.domain.exception.DefaultErrorBundle;
import id.mzennis.epoxyexample.domain.exception.ErrorBundle;
import id.mzennis.epoxyexample.domain.interactor.DefaultObserver;
import id.mzennis.epoxyexample.domain.model.InspirationItemDomain;
import id.mzennis.epoxyexample.domain.model.feed.DataFeedDomain;
import id.mzennis.epoxyexample.domain.model.feed.FeedDomain;
import id.mzennis.epoxyexample.presentation.exception.ErrorMessageFactory;
import id.mzennis.epoxyexample.presentation.view.FeedView;
import id.mzennis.epoxyexample.presentation.view.model.FeedModel;
import id.mzennis.epoxyexample.presentation.view.model.FeedPresentation;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationModel;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationProductModel;

/**
 * Created by meyta on 05/01/18.
 */

public class FeedSubscriber extends DefaultObserver<FeedPresentation, FeedView> {

    public FeedSubscriber(FeedView view) {
        super(view);
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(this.view.context(),
                errorBundle.getException());
        this.view.showError(errorMessage);
    }

    @Override
    public void onComplete() {
        view.hideLoading();
    }

    @Override
    public void onNext(FeedPresentation feed) {

        FeedDomain feedDomain = feed.getFeedDomain();
        ArrayList<FeedModel> listFeedView = new ArrayList<>();

        if (hasFeed(feedDomain)) {
            addFeedData(listFeedView, feedDomain.getListFeed());
        }

        view.showFeedCollection(listFeedView);
    }

    @Override
    public void onError(Throwable e) {
        view.hideLoading();
        showErrorMessage(new DefaultErrorBundle((Exception) e));
        view.showRetry();
    }

    private boolean hasFeed(FeedDomain feedDomain) {
        return feedDomain.getListFeed() != null
                && !feedDomain.getListFeed().isEmpty()
                && feedDomain.getListFeed().get(0) != null
                && feedDomain.getListFeed().get(0).getContent() != null
                && feedDomain.getListFeed().get(0).getContent().getType() != null;
    }

    private void addFeedData(ArrayList<FeedModel> listFeedView, List<DataFeedDomain> listFeedDomain) {
        if (listFeedDomain != null)
            for (DataFeedDomain domain : listFeedDomain) {
                switch (domain.getContent().getType() != null ? domain.getContent().getType() : "") {
                    case FeedModel.TYPE_INSPIRATION:
                        InspirationModel inspirationModel = convertToInspirationModel(domain);
                        if (inspirationModel != null
                                && inspirationModel.getListProduct() != null
                                && !inspirationModel.getListProduct().isEmpty())
                            listFeedView.add(inspirationModel);
                        break;
                    default:
                        break;
                }
            }
    }

    private InspirationModel convertToInspirationModel(DataFeedDomain domain) {
        if (domain.getContent() != null
                && domain.getContent().getInspirationDomains() != null
                && !domain.getContent().getInspirationDomains().isEmpty()) {
            return new InspirationModel(
                    domain.getContent().getInspirationDomains().get(0).getTitle(),
                    convertToRecommendationListModel(domain.getContent()
                            .getInspirationDomains().get(0).getListInspirationItem()));
        } else {
            return null;
        }
    }

    private ArrayList<InspirationProductModel> convertToRecommendationListModel(
            List<InspirationItemDomain> domains) {
        ArrayList<InspirationProductModel> listRecommendation = new ArrayList<>();
        if (domains != null && domains.size() == 4)
            for (InspirationItemDomain recommendationDomain : domains) {
                listRecommendation.add(convertToRecommendationViewModel(recommendationDomain));
            }
        return listRecommendation;
    }

    private InspirationProductModel convertToRecommendationViewModel(
            InspirationItemDomain recommendationDomain) {
        return new InspirationProductModel(recommendationDomain.getId(),
                recommendationDomain.getName(),
                recommendationDomain.getPrice(),
                recommendationDomain.getImageUrl(),
                recommendationDomain.getUrl(),
                1);
    }
}
