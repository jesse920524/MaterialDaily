package androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public interface IGankGirlsModel {
    //获取文章列表
    void getGankGirls(GankGirlsModelImpl.onDataLoadedListener listener, int count, int page);

    //将Bean转为entity
    List<GankGirlsEntity> convertBean2Entity(GankGirlsBean gankGirlsBean);
    //将entity持久化到本地
    void saveEntities(List<GankGirlsEntity> entities);

    //获取本地持久化的List<entity>
    List<GankGirlsEntity> getLocalEntities();

    //删除本地持久化的entitys
    void deleteLocalEntities();

    void onDestroy();
}
