package id.mzennis.epoxyexample.presentation.view.model;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import id.mzennis.epoxyexample.R;

/**
 * Created by meyta on 03/01/18.
 */

@EpoxyModelClass(layout = R.layout.viewmodel_recentproduct)
public abstract class RecentProductViewModel extends EpoxyModelWithHolder<RecentProductViewModel.Holder> {

    @EpoxyAttribute String title;
    @EpoxyAttribute String price;
    @EpoxyAttribute String store;

    @EpoxyAttribute View.OnClickListener clickListener;

    @Override
    public void bind(Holder holder) {
        super.bind(holder);
        holder.tvTitle.setText(title);
        holder.tvPrice.setText(price);
        holder.tvStore.setText(store);
        holder.layoutRecentProduct.setOnClickListener(clickListener);
    }

    static class Holder extends BaseEpoxyHolder {
        @BindView(R.id.tv_title_product) TextView tvTitle;
        @BindView(R.id.tv_price_product) TextView tvPrice;
        @BindView(R.id.tv_store_product) TextView tvStore;
        @BindView(R.id.layout_recentproduct) LinearLayout layoutRecentProduct;
    }
}
