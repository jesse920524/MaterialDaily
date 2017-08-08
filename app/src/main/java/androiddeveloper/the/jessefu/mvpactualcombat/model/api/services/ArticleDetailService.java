package androiddeveloper.the.jessefu.mvpactualcombat.model.api.services;


import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface ArticleDetailService {
    @GET("api/4/news/{id}")
    Observable<ArticleDetailBean> getArticleDetail(@Path("id")String id);
}
