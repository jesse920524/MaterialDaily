package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themes;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.IThemeModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeModelImpl;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemePresenter implements ThemeContract.IThemePresenter, ThemeModelImpl.onDataLoadedListener {

    private ThemeContract.IThemeView view;
    private IThemeModel model;

    public ThemePresenter(ThemeContract.IThemeView view) {
        this.view = view;
        model = new ThemeModelImpl();
        view.setPresenter(this);

    }

    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();

        getData();
    }

    /**获取主题*/
    @Override
    public void getData() {

        model.getThemes(this);
    }

    @Override
    public void onSuccess(List<ThemeEntity> themeEntities) {
        view.getData(themeEntities);
        view.dismissLoading();
    }

    @Override
    public void onError() {
        view.dismissLoading();
    }
}
