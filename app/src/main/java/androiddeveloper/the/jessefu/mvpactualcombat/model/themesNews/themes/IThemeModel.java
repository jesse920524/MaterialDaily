package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public interface IThemeModel {

    //获取最新文章列表
    void getThemes(ThemeModelImpl.onDataLoadedListener listener);

    //将主题Bean映射为主题Entity
    List<ThemeEntity> convertBeanToEntity(ThemeBean themeBean);

    //持久化ThemeEntity
    void saveEntity(List<ThemeEntity> entities);

    //得到本地持久化的Entity
    List<ThemeEntity> getEntity();

    void deleteEntity();
}
