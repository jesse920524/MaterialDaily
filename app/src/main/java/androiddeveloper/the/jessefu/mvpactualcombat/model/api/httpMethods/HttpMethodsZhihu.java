package androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.ArticleDetailService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.LatestNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.PastNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.ThemeNewsListService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.ThemeNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHLatestNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHPastNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.common.util.RxHelper;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
        okhttpBuilder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS);

        retrofit = new Retrofit.Builder()
                .client(okhttpBuilder.build())
                .baseUrl(MyConstants.ZHIHU_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    @Deprecated
    public void getLatestNews(Observer<LatestNewsBean> observer){
        /*latestNewsService.getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(latestNewsService.getLatestNews())
                .subscribe(observer);
    }

    /**new */
    public void getLatestNews1(Observer<ZHLatestNewsBean> observer){
        /*latestNewsService.getLatestNews1()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        /*RxHelper.shiftSchedulers(latestNewsService.getLatestNews1())
                .subscribe(observer);*/

        latestNewsService.getLatestNews1()
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**用于获取知乎日报往期文章*/
    @Deprecated
    public void getPastNews(Observer<PastNewsBean> observer, String date){
        /*pastNewsService.getPastNews(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(pastNewsService.getPastNews(date))
                .subscribe(observer);
    }

    public void getPastNews1(Observer<ZHPastNewsBean> observer, String date){
       /* pastNewsService.getPastNews1(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
       RxHelper.shiftSchedulers(pastNewsService.getPastNews1(date))
               .subscribe(observer);
    }

    /**用于获取知乎日报主题列表*/

    public void getThemeNews(Observer<ThemeBean> observer){
        /*themeNewsService.getThemeNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(themeNewsService.getThemeNews());
    }

    /**用于获取知乎日报主题新闻
     * @param themeId 主题id*/
    public void getThemeNewsList(Observer<ThemeNewsBean> observer, int themeId){
        /*themeNewsListService.getThemeNewsList(themeId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(themeNewsListService.getThemeNewsList(themeId));
    }

    public void getArticleDetail(Observer<ArticleDetailBean> observer, String id){
        /*articleDetailService.getArticleDetail(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(articleDetailService.getArticleDetail(id))
                .subscribe(observer);
    }

}
