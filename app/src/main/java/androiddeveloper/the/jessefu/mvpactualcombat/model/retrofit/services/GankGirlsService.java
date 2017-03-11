package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public interface GankGirlsService {
    @GET("api/data/福利/{items}/{page}")
    Observable<GankGirlsBean> getGankGirls(@Path("items") int itemsPerPage, @Path("page") int pageNum);
}
