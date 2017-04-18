package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

import android.util.Log;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.ILatestNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.IZHNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.OnDataLoadedListener;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;

import static androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews.PastNewsPresenter.date;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public class LatestNewsPresenter implements LatestNewsContract.ILNPresenter,
        OnDataLoadedListener.onZHNewsStoryEntityLoadedListener{

    private LatestNewsContract.ILNView view;
    private IZHNewsModel model;
    private int dayCount;//日期计数.默认上拉加载7天的数据

    public LatestNewsPresenter(LatestNewsContract.ILNView view) {
        dayCount = 0;
        this.view = view;
        this.model = new ZHNewsModelImpl();
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
        model.getLatestNews(this);
        dayCount = 0;//下拉加载时,将dayCount归零
    }

    @Override
    public void getDataMore() {
        model.getPastNews(this);
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
        view.getData(entities);
        view.dismissLoading();
        //dayCount++;
    }

    @Override
    public void onSuccessMore(List<ZHNewsStoryEntity> entities) {
        view.getDataMore(entities);
        view.dismissLoading();
        dayCount++;
        Log.d("log daycount", String.valueOf(dayCount));
        if (dayCount >= 6){
            disableLoadMore();
        }
    }

    @Override
    public void onError() {
        view.dismissLoading();
        view.getDataError(null);
    }
}
