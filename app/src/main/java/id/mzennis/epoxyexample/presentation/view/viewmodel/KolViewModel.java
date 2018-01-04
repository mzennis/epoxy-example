package id.mzennis.epoxyexample.presentation.view.viewmodel;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.epoxy.EpoxyAttribute;
import com.airbnb.epoxy.EpoxyModelClass;
import com.airbnb.epoxy.EpoxyModelWithHolder;

import butterknife.BindView;
import id.mzennis.epoxyexample.R;
import id.mzennis.epoxyexample.presentation.view.viewmodel.base.BaseEpoxyHolder;

/**
 * Created by meyta on 04/01/18.
 */

@EpoxyModelClass(layout = R.layout.viewmodel_kol)
public abstract class KolViewModel extends EpoxyModelWithHolder<KolViewModel.Holder> {

    @EpoxyAttribute String urlImageAvatar;
    @EpoxyAttribute String urlImageKol;

    @EpoxyAttribute String name;
    @EpoxyAttribute String job;

    @EpoxyAttribute String kol;

    @EpoxyAttribute View.OnClickListener likeClickListener;
    @EpoxyAttribute View.OnClickListener commentClickListener;

    @Override
    public void bind(KolViewModel.Holder holder) {
        super.bind(holder);

        holder.tvName.setText(name);
        holder.tvJob.setText(job);

        holder.tvKol.setText(kol);

        holder.tvLike.setOnClickListener(likeClickListener);
        holder.tvComment.setOnClickListener(commentClickListener);
    }

    static class Holder extends BaseEpoxyHolder {
        @BindView(R.id.img_avatar) ImageView imgAvatar;
        @BindView(R.id.tv_name) TextView tvName;
        @BindView(R.id.tv_job) TextView tvJob;

        @BindView(R.id.img_kol) ImageView imgKol;
        @BindView(R.id.tv_kol) TextView tvKol;

        @BindView(R.id.tv_like) TextView tvLike;
        @BindView(R.id.tv_comment) TextView tvComment;
    }
}
