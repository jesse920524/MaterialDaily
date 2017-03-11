package androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.anotations.DB;
import androiddeveloper.the.jessefu.mvpactualcombat.anotations.HttpRequest;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods.HttpMethodsZhihu;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/2/24 0024.
 */

public class LatestNewsModelImpl implements ILatestNewsModel {
    private static final String TAG = LatestNewsModelImpl.class.getSimpleName();
    private LatestNewsStoryEntityDao storyEntityDao;
    private Subscriber<LatestNewsBean> subscriber;

    public LatestNewsModelImpl() {
        //构造器中实例化StoryEntityDao
        storyEntityDao = BaseApplication.getDaoSession().getLatestNewsStoryEntityDao();
    }

    @HttpRequest(description = "获取最新文章列表",
            httpMethod = "Get")
    @Override
    public void getLatestNews(final onDataLoadedListener onDataLoadedListener) {

        subscriber = new Subscriber<LatestNewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, e.getMessage().toString());
                onDataLoadedListener.onError();
            }
            /**
             * onNext()中:
             * 1.将请求结果显示到界面上
             * 2.将请求结果转化为Entity并存储到db中*/
            @Override
            public void onNext(LatestNewsBean latestNewsBean) {
                Log.d(TAG, latestNewsBean.toString());

                /**将JavaBean转化为Entity*/
                List<LatestNewsStoryEntity> storyEntities = convertLatestNewsToStoryEntity(latestNewsBean);
                final List<LatestNewsStoryEntity> finalStoryEntities = storyEntities;
                /**将Entity存储到数据库*/
                //存储到db
                saveStoryEntity(storyEntities);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onDataLoadedListener.onSuccess(finalStoryEntities);
                    }
                }, 1000);
            }
        };
        HttpMethodsZhihu.getInstance().getLatestNews(subscriber);
    }


    @Override
    public List<LatestNewsStoryEntity> convertLatestNewsToStoryEntity(LatestNewsBean latestNewsBean) {
        Log.d(TAG, "convert method exec");
        List<LatestNewsStoryEntity> storyEntities = new ArrayList<>();
        //转化
        for (LatestNewsBean.StoriesBean storiesBean : latestNewsBean.getStories()){
            LatestNewsStoryEntity latestNewsStoryEntity = new LatestNewsStoryEntity();
            latestNewsStoryEntity.setTitle(storiesBean.getTitle());
            latestNewsStoryEntity.setGaPrefix(storiesBean.getGaPrefix());
            latestNewsStoryEntity.setId(storiesBean.getId());
            latestNewsStoryEntity.setImages(storiesBean.getImages().get(0));
            latestNewsStoryEntity.setMultipic(storiesBean.isMultipic());
            latestNewsStoryEntity.setType(storiesBean.getType());
            storyEntities.add(latestNewsStoryEntity);
        }


        return storyEntities;
    }

    @DB(desc = "create")
    @Override
    public void saveStoryEntity(List<LatestNewsStoryEntity> latestNewsStoryEntityList) {
        try{
            List<LatestNewsStoryEntity> entities = storyEntityDao.queryBuilder()
                    .list();
            /**
             * 检查db中第一条与请求第一条是否同一数据.
             * 若否,清除db重新写入
             * 若是,不再写入,直接加载到界面*/
            if (!(entities.get(0).getId() == latestNewsStoryEntityList.get(0).getId())){
                Log.d(TAG, "db save: " + " 数据有更新,写入");
                storyEntityDao.deleteAll();
                storyEntityDao.insertInTx(latestNewsStoryEntityList);
            }else{
                Log.d(TAG, "db save: " + " 数据无更新,直接加载");
            }
            //getStoryEntity();
        }catch (IndexOutOfBoundsException exception){
            /**这里捕获异常:触发下标越界是因为db中没有数据,直接插入*/
            exception.printStackTrace();
            storyEntityDao.insertInTx(latestNewsStoryEntityList);
        } catch(Exception e){
            e.printStackTrace();
        }finally {
            return;
        }

    }

    @DB(desc = "retrieve")
    @Override
    public List<LatestNewsStoryEntity> getStoryEntity() {
        List<LatestNewsStoryEntity>  queryResult = storyEntityDao.queryBuilder()
                .orderAsc(LatestNewsStoryEntityDao.Properties._id)
                .list();
        Log.d(TAG, "query from db: " + queryResult);
        return queryResult;
    }

    @DB(desc = "delete")
    @Override
    public void deleteStoryEntity() {
        storyEntityDao.deleteAll();
    }


    /***/
    public interface onDataLoadedListener{
        void onSuccess(List<LatestNewsStoryEntity> latestNewsStoryEntityList);

        void onError();
    }
}
