package id.mzennis.epoxyexample.presentation.view.model;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import id.mzennis.epoxyexample.R;

/**
 * Created by meyta on 03/01/18.
 */

@EpoxyModelClass(layout = R.layout.viewmodel_simplehead)
public abstract class SimpleHeadViewModel extends EpoxyModelWithHolder<SimpleHeadViewModel.Holder> {

    @EpoxyAttribute @StringRes int title;
    @EpoxyAttribute @StringRes int expand;

    @EpoxyAttribute View.OnClickListener clickListener;

    @Override
    public void bind(Holder holder) {
        super.bind(holder);
        holder.tvTitle.setText(title);
        holder.tvExpand.setText(expand);
        holder.tvExpand.setOnClickListener(clickListener);
    }

    static class Holder extends BaseEpoxyHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_expand) TextView tvExpand;
    }
}