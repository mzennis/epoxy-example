package id.mzennis.epoxyexample.presentation.view.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.epoxy.EpoxyRecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.mzennis.epoxyexample.R;
import id.mzennis.epoxyexample.presentation.MainApplication;
import id.mzennis.epoxyexample.presentation.config.components.ActivityComponent;
import id.mzennis.epoxyexample.presentation.config.components.ApplicationComponent;
import id.mzennis.epoxyexample.presentation.config.components.DaggerActivityComponent;
import id.mzennis.epoxyexample.presentation.config.modules.ActivityModule;
import id.mzennis.epoxyexample.presentation.view.FeedView;
import id.mzennis.epoxyexample.presentation.view.presenter.FeedPresenter;

public class MainActivity extends AppCompatActivity implements FeedView {

    @BindView(R.id.recycler_view) EpoxyRecyclerView recyclerView;

    @Inject FeedPresenter presenter;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        this.initializeInjector();

        presenter.getSearchResult("1");


    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

        this.activityComponent.inject(this);
    }

    @Override
    public void showError(String message) {
        Log.e(this.getClass().getSimpleName(), message);
    }

    @Override
    public Context context() {
        return this;
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
