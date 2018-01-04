package id.mzennis.epoxyexample.presentation.view.viewmodel.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.airbnb.epoxy.Carousel;
import com.airbnb.epoxy.ModelView;

/**
 * Created by meyta on 04/01/18.
 */


@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
public class GridView extends Carousel {

    private static final int SPAN_COUNT = 2;

    public GridView(Context context) {
        super(context);
    }

    @NonNull
    @Override
    protected LayoutManager createLayoutManager() {
        return new GridLayoutManager(getContext(), SPAN_COUNT, LinearLayoutManager.VERTICAL, false);
    }
}

