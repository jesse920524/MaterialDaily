package androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.GuokrNewsDetailService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.GuokrNewsService;
import androiddeveloper.the.jessefu.mvpactualcombat.util.RxHelper;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    public void getGuokrNewsList(Observer<GuokrNewsBean> observer,
                                                      String retrieve_type,
                                                      String category,
                                                      int limit,
                                                      int ad){
       /* guokrNewsService.getGuokrNews(retrieve_type, category, limit, ad)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
       RxHelper.shiftSchedulers(guokrNewsService.getGuokrNews(retrieve_type, category, limit, ad))
               .subscribe(observer);

    }

    /**
     * 获取果壳文章详情*/
    public void getGuokrNewsDetail(Observer<String> observer, String articleId){

        RxHelper.shiftSchedulers(guokrNewsDetailService.getGuokrNewsDetail(articleId))
                .subscribe(observer);
    }

}
