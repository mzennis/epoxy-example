package id.mzennis.epoxyexample.presentation;

import android.app.Application;
import android.content.Context;

import id.mzennis.epoxyexample.presentation.config.components.ApplicationComponent;
import id.mzennis.epoxyexample.presentation.config.components.DaggerApplicationComponent;
import id.mzennis.epoxyexample.presentation.config.modules.ApplicationModule;

/**
 * Created by meyta on 03/01/18.
 */

public class MainApplication extends Application {


    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private MainApplication getApplication() {
        return this;
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
