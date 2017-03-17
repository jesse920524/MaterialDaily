package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class RecyclerOneMomentAdapter extends BaseMultiItemQuickAdapter<OneMomentEntity, BaseViewHolder> {

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecyclerOneMomentAdapter(List<OneMomentEntity> data) {
        super(data);
        addItemType(OneMomentEntity.TEXT_IMG, R.layout.item_om_0);
        addItemType(OneMomentEntity.TEXT, R.layout.item_om_1);
        addItemType(OneMomentEntity.IMG, R.layout.item_om_2);
    }

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    @Override
    protected void convert(BaseViewHolder helper, OneMomentEntity item) {
        switch (helper.getItemViewType()){
            case OneMomentEntity.TEXT_IMG:
                helper.setText(R.id.tv_item_om0_title, item.getTitle())
                        .setText(R.id.tv_item_om0_description, item.getDescription())
                        .setText(R.id.tv_item_om0_name, item.getAuthorName())
                        .setText(R.id.tv_item_om0_column, item.getColumn());
                Glide.with(BaseApplication.getContext())
                        .load(item.getImg())
                        .centerCrop()
                        .animate(R.anim.alpha_in)
                        .into((ImageView) helper.getView(R.id.iv_item_om0_img));
                Glide.with(BaseApplication.getContext())
                        .load(item.getAuthorAvatar())
                        .centerCrop()
                        .bitmapTransform(new CropCircleTransformation(BaseApplication.getContext()))
                        .into((ImageView) helper.getView(R.id.iv_item_om0_avatar));

                break;
            case OneMomentEntity.TEXT:
                helper.setText(R.id.tv_item_om1_title, item.getTitle())
                        .setText(R.id.tv_item_om1_description, item.getDescription())
                        .setText(R.id.tv_item_om1_name, item.getAuthorName())
                        .setText(R.id.tv_item_om1_column, item.getColumn());
                Glide.with(BaseApplication.getContext())
                        .load(item.getAuthorAvatar())
                        .centerCrop()
                        .bitmapTransform(new CropCircleTransformation(BaseApplication.getContext()))
                        .into((ImageView) helper.getView(R.id.iv_item_om1_avatar));
                break;
            case OneMomentEntity.IMG:
                helper.setText(R.id.tv_item_om2_title, item.getTitle())
                        .setText(R.id.tv_item_om2_name, item.getAuthorName())
                        .setText(R.id.tv_item_om2_column, item.getColumn());
                Glide.with(BaseApplication.getContext())
                        .load(item.getImg())
                        .centerCrop()
                        .animate(R.anim.alpha_in)
                        .into((ImageView) helper.getView(R.id.iv_item_om2_img));
                Glide.with(BaseApplication.getContext())
                        .load(item.getAuthorAvatar())
                        .centerCrop()
                        .bitmapTransform(new CropCircleTransformation(BaseApplication.getContext()))
                        .into((ImageView) helper.getView(R.id.iv_item_om2_avatar));
                break;

            default:
                break;
        }
    }
}
