package id.mzennis.epoxyexample.presentation.view.viewmodel.base;

import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import id.mzennis.epoxyexample.R;

/**
 * Created by meyta on 04/01/18.
 */

@EpoxyModelClass(layout = R.layout.viewmodel_simpleproduct)
public abstract class SimpleProductViewModel extends EpoxyModelWithHolder<SimpleProductViewModel.Holder> {

    @EpoxyAttribute String urlImg;
    @EpoxyAttribute String title;
    @EpoxyAttribute String price;

    @Override
    public void bind(Holder holder) {
        super.bind(holder);
        holder.tvTitle.setText(title);
        holder.tvPrice.setText(price);
    }

    class Holder extends BaseEpoxyHolder {

        @BindView(R.id.img_product) ImageView imgProduct;
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_price) TextView tvPrice;

    }
}
