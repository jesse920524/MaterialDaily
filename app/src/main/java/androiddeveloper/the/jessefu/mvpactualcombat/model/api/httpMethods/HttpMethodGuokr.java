package androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.GuokrNewsDetailService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.GuokrNewsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public class HttpMethodGuokr {
    private Retrofit retrofit;
    private GuokrNewsService guokrNewsService;
    private GuokrNewsDetailService guokrNewsDetailService;

    private HttpMethodGuokr(){
        //手动创建一个okhttpClient并设置超时时间
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(MyConstants.GUOKR_URI)
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        guokrNewsService = retrofit.create(GuokrNewsService.class);
    }

    /**
     * overload,用于获取文章详情*/
    private HttpMethodGuokr(boolean isDetail){
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(MyConstants.GUOKR_DETAIL)
                .client(okhttpBuilder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        guokrNewsDetailService = retrofit.create(GuokrNewsDetailService.class);
    }

    private static class SingletonHolder{
        private static final HttpMethodGuokr INSTANCE = new HttpMethodGuokr();
    }

    private static class SingletonHolderDetail{
        private static final HttpMethodGuokr INSTANCE = new HttpMethodGuokr(true);
    }

    public static HttpMethodGuokr getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * @param isDetail 是否是文章详情*/
    public static HttpMethodGuokr getInstance(boolean isDetail){
        if (!isDetail){
            return SingletonHolder.INSTANCE;
        }else{
            return SingletonHolderDetail.INSTANCE;
        }
    }

    /**获取果壳文章列表*/
    public void getGuokrNewsList(Subscriber<GuokrNewsBean> subscriber,
                                                      String retrieve_type,
                                                      String category,
                                                      int limit,
                                                      int ad){
        guokrNewsService.getGuokrNews(retrieve_type, category, limit, ad)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 获取果壳文章详情*/
    public void getGuokrNewsDetail(Subscriber<String> subscriber, String articleId){
        guokrNewsDetailService.getGuokrNewsDetail(articleId)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

}
