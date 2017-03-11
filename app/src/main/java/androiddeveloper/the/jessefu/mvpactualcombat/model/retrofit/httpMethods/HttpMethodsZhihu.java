package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.ArticleDetailService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.LatestNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.PastNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.ThemeNewsListService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.ThemeNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsBean;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public class HttpMethodsZhihu {

    private static final String TAG = HttpMethodsZhihu.class.getSimpleName();
    private Retrofit retrofit;

    private LatestNewsService latestNewsService;
    private PastNewsService pastNewsService;
    private ThemeNewsService themeNewsService;
    private ThemeNewsListService themeNewsListService;
    private ArticleDetailService articleDetailService;

    //构造器私有
    private HttpMethodsZhihu(){
        //手动创建一个okhttpClient并设置超时时间
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(okhttpBuilder.build())
                .baseUrl(MyConstants.ZHIHU_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        latestNewsService = retrofit.create(LatestNewsService.class);
        pastNewsService = retrofit.create(PastNewsService.class);
        themeNewsService = retrofit.create(ThemeNewsService.class);
        themeNewsListService = retrofit.create(ThemeNewsListService.class);
        articleDetailService = retrofit.create(ArticleDetailService.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingltonHolder{
        private static final HttpMethodsZhihu INSTANCE = new HttpMethodsZhihu();
    }

    //获取单例
    public static HttpMethodsZhihu getInstance(){
        return SingltonHolder.INSTANCE;
    }

    /**
     * 用于获取知乎日报最新文章*/
    public void getLatestNews(Subscriber<LatestNewsBean> subscriber){
        latestNewsService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**用于获取知乎日报往期文章*/
    public void getPastNews(Subscriber<PastNewsBean> subscriber, String date){
        pastNewsService.getPastNews(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**用于获取知乎日报主题列表*/
    public void getThemeNews(Subscriber<ThemeBean> subscriber){
        themeNewsService.getThemeNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**用于获取知乎日报主题新闻
     * @param themeId 主题id*/
    public void getThemeNewsList(Subscriber<ThemeNewsBean> subscriber, int themeId){
        themeNewsListService.getThemeNewsList(themeId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getArticleDetail(Subscriber<ArticleDetailBean> subscriber, String id){
        articleDetailService.getArticleDetail(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
