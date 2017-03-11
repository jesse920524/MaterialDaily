package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public interface IThemeNewsModel {

    //获取最新文章列表
    void getThemeNews(ThemeNewsModelImpl.onDataLoadedListener listener, int themeId);

    //将主题Bean映射为主题Entity
    List<ThemeNewsEntity> convertBeanToEntity(ThemeNewsBean bean);

    //持久化ThemeEntity
    void saveEntity(List<ThemeNewsEntity> entities);

    //得到本地持久化的Entity
    List<ThemeNewsEntity> getEntity();

    void deleteEntity();
}
