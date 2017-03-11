package androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews;

import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public interface PastNewsContract {
    interface IPastNewsView extends BaseView<IPastNewsPresenter>{
        void getData(List<PastNewsStoryEntity> pastNewsStoryEntities);

        void showLoading();

        void dismissLoading();

        void recyclerViewSmoothScroll();

        int getRecyclerViewPosition(LinearLayoutManager linearLayoutManager);
    }

    interface IPastNewsPresenter extends BasePresenter{

        void getYesterdayData(String date);
    }
}
