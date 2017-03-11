package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods.HttpMethodsZhihu;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemeNewsModelImpl implements IThemeNewsModel {

    private static final String TAG = ThemeNewsModelImpl.class.getSimpleName();

    private Subscriber<ThemeNewsBean> subscriber;

    @Override
    public void getThemeNews(final ThemeNewsModelImpl.onDataLoadedListener listener, int themeId) {
        subscriber = new Subscriber<ThemeNewsBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取主题日报新闻 onCompleted !!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "获取主题日报新闻 onError " + e.getMessage());
                listener.onError();
            }

            @Override
            public void onNext(ThemeNewsBean themeNewsBean) {
                Log.d(TAG, "获取主题日报新闻 onNext " + themeNewsBean.toString());
                /**将JavaBean转化为Entity*/
                final List<ThemeNewsEntity> entities = convertBeanToEntity(themeNewsBean);
                final List<ThemeNewsEntity>  themeEntities = entities;
                /**将Entity存储到数据库*/
                //存储到db
                saveEntity(themeEntities);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(entities);
                    }
                }, 1000);
            }
        };
        HttpMethodsZhihu.getInstance().getThemeNewsList(subscriber, themeId);
    }



    @Override
    public List<ThemeNewsEntity> convertBeanToEntity(ThemeNewsBean bean) {
        List<ThemeNewsEntity> entities = new ArrayList<>();
        for (ThemeNewsBean.StoriesBean storiesBean : bean.getStories()){
            ThemeNewsEntity entity = new ThemeNewsEntity();
            entity.setID((long) storiesBean.getId());
            entity.setId(storiesBean.getId());

            if (storiesBean.getImages() != null){
                entity.setImages(storiesBean.getImages().get(0));
            }else{
                /**这里接收到的ThemeNewsBean的Images字段可能为空,也可能没有该字段!!!必须特殊处理*/
                //entity.setImages("http://greenrobot.org/wordpress/wp-content/uploads/test_01_02.png");
                entity.setImages(null);
            }


            entity.setTitle(storiesBean.getTitle());
            entity.setType(storiesBean.getType());

            entities.add(entity);
        }
        entities.remove(0);//移除第一条的广告
        return entities;
    }

    @Override
    public void saveEntity(List<ThemeNewsEntity> entities) {

    }

    @Override
    public List<ThemeNewsEntity> getEntity() {
        return null;
    }

    @Override
    public void deleteEntity() {

    }

    public interface onDataLoadedListener{
        void onSuccess(List<ThemeNewsEntity> entities);

        void onError();
    }
}
