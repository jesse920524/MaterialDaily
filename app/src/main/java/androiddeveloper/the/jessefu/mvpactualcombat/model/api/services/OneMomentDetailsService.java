package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/15 0015.
 */

public interface OneMomentDetailsService {
    @GET("api/post/{id}")
    Observable<OneMomentDetailBean> getOneMomentDetails(@Path("id")String id);
}
