package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsEntity;

/**
 * Created by Jesse Fu on 2017/3/2 0002.
 */

public class RecyclerThemeNewsAdapter extends BaseQuickAdapter<ThemeNewsEntity, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RecyclerThemeNewsAdapter(int layoutResId, List<ThemeNewsEntity> data) {
        super(layoutResId, data);

    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, ThemeNewsEntity item) {
                helper.setText(R.id.tv_item_title, item.getTitle());
                Glide.with(mContext)
                        .load(item.getImages())
                        .centerCrop()
                        .into((ImageView) helper.getView(R.id.iv_item_news));

    }


}
