package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;

import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import io.reactivex.Observer;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Jesse Fu on 2017/3/15 0015.
 */

public interface OneMomentDetailsService {
    @GET("api/post/{id}")
    io.reactivex.Observable<OneMomentDetailBean> getOneMomentDetails(@Path("id")String id);
}
