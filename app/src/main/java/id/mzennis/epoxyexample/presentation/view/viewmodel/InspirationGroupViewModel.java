package id.mzennis.epoxyexample.presentation.view.viewmodel;

import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyModelGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import id.mzennis.epoxyexample.R;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationProductModel;
import id.mzennis.epoxyexample.presentation.view.model.inspiration.InspirationModel;
import id.mzennis.epoxyexample.presentation.view.viewmodel.base.SimpleHeadViewModel_;
import id.mzennis.epoxyexample.presentation.view.viewmodel.base.SimpleProductViewModel_;
import id.mzennis.epoxyexample.presentation.view.viewmodel.view.GridViewModel_;

/**
 * Created by meyta on 04/01/18.
 */
public class InspirationGroupViewModel extends EpoxyModelGroup {

    public InspirationGroupViewModel(int layoutRes, Collection<? extends EpoxyModel<?>> models) {
        super(layoutRes, models);
    }

    public InspirationGroupViewModel(InspirationModel modelData) {
        super(R.layout.viewmodel_simplegroup, buildModels(modelData));
    }

    private static List<EpoxyModel<?>> buildModels(InspirationModel modelData) {
        ArrayList<EpoxyModel<?>> models = new ArrayList<>();

        // add title
        models.add(new SimpleHeadViewModel_().title(modelData.getTitle()));

        List<SimpleProductViewModel_> productViewModels = new ArrayList<>();
        for (InspirationProductModel dataProduct : modelData.getListProduct()) {
            productViewModels.add(new SimpleProductViewModel_()
                    .id(dataProduct.getProductId())
                    .title(dataProduct.getName())
                    .price(dataProduct.getPrice()));
        }

        models.add(new GridViewModel_()
        .id("InspirationData")
        .models(productViewModels));

        return models;
    }

    @Override
    public int getSpanSize(int totalSpanCount, int position, int itemCount) {
        return totalSpanCount;
    }
}
