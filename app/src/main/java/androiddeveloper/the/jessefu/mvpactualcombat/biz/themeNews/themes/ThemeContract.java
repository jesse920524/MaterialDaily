package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themes;

import android.support.v7.widget.GridLayoutManager;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeEntity;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public interface ThemeContract {

    interface IThemeView extends BaseView<IThemePresenter>{

        void getData(List<ThemeEntity> themeEntities);

        int getRecyclerViewPosition(GridLayoutManager gridLayoutManager);

        void recyclerViewSmoothScroll();
    }

    interface IThemePresenter extends BasePresenter{
        void getData();
    }
}
