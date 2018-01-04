package id.mzennis.epoxyexample.presentation.view.viewmodel;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;

import java.util.Collection;
import java.util.List;

/**
 * Created by meyta on 04/01/18.
 */

public class RecentGroupViewModel extends EpoxyModelGroup {

    public RecentGroupViewModel(int layoutRes, Collection<? extends EpoxyModel<?>> models) {
        super(layoutRes, models);
    }

    private List<EpoxyModel> buildModels() {
        return null;
    }
}
