package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public interface GankGirlsService {
    /*@GET("api/data/福利/{items}/{page}")
    Observable<GankGirlsBean> getGankGirls(@Path("items") int itemsPerPage, @Path("page") int pageNum);*/

    @GET("api/data/福利/{items}/{page}")
    Observable<GankGirlsBean> getGankGirls(@Path("items") int itemsPerPage, @Path("page") int pageNum);
}
