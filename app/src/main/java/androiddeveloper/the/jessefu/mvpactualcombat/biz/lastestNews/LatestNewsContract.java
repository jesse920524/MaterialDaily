package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public interface LatestNewsContract {

    interface ILNView extends BaseView<ILNPresenter>{

        //void getData(List<LatestNewsStoryEntity> latestNewsStoryEntityList);
        void getData(List<ZHNewsStoryEntity> entities);

        void getDataMore(List<ZHNewsStoryEntity> entities);

        void getDataError(String errMsg);

        void getDataMoreError(String errMsg);

        void getPersistentData(List<ZHNewsStoryEntity> persistentData);

        void disableLoadMore();

        void showLoading();

        void dismissLoading();

        void recyclerViewSmoothScroll();

        int getRecyclerViewPosition(LinearLayoutManager linearLayoutManager);
    }

    interface ILNPresenter extends BasePresenter{

        void getData();

        void getDataMore();

        void getDataMoreError(String errMsg);

        /**7天的数据加载完成后,禁止上拉加载更多*/
        void disableLoadMore();

    }
}
