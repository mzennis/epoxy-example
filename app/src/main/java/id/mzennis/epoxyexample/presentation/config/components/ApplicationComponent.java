package id.mzennis.epoxyexample.presentation.config.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import id.mzennis.epoxyexample.data.network.ApiService;
import id.mzennis.epoxyexample.domain.executor.PostExecutionThread;
import id.mzennis.epoxyexample.domain.executor.ThreadExecutor;
import id.mzennis.epoxyexample.presentation.config.modules.ApplicationModule;

/**
 * Created by meyta on 13/12/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
    ApiService apiService();
}
