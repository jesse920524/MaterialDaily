package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.GankGirlsService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class HttpMethodsGank {
    private static final String TAG = HttpMethodsGank.class.getSimpleName();

    private Retrofit retrofit;

    private GankGirlsService gankGirlsService;

    private HttpMethodsGank(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(MyConstants.GANK_URI)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gankGirlsService = retrofit.create(GankGirlsService.class);

    }

    private static class SingltonHolder{
        private static final HttpMethodsGank INSTANCE = new HttpMethodsGank();
    }

    public static HttpMethodsGank getInstance(){
        return SingltonHolder.INSTANCE;
    }

    /**
     * 获取gank福利
     * @param items 请求条数 10
     * @param  page 第几页 1*/
    public void getGankGirls(Subscriber<GankGirlsBean> subscriber, int items, int page){
        gankGirlsService.getGankGirls(items, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
