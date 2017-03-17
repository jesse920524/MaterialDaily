package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public interface LatestNewsContract {

    interface ILNView extends BaseView<ILNPresenter>{

        void getData(List<LatestNewsStoryEntity> latestNewsStoryEntityList);

        void getDataError(String errMsg);

        void showLoading();

        void dismissLoading();

        void recyclerViewSmoothScroll();

        int getRecyclerViewPosition(LinearLayoutManager linearLayoutManager);
    }

    interface ILNPresenter extends BasePresenter{

    void getData();

    }
}
