package id.mzennis.epoxyexample.presentation.view.model;

import android.support.annotation.CallSuper;
import android.view.View;

import com.airbnb.epoxy.EpoxyHolder;

import butterknife.ButterKnife;

/**
 * Created by meyta on 03/01/18.
 */

public class BaseEpoxyHolder extends EpoxyHolder {

    @CallSuper
    @Override
    protected void bindView(View itemView) {
        ButterKnife.bind(this, itemView);
    }
}
