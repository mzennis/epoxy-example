package id.mzennis.epoxyexample.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by meyta on 03/01/18.
 */

public interface PostExecutionThread {
    Scheduler getScheduler();
}