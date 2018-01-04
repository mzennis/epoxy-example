package id.mzennis.epoxyexample.presentation.view.viewmodel;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import id.mzennis.epoxyexample.R;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationProductViewModel;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationViewModel;
import id.mzennis.epoxyexample.presentation.view.viewmodel.base.SimpleHeadViewModel_;
import id.mzennis.epoxyexample.presentation.view.viewmodel.base.SimpleProductViewModel_;

/**
 * Created by meyta on 04/01/18.
 */
public class InspirationGroupViewModel extends EpoxyModelGroup {

    public InspirationGroupViewModel(int layoutRes, Collection<? extends EpoxyModel<?>> models) {
        super(layoutRes, models);
    }

    public InspirationGroupViewModel(InspirationViewModel modelData) {
        super(R.layout.viewmodel_simplegroup, buildModels(modelData));
    }

    private static List<EpoxyModel<?>> buildModels(InspirationViewModel modelData) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();

        // add title
        models.add(new SimpleHeadViewModel_().title(modelData.getTitle()));

        //List<SimpleProductViewModel_> productViewModels = new ArrayList<>();
        for (InspirationProductViewModel dataProduct : modelData.getListProduct()) {
            models.add(new SimpleProductViewModel_()
                    .id(dataProduct.getProductId())
                    .title(dataProduct.getName())
                    .price(dataProduct.getPrice()));
        }

        return models;
    }
}
