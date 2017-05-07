package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public class RecyclerGuokrNewsAdapter extends BaseQuickAdapter<GuokrNewsEntity, BaseViewHolder> {

    public RecyclerGuokrNewsAdapter(int layoutResId, List<GuokrNewsEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GuokrNewsEntity item) {
        helper.setText(R.id.tv_item_guokr_title, item.getTitle());

        Glide.with(BaseApplication.getContext())
                .load(item.getHeadline_img())
                .animate(R.anim.alpha_in)
                .centerCrop()
                .into((ImageView) helper.getView(R.id.iv_item_guokr_bg));
    }
}
