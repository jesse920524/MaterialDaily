package androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews;

import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.IPastNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public class PastNewsPresenter implements PastNewsContract.IPastNewsPresenter, PastNewsModelImpl.onDataLoadedListener {

    private PastNewsContract.IPastNewsView view;
    private IPastNewsModel model;

    public static String date;//记录当前查询日期

    public PastNewsPresenter(PastNewsContract.IPastNewsView view) {
        this.view = view;
        date = UtilTime.get8StringDate(new Date());
        model = new PastNewsModelImpl();
        view.setPresenter(this);

    }

    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();
        getYesterdayData(date);
    }

    @Override
    public void onSuccess(List<ZHNewsStoryEntity> entities) {
//        view.getData(entities);
        view.dismissLoading();
    }

    @Override
    public void onError() {

        view.dismissLoading();
        view.getDataError(null);
    }

    @Override
    public void getYesterdayData(String d) {
        model.getPastNews(this, d);
    }
}
