package androiddeveloper.the.jessefu.mvpactualcombat.Service;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail.GuokrNewsDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem.RestoreListItemBean;

/**
 * Created by Jesse Fu on 2017-05-13.
 */

public interface IPersistentHelper {

    /**
     * 获取所有持久化的列表页数据*/
    List<RestoreListItemBean> getPersistentList();

    List<RestoreListItemBean> getPersistentList(String type);


    /**
     * 根据知乎列表页item的id,获取详情页数据*/
    void getZHDetail(Long id);
    void getOMDetail(Long id);
    void getGuokrDetail(Long id);

    List<ArticleDetailBean> getZHDetail(List<RestoreListItemBean> restoreListItemBeanList);
    List<OneMomentDetailBean> getOMDetail(List<RestoreListItemBean> restoreListItemBeanList);
    List<GuokrNewsDetailBean> getGuokrDetail(List<RestoreListItemBean> restoreListItemBeanList);


    /**读取缓存有效期,
     * 根据有效期移除过期数据*/
    void clearExpireData();

    /**持久化所有未过期数据(ListItem, articleDetail)*/
    void persistentData();
    /***/
    void start();

}
