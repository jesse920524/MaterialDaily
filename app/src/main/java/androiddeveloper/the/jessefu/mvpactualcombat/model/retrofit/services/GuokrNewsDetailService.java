package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail.GuokrNewsDetailBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017-05-01.
 * 获取果壳精选文章详情
 */

public interface GuokrNewsDetailService {

    @GET("pick/{id}")
    Observable<String> getGuokrNewsDetail(@Path("id")String id);
}
