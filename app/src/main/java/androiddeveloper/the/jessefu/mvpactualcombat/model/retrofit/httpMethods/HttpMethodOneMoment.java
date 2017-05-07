package androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.OneMomentDetailsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.services.OneMomentService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class HttpMethodOneMoment {
    private static final String TAG = HttpMethodOneMoment.class.getSimpleName();

    private Retrofit retrofit;
    private OneMomentService oneMomentService;
    private OneMomentDetailsService oneMomentDetailsService;

    //1.private constructor
    private HttpMethodOneMoment(){
        //手动创建一个okhttpClient并设置超时时间
        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        okhttpBuilder.connectTimeout(MyConstants.DEFAULT_TIME_OUT, TimeUnit.MILLISECONDS);

        retrofit = new Retrofit.Builder()
                .baseUrl(MyConstants.YIKE_BASE)
                .client(okhttpBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        oneMomentService = retrofit.create(OneMomentService.class);
        oneMomentDetailsService = retrofit.create(OneMomentDetailsService.class);
    }

    //2.private static innerclass SingltonHolder hold one private static final instance
    private static class SingltonHolder{
        private static final HttpMethodOneMoment INSTANCE = new HttpMethodOneMoment();
    }

    //3.provide public method to get instance
    public static HttpMethodOneMoment getInstance(){
        return SingltonHolder.INSTANCE;
    }

    /**
     * 获取一刻文章列表*/
    public void getOneMomentList(Subscriber<OneMomentBean> subscriber, String date){
        oneMomentService.getOneMomentList(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**获取一刻文章详情*/
    public void getOneMomentDetail(Subscriber<OneMomentDetailBean> subscriber, String id){
        oneMomentDetailsService.getOneMomentDetails(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }



}
