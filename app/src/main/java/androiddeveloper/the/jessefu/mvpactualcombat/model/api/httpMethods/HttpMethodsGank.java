package androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.GankGirlsService;
import androiddeveloper.the.jessefu.mvpactualcombat.common.util.RxHelper;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    public void getGankGirls(Observer<GankGirlsBean> observer, int items, int page){
        /*gankGirlsService.getGankGirls(items, page)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(gankGirlsService.getGankGirls(items, page))
                .subscribe(observer);

    }
}
