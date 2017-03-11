package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsBean;
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
}
