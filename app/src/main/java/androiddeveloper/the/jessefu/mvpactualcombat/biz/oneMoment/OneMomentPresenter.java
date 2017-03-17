package androiddeveloper.the.jessefu.mvpactualcombat.biz.oneMoment;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.IOneMomentModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentModelImpl;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class OneMomentPresenter implements OneMomentContract.IOneMomentPresenter, OneMomentModelImpl.onDataLoadListener {
    private static final String TAG = OneMomentPresenter.class.getSimpleName();
    private OneMomentContract.IOneMomentView view;
    private IOneMomentModel model;

    public OneMomentPresenter(OneMomentContract.IOneMomentView view) {
        this.view = view;
        this.model = new OneMomentModelImpl();
        view.setPresenter(this);
    }


    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        getData();

    }

    @Override
    public void getData() {
        view.showLoading();
        model.getNews(this);
    }

    @Override
    public void getDataMore() {
        model.getNewsMore(this);
    }

    @Override
    public void onDestroy() {
        model.onDestroy();
    }

    @Override
    public void onSuccess(List<OneMomentEntity> oneMomentEntities) {
        view.getData(oneMomentEntities);
        view.dismissLoading();
    }

    @Override
    public void onSuccessMore(List<OneMomentEntity> oneMomentEntities) {
        view.getDataMore(oneMomentEntities);
    }

    @Override
    public void onError(String errMsg) {

        view.dismissLoading();
        view.getDataError(errMsg);
    }

    @Override
    public void onErrorMore(String errMsg) {
        view.getDataMoreError(errMsg);
    }
}
