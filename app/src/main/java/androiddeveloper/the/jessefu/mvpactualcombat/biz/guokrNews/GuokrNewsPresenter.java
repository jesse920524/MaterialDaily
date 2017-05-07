package androiddeveloper.the.jessefu.mvpactualcombat.biz.guokrNews;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.IGuokrNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.OnGuokrNewsLoadedListener;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public class GuokrNewsPresenter implements GuokrNewsContract.GuokrNewsPresenter, OnGuokrNewsLoadedListener {
    private static final String TAG = GuokrNewsPresenter.class.getSimpleName();

    private GuokrNewsContract.GuokrNewsView view;
    private IGuokrNewsModel modelGuokrNews;

    public GuokrNewsPresenter(GuokrNewsContract.GuokrNewsView view){
        modelGuokrNews = new GuokrNewsModelImpl();
        this.view = view;
        view.setPresenter(this);
    }
    
    @Override
    public void start() {
        view.showLoading();
        getGuokrNews("by_since", "all", 25, 1);
    }


    @Override
    public void getGuokrNews(String retrieve_type, String category, int limit, int ad) {
        modelGuokrNews.getGuokrNews(this, retrieve_type, category, limit, ad);
    }

    @Override
    public void onSuccess(List<GuokrNewsEntity> entities) {
        view.showData(entities);
        view.dismissLoading();
    }

    @Override
    public void onError(String errMsg) {
        view.getDataError(errMsg);
        view.dismissLoading();
    }
}
