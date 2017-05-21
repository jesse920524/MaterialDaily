package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;

/**
 * Created by Jesse Fu on 2017-05-06.
 */

public interface IRestoreListItemModel {

    //查询一个item
    RestoreListItemBean queryItemById(Long id);

    //query list
    List<RestoreListItemBean> queryList();

    //query list according to article type
    List<RestoreListItemBean> queryList(String articleType);

    //persist
    void saveItem(RestoreListItemBean bean);

    //delete
    void deleteExpireItems(int expireTime);

    //将持久化的RestoreListItemBean转为知乎日报列表页实体
    List<ZHNewsStoryEntity> convertBean2ZHEntity(List<RestoreListItemBean> list);
    List<GuokrNewsEntity> convertBean2GKEntity(List<RestoreListItemBean> list);
    List<OneMomentEntity> convertBean2OMEntity(List<RestoreListItemBean> list);

    //将知乎列表页entity持久化为restoreListItemBean
    void persistentZHListEntities(List<ZHNewsStoryEntity> entities);
    
    //  one moment
    void persistentOMListEntities(List<OneMomentEntity> entities);

    //guokr
    void persistentGKListEntities(List<GuokrNewsEntity> entities);
    
}
