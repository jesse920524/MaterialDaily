package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import java.awt.font.TextAttribute;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.IRestoreListItemModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.IZHNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.OnDataLoadedListener;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public class LatestNewsPresenter implements LatestNewsContract.ILNPresenter,
        OnDataLoadedListener.onZHNewsStoryEntityLoadedListener{

    private static final String TAG = LatestNewsPresenter.class.getSimpleName();

    private LatestNewsContract.ILNView view;
    private IZHNewsModel modelZHNews;
    private IRestoreListItemModel modelListItem;

    private int dayCount;//日期计数.默认上拉加载7天的数据

    public LatestNewsPresenter(LatestNewsContract.ILNView view) {
        dayCount = 0;
        this.modelZHNews = new ZHNewsModelImpl();
        this.modelListItem = new RestoreListItemModelImpl();
        this.view = view;

        view.setPresenter(this);
    }

    /**
     * Fragment onCreateView中调用的初始化方法.
     * 1.显示loading
     * 2.请求数据*/
    @Override
    public void start() {
        view.showLoading();
        getData();

    }

    @Override
    public void getData() {
        modelZHNews.getLatestNews(this);
        dayCount = 0;//下拉加载时,将dayCount归零
    }

    @Override
    public void getDataMore() {
        modelZHNews.getPastNews(this);

    }

    @Override
    public void getSpecificDateData(String date) {
        modelZHNews.getSpecificDateNews(this, date);
    }

    @Override
    public void getDataMoreError(String errMsg) {

    }

    @Override
    public void disableLoadMore() {
        view.disableLoadMore();
    }

    @Override
    public void onSuccess(List<ZHNewsStoryEntity> entities) {
        view.recyclerViewSmoothScroll();
        view.getData(entities);
        view.dismissLoading();
        modelListItem.persistentZHListEntities(entities);
    }

    @Override
    public void onSuccessMore(List<ZHNewsStoryEntity> entities) {
        view.getDataMore(entities);
        view.dismissLoading();
        modelListItem.persistentZHListEntities(entities);
        dayCount++;
        Log.d("log daycount", String.valueOf(dayCount));
        if (dayCount >= 6){
            disableLoadMore();
        }
    }

    @Override
    public void onSuccessSpecificDate(List<ZHNewsStoryEntity> entities) {
        view.recyclerViewSmoothScroll();
        view.getData(entities);
        view.dismissLoading();
        disableLoadMore();
        modelListItem.persistentZHListEntities(entities);
    }

    @Override
    public void onError() {
        view.dismissLoading();
        view.getDataError(null);
    }

    @Override
    public void onNetworkError() {
        view.dismissLoading();
        List<RestoreListItemBean> queryResult = modelListItem.queryList(MyConstants.ARTICLE_TYPE_ZHIHU);
        List<ZHNewsStoryEntity> list = modelListItem.convertBean2ZHEntity(queryResult);
        view.getPersistentData(list);


    }


}
