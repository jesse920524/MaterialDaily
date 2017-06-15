package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes;

import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodsZhihu;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemeModelImpl implements IThemeModel {

    private static final String TAG = ThemeModelImpl.class.getSimpleName();
    private Subscriber<ThemeBean> subscriber;
    private ThemeEntityDao themeEntityDao;

    public ThemeModelImpl() {
        themeEntityDao = BaseApplication.getDaoSession().getThemeEntityDao();
    }


    @Override
    public void getThemes(final ThemeModelImpl.onDataLoadedListener listener) {

        subscriber = new Subscriber<ThemeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "获取主题列表error " + e.getMessage());
                listener.onError();
            }

            @Override
            public void onNext(final ThemeBean themeBean) {
                Log.d(TAG, "获取主题列表 " + themeBean.toString());

                /**将JavaBean转化为Entity*/
                List<ThemeEntity> entities = convertBeanToEntity(themeBean);
                final List<ThemeEntity>  themeEntities = entities;
                /**将Entity存储到数据库*/
                //存储到db
                saveEntity(themeEntities);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        listener.onSuccess(themeEntities);
                    }
                }, 1000);
            }
            };
            HttpMethodsZhihu.getInstance().getThemeNews(subscriber);
        }




    @Override
    public List<ThemeEntity> convertBeanToEntity(ThemeBean themeBean) {
        List<ThemeEntity> themeEntities = new ArrayList<>();
        for (ThemeBean.OthersBean othersBean : themeBean.getOthers()){
            ThemeEntity entity = new ThemeEntity();
            entity.setId(othersBean.getId());
            entity.setColor(othersBean.getColor());
            entity.setDescription(othersBean.getDescription());
            entity.setID((long) othersBean.getId());
            entity.setName(othersBean.getName());
            entity.setThumbnail(othersBean.getThumbnail());

            themeEntities.add(entity);
        }
        return themeEntities;
    }

    @Override
    public void saveEntity(List<ThemeEntity> entities) {

    }

    @Override
    public List<ThemeEntity> getEntity() {
        return null;
    }

    @Override
    public void deleteEntity() {

    }

    public interface onDataLoadedListener{
        void onSuccess(List<ThemeEntity> themeEntities);

        void onError();
    }
}

