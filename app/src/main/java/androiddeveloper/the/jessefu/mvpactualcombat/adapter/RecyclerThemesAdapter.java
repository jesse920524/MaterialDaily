package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Random;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeEntity;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class RecyclerThemesAdapter extends BaseQuickAdapter<ThemeEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId The layout resource id of each item.
     * @param data        A new list is created out of this one to avoid mutable list
     */
    public RecyclerThemesAdapter(int layoutResId, List<ThemeEntity> data) {
        super(layoutResId, data);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, ThemeEntity item) {
        helper.setText(R.id.tv_item_themes_title, item.getName())
                .setText(R.id.tv_item_themes_desc, item.getDescription());
        helper.setBackgroundColor(R.id.layout_item_themes, MyConstants.RAND_BACKGROUND_COLORS[new Random().nextInt(20)]);
        Glide.with(mContext)
                .load(item.getThumbnail())
                .centerCrop()
                //.crossFade()
                .into((ImageView) helper.getView(R.id.iv_item_themes));
    }
}
