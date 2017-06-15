package androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodsGank;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsModelImpl implements IGankGirlsModel{
    private static final String TAG = GankGirlsModelImpl.class.getSimpleName();

    private HttpMethodsGank httpMethodsGank;
    private Subscriber<GankGirlsBean> subscriber;

    private static int page = 1;

    public GankGirlsModelImpl() {
        this.httpMethodsGank = HttpMethodsGank.getInstance();
    }


    @Override
    public  synchronized void getGankGirls(final IGankGirlsModel.onDataLoadedListener listener, int count, int p) {
        subscriber = new Subscriber<GankGirlsBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取福利请求: onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "获取福利请求: onError() " + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onNext(GankGirlsBean gankGirlsBean) {
                Log.d(TAG, "获取福利请求: onNext() " + gankGirlsBean);
                final List<GankGirlsEntity> entities = convertBean2Entity(gankGirlsBean);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (page == 1){
                            listener.onSuccess(entities);
                        }else{
                            listener.onSuccessMore(entities);
                        }

                    }
                }, 1000);
            }
        };
        httpMethodsGank.getGankGirls(subscriber, 10, page++);

    }

    @Override
    public List<GankGirlsEntity> convertBean2Entity(GankGirlsBean gankGirlsBean) {
        List<GankGirlsEntity> entities = new ArrayList<>();
        for (GankGirlsBean.ResultsBean bean : gankGirlsBean.getResults()){
            GankGirlsEntity gankGirlsEntity = new GankGirlsEntity();
            gankGirlsEntity.setId(bean.getId());
            gankGirlsEntity.setPublishAt(bean.getPublishedAt());
            gankGirlsEntity.setUrl(bean.getUrl());

            entities.add(gankGirlsEntity);
        }
        return entities;
    }

    @Override
    public void saveEntities(List<GankGirlsEntity> entities) {

    }

    @Override
    public List<GankGirlsEntity> getLocalEntities() {
        return null;
    }

    @Override
    public void deleteLocalEntities() {

    }

    @Override
    public void onDestroy() {

        if (!subscriber.isUnsubscribed()){
            subscriber.unsubscribe();
        }
        page = 1;
    }

}
