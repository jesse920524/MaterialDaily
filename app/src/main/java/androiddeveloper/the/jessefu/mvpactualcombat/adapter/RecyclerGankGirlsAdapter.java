package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsEntity;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class RecyclerGankGirlsAdapter extends BaseQuickAdapter<GankGirlsEntity, BaseViewHolder> {

    public RecyclerGankGirlsAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RecyclerGankGirlsAdapter(int layoutResId, List<GankGirlsEntity> data) {
        super(layoutResId, data);
    }

    public RecyclerGankGirlsAdapter(List<GankGirlsEntity> data) {
        super(data);

    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, GankGirlsEntity item) {
        Glide.with(BaseApplication.getContext())
                .load(item.getUrl())
                .crossFade()
                //.centerCrop()
                //.animate(R.anim.alpha_in)
                .into((ImageView) helper.getView(R.id.iv_item_gankgirls));
    }
}
