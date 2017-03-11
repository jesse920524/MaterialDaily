package androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsEntity;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public interface GankGirlsContract {

    interface IGankGirlsView extends BaseView<IGankGirlsPresenter>{
        void showLoading();
        void dismissLoading();
        void getData(List<GankGirlsEntity> entities);
        void getDataMore(List<GankGirlsEntity> entities);

    }
    interface IGankGirlsPresenter extends BasePresenter{

        void getData(int itemCount, int page);

        void onDestroy();


    }
}
