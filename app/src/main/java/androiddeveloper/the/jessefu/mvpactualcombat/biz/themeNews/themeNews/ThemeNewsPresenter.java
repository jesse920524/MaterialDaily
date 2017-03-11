package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themeNews;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.IThemeNewsModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsModelImpl;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemeNewsPresenter implements ThemeNewsContract.IThemeNewsPresenter, ThemeNewsModelImpl.onDataLoadedListener {

    private static final String TAG = ThemeNewsPresenter.class.getSimpleName();

    private ThemeNewsContract.IThemeNewsView view;
    private IThemeNewsModel model;



    private static int THEME_ID = 0;
    public static void setThemeId(int themeId) {
        THEME_ID = themeId;
    }

    public ThemeNewsPresenter(ThemeNewsContract.IThemeNewsView view) {
        this.view = view;
        model = new ThemeNewsModelImpl();
        view.setPresenter(this);
    }

    @Override
    public void getData(int themeId) {
        model.getThemeNews(this, themeId);
    }

    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();
        getData(view.getThemeId());
    }


    @Override
    public void onSuccess(List<ThemeNewsEntity> entities) {
        view.getData(entities);
        view.dismissLoading();
    }

    @Override
    public void onError() {
        view.dismissLoading();
    }
}
