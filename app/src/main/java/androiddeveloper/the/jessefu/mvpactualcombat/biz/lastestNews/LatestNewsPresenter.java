package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.ILatestNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public class LatestNewsPresenter implements LatestNewsContract.ILNPresenter, LatestNewsModelImpl.onDataLoadedListener {

    private LatestNewsContract.ILNView view;
    private ILatestNewsModel model;

    public LatestNewsPresenter(LatestNewsContract.ILNView view) {
        this.view = view;
        this.model = new LatestNewsModelImpl();
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
    }

    @Override
    public void onSuccess(List<LatestNewsStoryEntity> latestNewsStoryEntityList) {
            view.getData(latestNewsStoryEntityList);
            view.dismissLoading();
    }

    @Override
    public void onError() {
        view.dismissLoading();
    }
}
