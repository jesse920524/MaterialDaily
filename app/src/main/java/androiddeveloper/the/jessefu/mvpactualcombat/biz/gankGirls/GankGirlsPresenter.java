package androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls;

import android.util.Log;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.IGankGirlsModel;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsPresenter implements GankGirlsContract.IGankGirlsPresenter, GankGirlsModelImpl.onDataLoadedListener {
    private static final String TAG = GankGirlsPresenter.class.getSimpleName();

    private GankGirlsContract.IGankGirlsView view;
    private IGankGirlsModel model;

    public GankGirlsPresenter(GankGirlsContract.IGankGirlsView view) {
        this.view = view;
        model = new GankGirlsModelImpl();
        view.setPresenter(this);
    }

    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();
        this.getData(0,0);
    }

    @Override
    public void getData(int itemCount, int page) {
        model.getGankGirls(this, itemCount, page);
    }

    @Override
    public void onDestroy() {
        model.onDestroy();
    }

    @Override
    public void onSuccess(List<GankGirlsEntity> entityList) {
        Log.d(TAG, "onSuccess() exec. " + entityList);
        view.getData(entityList);
        view.dismissLoading();
    }

    @Override
    public void onSuccessMore(List<GankGirlsEntity> entityList) {
        Log.d(TAG, "onSuccessMore() exec. " + entityList);
        view.getDataMore(entityList);
        view.dismissLoading();
    }

    @Override
    public void onError(String errMsg) {
        BaseApplication.showToast(errMsg);
        view.dismissLoading();
    }
}
