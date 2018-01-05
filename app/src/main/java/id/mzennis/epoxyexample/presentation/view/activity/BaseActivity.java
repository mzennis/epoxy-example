package id.mzennis.epoxyexample.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import id.mzennis.epoxyexample.presentation.MainApplication;
import id.mzennis.epoxyexample.presentation.config.components.ActivityComponent;
import id.mzennis.epoxyexample.presentation.config.components.ApplicationComponent;
import id.mzennis.epoxyexample.presentation.config.components.DaggerActivityComponent;
import id.mzennis.epoxyexample.presentation.config.modules.ActivityModule;

/**
 * Created by meyta on 05/01/18.
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.initializeInjector();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MainApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
