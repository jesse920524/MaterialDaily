package androiddeveloper.the.jessefu.mvpactualcombat.biz.oneMoment;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public interface OneMomentContract {

    interface IOneMomentView extends BaseView<IOneMomentPresenter>{
        void getData(List<OneMomentEntity> entities);
        void getDataMore(List<OneMomentEntity> entities);

        void getDataError(String errMsg);
        void getDataMoreError(String errMsg);
    }

    interface IOneMomentPresenter extends BasePresenter{
        void getData();
        void getDataMore();

        void onDestroy();
    }
}
