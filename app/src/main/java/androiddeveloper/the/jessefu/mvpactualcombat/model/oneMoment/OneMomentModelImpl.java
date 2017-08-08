package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment;

import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodOneMoment;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilConnection;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class OneMomentModelImpl implements IOneMomentModel {
    private static final String TAG = OneMomentModelImpl.class.getSimpleName();


    private HttpMethodOneMoment httpMethodOneMoment;
//    private Subscriber<OneMomentBean> subscriber;
    private Observer<OneMomentBean> observer;
    private static String currDate;//当天时间,加载更多时递减
    public OneMomentModelImpl() {

        httpMethodOneMoment = HttpMethodOneMoment.getInstance();

        //初始化date

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(new Date());


        Log.d(TAG, "初始化currDate: " + currDate);
    }

    @Override
    public List<OneMomentEntity> convertBean2Entity(OneMomentBean bean) {
        List<OneMomentEntity> entities = new ArrayList<>();


        for (OneMomentBean.PostsBean postsBean : bean.getPosts()){
            OneMomentEntity oneMomentEntity = new OneMomentEntity();

            oneMomentEntity.setId((long) postsBean.getId());
            oneMomentEntity.setDate(postsBean.getDate());
            oneMomentEntity.setColumn(postsBean.getColumn());
            oneMomentEntity.setTitle(postsBean.getTitle());

            if (postsBean.getAuthor() != null) {
                oneMomentEntity.setAuthorAvatar(postsBean.getAuthor().getAvatar());
                oneMomentEntity.setAuthorName(postsBean.getAuthor().getName());
            }


            /**1.如果thumbs长度为0,则itemtype为TEXT,无img字段
             * 2.如果thumbs长度为1,则itemtype为TEXT_IMG
             * 3.如果thumbs长度大于等于2, 则itemtype为IMG, 无description字段*/
            if (postsBean.getThumbs().size() == 0){
                oneMomentEntity.setItemType(OneMomentEntity.TEXT);

                oneMomentEntity.setImg(null);
                oneMomentEntity.setDescription(postsBean.getAbstractX());
            }else if (postsBean.getThumbs().size() == 1){
                oneMomentEntity.setItemType(OneMomentEntity.TEXT_IMG);

                oneMomentEntity.setImg(postsBean.getThumbs().get(0).getLarge().getUrl());
                oneMomentEntity.setDescription(postsBean.getAbstractX());
            }else if (postsBean.getThumbs().size() >= 2){
                oneMomentEntity.setItemType(OneMomentEntity.IMG);

                oneMomentEntity.setImg(postsBean.getThumbs().get(0).getLarge().getUrl());
                oneMomentEntity.setDescription(null);
            }

            entities.add(oneMomentEntity);
        }
        return entities;
    }

    @Override
    public void getNews(final onDataLoadListener loadListener) {
        onDestroy();//这里是为了刷新当天日期

        /*subscriber = new Subscriber<OneMomentBean>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "on completed() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() exec " + e.getMessage());
                if (!UtilConnection.getNetworkState()){
                    loadListener.onNetworkError();
                }else{
                    loadListener.onError(e.getMessage());
                }

            }

            @Override
            public void onNext(OneMomentBean oneMomentBean) {
                Log.d(TAG, "onNext() exec " + oneMomentBean);
                final List<OneMomentEntity> oneMomentEntityList = convertBean2Entity(oneMomentBean);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadListener.onSuccess(oneMomentEntityList);
                    }
                }, 1000);
            }
        };*/
        observer = new Observer<OneMomentBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull OneMomentBean oneMomentBean) {
                Log.d(TAG, "onNext() exec " + oneMomentBean);
                final List<OneMomentEntity> oneMomentEntityList = convertBean2Entity(oneMomentBean);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadListener.onSuccess(oneMomentEntityList);
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError() exec " + e.getMessage());
                if (!UtilConnection.getNetworkState()){
                    loadListener.onNetworkError();
                }else{
                    loadListener.onError(e.getMessage());
                }
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "on completed() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }
        };
        httpMethodOneMoment.getOneMomentList(observer, currDate);
    }

    @Override
    public void getNewsMore(final onDataLoadListener loadListener) {
        /*subscriber = new Subscriber<OneMomentBean>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "on completed() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() exec " + e.getMessage());
                if (!UtilConnection.getNetworkState()){
                    loadListener.onNetworkError();
                }else{
                    loadListener.onError(e.getMessage());
                }

            }

            @Override
            public void onNext(OneMomentBean oneMomentBean) {
                Log.d(TAG, "onNext() exec " + oneMomentBean);
                final List<OneMomentEntity> oneMomentEntityList = convertBean2Entity(oneMomentBean);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadListener.onSuccessMore(oneMomentEntityList);
                    }
                }, 1000);
            }
        };*/
        observer = new Observer<OneMomentBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull OneMomentBean oneMomentBean) {
                Log.d(TAG, "onNext() exec " + oneMomentBean);
                final List<OneMomentEntity> oneMomentEntityList = convertBean2Entity(oneMomentBean);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadListener.onSuccessMore(oneMomentEntityList);
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError() exec " + e.getMessage());
                if (!UtilConnection.getNetworkState()){
                    loadListener.onNetworkError();
                }else{
                    loadListener.onError(e.getMessage());
                }
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "on completed() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }
        };

        httpMethodOneMoment.getOneMomentList(observer, currDate);
    }

    @Override
    public void saveEntities(List<OneMomentEntity> entities) {

    }

    @Override
    public List<OneMomentEntity> getEntities() {
        return null;
    }

    @Override
    public void deleteEntities() {

    }

    @Override
    public void onDestroy() {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(new Date());
    }


}
