package id.mzennis.epoxyexample.presentation.config.components;

import android.app.Activity;

import dagger.Component;
import id.mzennis.epoxyexample.presentation.config.ActivityScope;
import id.mzennis.epoxyexample.presentation.config.modules.ActivityModule;
import id.mzennis.epoxyexample.presentation.view.activity.BaseActivity;
import id.mzennis.epoxyexample.presentation.view.activity.MainActivity;

/**
 * Created by meyta on 13/12/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity mainActivity);
    void inject(MainActivity mainActivity);

    Activity activity();
}
