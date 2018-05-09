package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHLatestNewsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by Jesse Fu on 2017/2/22.
 * 知乎日报api:获取最新消息
 */

public interface LatestNewsService {
//    @Deprecated
//    @GET("api/4/news/latest")
//    Observable<LatestNewsBean> getLatestNews();

    @GET("api/4/news/latest")
    Observable<ZHLatestNewsBean> getLatestNews1();

}
