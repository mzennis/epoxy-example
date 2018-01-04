package id.mzennis.epoxyexample.presentation.view.viewmodel.base;

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

    @EpoxyAttribute String title;
    @EpoxyAttribute String expand;

    @EpoxyAttribute View.OnClickListener clickListener;

    @Override
    public void bind(Holder holder) {
        super.bind(holder);
        holder.tvTitle.setText(title);

        if (!expand.isEmpty()) holder.tvExpand.setText(expand);
        else holder.tvExpand.setVisibility(View.GONE);

        if (clickListener != null)
            holder.tvExpand.setOnClickListener(clickListener);
    }

    static class Holder extends BaseEpoxyHolder {
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_expand) TextView tvExpand;
    }
}