package androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.OneMomentDetailsService;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.services.OneMomentService;
import androiddeveloper.the.jessefu.mvpactualcombat.util.RxHelper;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    public void getOneMomentList(Observer<OneMomentBean> observer, String date){
        /*oneMomentService.getOneMomentList(date)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(oneMomentService.getOneMomentList(date))
                .subscribe(observer);

    }

    /**获取一刻文章详情*/
    public void getOneMomentDetail(Observer<OneMomentDetailBean> observer, String id){
        /*oneMomentDetailsService.getOneMomentDetails(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);*/
        RxHelper.shiftSchedulers(oneMomentDetailsService.getOneMomentDetails(id))
                .subscribe(observer);
    }



}
