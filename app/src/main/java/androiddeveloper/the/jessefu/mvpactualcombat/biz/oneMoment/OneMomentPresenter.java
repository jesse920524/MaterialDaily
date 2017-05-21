package androiddeveloper.the.jessefu.mvpactualcombat.biz.oneMoment;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.IOneMomentModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.IRestoreListItemModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemModelImpl;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class OneMomentPresenter implements OneMomentContract.IOneMomentPresenter, OneMomentModelImpl.onDataLoadListener {
    private static final String TAG = OneMomentPresenter.class.getSimpleName();
    private OneMomentContract.IOneMomentView view;
    private IOneMomentModel model;
    private IRestoreListItemModel modelRestoreListItem;

    public OneMomentPresenter(OneMomentContract.IOneMomentView view) {
        this.model = new OneMomentModelImpl();
        this.modelRestoreListItem = new RestoreListItemModelImpl();
        this.view = view;
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
        modelRestoreListItem.persistentOMListEntities(oneMomentEntities);
    }

    @Override
    public void onSuccessMore(List<OneMomentEntity> oneMomentEntities) {
        view.getDataMore(oneMomentEntities);
        view.dismissLoading();
        modelRestoreListItem.persistentOMListEntities(oneMomentEntities);
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

    @Override
    public void onNetworkError() {
        List<RestoreListItemBean> queryResult = modelRestoreListItem.queryList(MyConstants.ARTICLE_TYPE_ONEMOMENT);
        List<OneMomentEntity> entities = modelRestoreListItem.convertBean2OMEntity(queryResult);
        view.getPersistentData(entities);
        view.dismissLoading();
    }
}
