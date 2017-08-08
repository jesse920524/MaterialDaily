package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemBeanDao;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodsZhihu;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilConnection;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by Jesse Fu on 2017-04-16.
 */

public class ZHNewsModelImpl implements IZHNewsModel {
    private static final String TAG = ZHNewsModelImpl.class.getSimpleName();
    private RestoreListItemBeanDao restoreListItemBeanDao;
    /*private Subscriber<ZHLatestNewsBean> subscriberLatest;
    private Subscriber<ZHPastNewsBean> subscriberPast;*/

    private Observer<ZHLatestNewsBean> observerLatest;
    private Observer<ZHPastNewsBean> observerPast;

    private static String currDate;//当天时间,加载更多时递减

    public ZHNewsModelImpl(){
        restoreListItemBeanDao = BaseApplication.getDaoSession().getRestoreListItemBeanDao();
        //初始化date

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(new Date());

        Log.d(TAG, "初始化currDate: " + currDate);
    }

    @Override
    public void getLatestNews(final onZHNewsStoryEntityLoadedListener loadedListener) {
        onDestroy();//这里是为了刷新当天日期
        /*subscriberLatest = new Subscriber<ZHLatestNewsBean>() {
            @Override
            public void onCompleted() {

                Log.d(TAG, "获取今日新闻列表 onCompleted() exec");
                //得到前一天date(input -> date out -> date)
                //currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }

            @Override
            public void onError(Throwable e) {
                if (!UtilConnection.getNetworkState()){
                    loadedListener.onNetworkError();
                }else{
                    loadedListener.onError();
                }

            }

            @Override
            public void onNext(ZHLatestNewsBean bean) {
                final List<ZHNewsStoryEntity> entities = convertBean2Entity(bean);

                *//**呈现*//*
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccess(entities);
                    }
                }, 1000);

            }
        };*/
        observerLatest = new Observer<ZHLatestNewsBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull ZHLatestNewsBean bean) {
                final List<ZHNewsStoryEntity> entities = convertBean2Entity(bean);

                /**呈现*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccess(entities);
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                if (!UtilConnection.getNetworkState()){
                    loadedListener.onNetworkError();
                }else{
                    loadedListener.onError();
                }
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "获取今日新闻列表 onCompleted() exec");
                //得到前一天date(input -> date out -> date)
                //currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }
        };
        HttpMethodsZhihu.getInstance().getLatestNews1(observerLatest);
    }

    @Override
    public List<ZHNewsStoryEntity> convertBean2Entity(ZHLatestNewsBean bean) {
        Log.d(TAG, "今日日报bean转为entity exec");
        List<ZHNewsStoryEntity> entityList = new ArrayList<>();
        for (ZHLatestNewsBean.StoriesBean storiesBean : bean.getStories()){
            ZHNewsStoryEntity entity = new ZHNewsStoryEntity();

            entity.setGaPrefix(storiesBean.getGaPrefix());
            entity.setId(Long.valueOf(storiesBean.getId()));
            entity.setImages(storiesBean.getImages().get(0));
            entity.setMultipic(storiesBean.isMultipic());
            entity.setType(storiesBean.getType());
            entity.setTitle(storiesBean.getTitle());

            entityList.add(entity);
        }
        entityList.remove(entityList.get(entityList.size()-1));
        return entityList;
    }

    @Override
    public void getPastNews(final onZHNewsStoryEntityLoadedListener loadedListener) {
        /*subscriberPast = new Subscriber<ZHPastNewsBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取往期新闻列表 onCompleted() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }

            @Override
            public void onError(Throwable e) {
                loadedListener.onError();
            }

            @Override
            public void onNext(final ZHPastNewsBean bean) {
//                final List<ZHNewsStoryEntity> entityList = convertBean2Entity(bean);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccessMore(convertBean2Entity(bean));
                    }
                }, 1000);

            }
        };*/

        observerPast = new Observer<ZHPastNewsBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull final ZHPastNewsBean bean) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccessMore(convertBean2Entity(bean));
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                loadedListener.onError();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "获取往期新闻列表 onCompleted() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }
        };
        HttpMethodsZhihu.getInstance().getPastNews1(observerPast, currDate.replace("-", ""));
    }

    @Override
    public void getSpecificDateNews(final onZHNewsStoryEntityLoadedListener listener, String date) {
        /*subscriberPast = new Subscriber<ZHPastNewsBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError " + e.getMessage());
                listener.onError();
            }

            @Override
            public void onNext(final ZHPastNewsBean bean) {
                Log.d(TAG, "onNext " + bean);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccessSpecificDate(convertBean2Entity(bean));
                    }
                }, 1000);
            }
        };*/

        observerPast = new Observer<ZHPastNewsBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull final ZHPastNewsBean bean) {
                Log.d(TAG, "onNext " + bean);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccessSpecificDate(convertBean2Entity(bean));
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError " + e.getMessage());
                listener.onError();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onCompleted");
            }
        };
        HttpMethodsZhihu.getInstance().getPastNews1(observerPast, date);
    }

    @Override
    public List<ZHNewsStoryEntity> convertBean2Entity(ZHPastNewsBean bean) {
        List<ZHNewsStoryEntity> entityList = new ArrayList<>();
        for (ZHPastNewsBean.StoriesBean storiesBean : bean.getStories()){
            ZHNewsStoryEntity entity = new ZHNewsStoryEntity();

            entity.setGaPrefix(storiesBean.getGaPrefix());
            entity.setId(Long.valueOf(storiesBean.getId()));
            entity.setImages(storiesBean.getImages().get(0));
            entity.setMultipic(storiesBean.isMultipic());
            entity.setType(storiesBean.getType());
            entity.setTitle(storiesBean.getTitle());

            entityList.add(entity);
        }
        entityList.remove(entityList.get(entityList.size()-1));
        return entityList;
    }


    @Override
    public void onDestroy() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(new Date());
    }
}
