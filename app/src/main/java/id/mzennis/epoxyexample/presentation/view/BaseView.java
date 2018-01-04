package id.mzennis.epoxyexample.presentation.view;

import android.content.Context;

/**
 * Created by meyta on 12/12/17.
 */

public interface BaseView {

    void showError(String message);

    Context context();
}
