package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHLatestNewsBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/2/22.
 * 知乎日报api:获取最新消息
 */

public interface LatestNewsService {
    @GET("api/4/news/latest")
    Observable<LatestNewsBean> getLatestNews();

    @GET("api/4/news/latest")
    Observable<ZHLatestNewsBean> getLatestNews1();

}
