package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themeNews;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsEntity;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public interface ThemeNewsContract {

    interface IThemeNewsView extends BaseView<IThemeNewsPresenter>{

        void getData(List<ThemeNewsEntity> entities);

        void showLoading();

        void dismissLoading();

        int getThemeId();

    }

    interface IThemeNewsPresenter extends BasePresenter{
        void getData(int themeId);
    }
}
