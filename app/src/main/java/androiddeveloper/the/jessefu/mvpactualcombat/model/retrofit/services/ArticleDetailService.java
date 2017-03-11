package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services;


import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface ArticleDetailService {
    @GET("api/4/news/{id}")
    Observable<ArticleDetailBean> getArticleDetail(@Path("id")String id);
}
