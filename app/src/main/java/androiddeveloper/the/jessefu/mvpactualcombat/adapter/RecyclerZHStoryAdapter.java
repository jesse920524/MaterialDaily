package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017-04-16.
 *
 */

public class RecyclerZHStoryAdapter extends BaseQuickAdapter<ZHNewsStoryEntity, BaseViewHolder> {

    public RecyclerZHStoryAdapter(int layoutResId, List<ZHNewsStoryEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZHNewsStoryEntity item) {
        helper.setText(R.id.tv_item_title, item.getTitle());
        Glide.with(mContext)
                .load(item.getImages())
                .animate(R.anim.alpha_in)
                .centerCrop()
                //.crossFade()
                .into((ImageView) helper.getView(R.id.iv_item_news));
    }
}
