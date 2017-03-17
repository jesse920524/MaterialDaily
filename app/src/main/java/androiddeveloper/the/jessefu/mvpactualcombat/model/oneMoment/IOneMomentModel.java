package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public interface IOneMomentModel {

    List<OneMomentEntity> convertBean2Entity(OneMomentBean bean);

    //发送http请求获取数据
    void getNews(OneMomentModelImpl.onDataLoadListener loadListener);

    void getNewsMore(OneMomentModelImpl.onDataLoadListener loadListener);

    //持久化数据
    void saveEntities(List<OneMomentEntity> entities);

    //从本地db取出持久化数据
    List<OneMomentEntity> getEntities();

    //delete
    void deleteEntities();

    void onDestroy();
}
