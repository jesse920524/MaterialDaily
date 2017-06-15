package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;



import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 * 获取豆瓣一刻文章列表
 */

public interface OneMomentService {
    @GET("api/stream/date/{date}")
    Observable<OneMomentBean> getOneMomentList(@Path("date")String date);
}
