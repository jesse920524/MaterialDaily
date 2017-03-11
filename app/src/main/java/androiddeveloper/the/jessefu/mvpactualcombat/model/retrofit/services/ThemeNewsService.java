package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 * 主题日报列表
 */

public interface ThemeNewsService {
    @GET("api/4/themes")
    Observable<ThemeBean> getThemeNews();

}
