package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 * 获取主题日报新闻列表
 */

public interface ThemeNewsListService {

    /**@Param id 主题id
     * */
    @GET("api/4/theme/{id}")
    Observable<ThemeNewsBean> getThemeNewsList(@Path("id") int id);
}
