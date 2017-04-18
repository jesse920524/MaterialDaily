package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import android.os.Handler;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods.HttpMethodsZhihu;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017-04-16.
 */

public class ZHNewsModelImpl implements IZHNewsModel {
    private static final String TAG = ZHNewsModelImpl.class.getSimpleName();

    private Subscriber<ZHLatestNewsBean> subscriberLatest;
    private Subscriber<ZHPastNewsBean> subscriberPast;

    private static String currDate;//当天时间,加载更多时递减

    public ZHNewsModelImpl(){
        //初始化date

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        currDate = formatter.format(new Date());


        Log.d(TAG, "初始化currDate: " + currDate);
    }

    @Override
    public void getLatestNews(final OnDataLoadedListener.onZHNewsStoryEntityLoadedListener loadedListener) {
        onDestroy();//这里是为了刷新当天日期
        subscriberLatest = new Subscriber<ZHLatestNewsBean>() {
            @Override
            public void onCompleted() {

                Log.d(TAG, "获取今日新闻列表 onCompleted() exec");
                //得到前一天date(input -> date out -> date)
                currDate = UtilTime.getSpecifiedBefore(currDate);

                Log.d(TAG, "更新后的currDate: " + currDate);
            }

            @Override
            public void onError(Throwable e) {
                loadedListener.onError();
            }

            @Override
            public void onNext(ZHLatestNewsBean bean) {
                final List<ZHNewsStoryEntity> entities = convertBean2Entity(bean);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccess(entities);
                    }
                }, 1000);

            }
        };
        HttpMethodsZhihu.getInstance().getLatestNews1(subscriberLatest);
    }

    @Override
    public List<ZHNewsStoryEntity> convertBean2Entity(ZHLatestNewsBean bean) {
        Log.d(TAG, "今日日报bean转为entity exec");
        List<ZHNewsStoryEntity> entityList = new ArrayList<>();
        for (ZHLatestNewsBean.StoriesBean storiesBean : bean.getStories()){
            ZHNewsStoryEntity entity = new ZHNewsStoryEntity();

            entity.setGaPrefix(storiesBean.getGaPrefix());
            entity.setId(storiesBean.getId());
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
    public void getPastNews(final OnDataLoadedListener.onZHNewsStoryEntityLoadedListener loadedListener) {
        subscriberPast = new Subscriber<ZHPastNewsBean>() {
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

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadedListener.onSuccessMore(convertBean2Entity(bean));
                    }
                }, 1000);

            }
        };
        HttpMethodsZhihu.getInstance().getPastNews1(subscriberPast, currDate.replace("-", ""));
    }

    @Override
    public List<ZHNewsStoryEntity> convertBean2Entity(ZHPastNewsBean bean) {
        List<ZHNewsStoryEntity> entityList = new ArrayList<>();
        for (ZHPastNewsBean.StoriesBean storiesBean : bean.getStories()){
            ZHNewsStoryEntity entity = new ZHNewsStoryEntity();

            entity.setGaPrefix(storiesBean.getGaPrefix());
            entity.setId(storiesBean.getId());
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
