package androiddeveloper.the.jessefu.mvpactualcombat.biz.main;

import android.support.v4.app.FragmentManager;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;


/**
 * Created by Jesse Fu on 2017/2/19.
 */

public interface MainContract {

    interface IMainView extends BaseView<IMainPresenter>{


        void showLoading();

        void dismissLoading();

        void showDatePickDialog();
    }


    interface IMainPresenter extends BasePresenter{
        void showDatePickDialog(FragmentManager fragmentManager);
    }
}
