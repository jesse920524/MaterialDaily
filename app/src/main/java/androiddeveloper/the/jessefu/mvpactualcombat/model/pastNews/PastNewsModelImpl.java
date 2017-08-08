package androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.anotations.HttpRequest;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodsZhihu;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.util.RxHelper;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;


/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public class PastNewsModelImpl implements IPastNewsModel {

    private static final String TAG = PastNewsModelImpl.class.getSimpleName();
//    private Subscriber<PastNewsBean> subscriber;
    private Observer<PastNewsBean> observer;
    private RxHelper.MyDisposableContainer disposableContainer;
    private PastNewsStoryEntityDao pastNewsStoryEntityDao;

    public PastNewsModelImpl() {
        //构造器中初始化dao
        pastNewsStoryEntityDao = BaseApplication.getDaoSession().getPastNewsStoryEntityDao();
    }


    @HttpRequest(httpMethod = "get")
    @Override
    public void getPastNews(final onDataLoadedListener loadedListener, String date) {
        /*subscriber = new Subscriber<PastNewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "获取往期内容error: " + e.getMessage());
                loadedListener.onError();
            }

            @Override
            public void onNext(PastNewsBean pastNewsBean) {
                Log.d(TAG, "获取往期内容 success: " + pastNewsBean);
                *//**将JavaBean转化为Entity*//*
                List<PastNewsStoryEntity> storyEntities = convertBean2Entity(pastNewsBean);
                final List<PastNewsStoryEntity> finalStoryEntities = storyEntities;
                *//**将Entity存储到数据库*//*
                //存储到db
                saveStoryEntity(storyEntities);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        loadedListener.onSuccess(finalStoryEntities);
                    }
                }, 1000);
            }
        };*/

        observer = new Observer<PastNewsBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposableContainer.add(d);
            }

            @Override
            public void onNext(@NonNull PastNewsBean pastNewsBean) {
                Log.d(TAG, "获取往期内容 success: " + pastNewsBean);
                /**将JavaBean转化为Entity*/
                List<PastNewsStoryEntity> storyEntities = convertBean2Entity(pastNewsBean);
                final List<PastNewsStoryEntity> finalStoryEntities = storyEntities;
                /**将Entity存储到数据库*/
                //存储到db
                saveStoryEntity(storyEntities);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        loadedListener.onSuccess(finalStoryEntities);
                    }
                }, 1000);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "获取往期内容error: " + e.getMessage());
                loadedListener.onError();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        HttpMethodsZhihu.getInstance().getPastNews(observer, date);
    }

    @Override
    public List<PastNewsStoryEntity> convertBean2Entity(PastNewsBean pastNewsBean) {
        Log.d(TAG, "convert method exec");
        List<PastNewsStoryEntity> storyEntities = new ArrayList<>();
        //转化
        for (PastNewsBean.StoriesBean storiesBean : pastNewsBean.getStories()){
            PastNewsStoryEntity entity = new PastNewsStoryEntity();
            entity.setTitle(storiesBean.getTitle());
            entity.setGaPrefix(storiesBean.getGaPrefix());
            entity.setId(storiesBean.getId());
            entity.setImages(storiesBean.getImages().get(0));
            entity.setMultipic(storiesBean.isMultipic());
            entity.setType(storiesBean.getType());
            storyEntities.add(entity);
        }


        return storyEntities;
    }

    @Override
    public void saveStoryEntity(List<PastNewsStoryEntity> entities) {

    }

    @Override
    public List<PastNewsStoryEntity> getStoryEntity() {
        return null;
    }

    @Override
    public void deleteStoryEntity() {

    }

    /***/
    public interface onDataLoadedListener{
        void onSuccess(List<ZHNewsStoryEntity> entities);

        void onError();
    }
}
