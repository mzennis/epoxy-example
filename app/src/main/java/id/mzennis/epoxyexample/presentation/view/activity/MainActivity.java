package id.mzennis.epoxyexample.presentation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.epoxy.EpoxyRecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import id.mzennis.epoxyexample.R;
import id.mzennis.epoxyexample.presentation.view.FeedView;
import id.mzennis.epoxyexample.presentation.view.controller.FeedController;
import id.mzennis.epoxyexample.presentation.view.model.FeedModel;
import id.mzennis.epoxyexample.presentation.view.presenter.FeedPresenter;

public class MainActivity extends BaseActivity implements FeedView {

    @BindView(R.id.recycler_view) EpoxyRecyclerView recyclerView;

    @Inject FeedPresenter presenter;
    @Inject FeedController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getActivityComponent().inject(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setController(controller);

        this.presenter.setView(this);

        this.presenter.loadFeed("3");
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRetry() {}

    @Override
    public void hideRetry() {}

    @Override
    public void showFeedCollection(ArrayList<FeedModel> feedModels) {
        controller.setData(feedModels);
    }

    @Override
    public Context context() {
        return this;
    }
}
