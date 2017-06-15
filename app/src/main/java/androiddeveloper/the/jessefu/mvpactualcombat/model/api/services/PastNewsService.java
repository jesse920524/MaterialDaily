package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHPastNewsBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 * 往期日报列表
 */

public interface PastNewsService {
    @GET("api/4/news/before/{date}")
    Observable<PastNewsBean> getPastNews(@Path("date") String date);

    @GET("api/4/news/before/{date}")
    Observable<ZHPastNewsBean> getPastNews1(@Path("date") String date);
}
