package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.RestoreArticleBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.RestoreArticleBeanDao;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.RestoreArticleModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;

/**
 * Created by Jesse Fu on 2017-05-06.
 */

public class RestoreListItemModelImpl implements IRestoreListItemModel {
    private static final String TAG = RestoreArticleModelImpl.class.getSimpleName();

    private RestoreListItemBeanDao restoreListItemBeanDao = BaseApplication.getDaoSession().getRestoreListItemBeanDao();

    public RestoreListItemModelImpl() {

    }


    @Override
    public RestoreListItemBean queryItemById(Long id) {
        try {
            RestoreListItemBean queryResult = restoreListItemBeanDao.queryBuilder()
                    .where(RestoreArticleBeanDao.Properties.ArticleId.eq(id))
                    .unique();
            return queryResult;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RestoreListItemBean> queryList() {
        try{
            List<RestoreListItemBean> queryResult = restoreListItemBeanDao.queryBuilder().list();
            return queryResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<RestoreListItemBean> queryList(String articleType) {
        try {
            List<RestoreListItemBean> queryResult = restoreListItemBeanDao.queryBuilder()
                    .where(RestoreListItemBeanDao.Properties.ArticleType.eq(articleType))
                    .list();
            return queryResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveItem(RestoreListItemBean bean) {
        Log.d(TAG, "save ListItem exec " + bean.getArticleId());
        try {
            if (queryItemById(bean.getArticleId()) == null){
                restoreListItemBeanDao.insert(bean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpireItems(int expireTime) {
        try {
            //获取long类型的过期时间
            Date expireDate = UtilTime.getSpecifiedBefore(new Date(), expireTime);
            long expireLong = Long.parseLong(UtilTime.get8StringDate(expireDate));
            List<RestoreListItemBean> beanList = restoreListItemBeanDao.queryBuilder()
                    .where(RestoreListItemBeanDao.Properties.RestoreDate.lt(expireLong))
                    .list();

            restoreListItemBeanDao.deleteInTx(beanList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<ZHNewsStoryEntity> convertBean2ZHEntity(List<RestoreListItemBean> list) {
        List<ZHNewsStoryEntity> resultList = new ArrayList<>();
        for (RestoreListItemBean restoreListItemBean : list){
            ZHNewsStoryEntity entity = new Gson().fromJson(restoreListItemBean.getArticleInfo(), ZHNewsStoryEntity.class);
            resultList.add(entity);
        }
        return resultList;
    }

    @Override
    public void persistentZHListEntities(List<ZHNewsStoryEntity> entities) {
        Gson gson = new Gson();
        for (ZHNewsStoryEntity entity : entities){
            RestoreListItemBean restoreListItemBean = new RestoreListItemBean();
            restoreListItemBean.setArticleType(MyConstants.ARTICLE_TYPE_ZHIHU);
            restoreListItemBean.setArticleId(entity.getId());
            restoreListItemBean.setRestoreDate(Long.parseLong(UtilTime.get8StringDate(new Date())));
            restoreListItemBean.setArticleInfo(gson.toJson(entity));
            Log.d(TAG, "将知乎列表item转为持久化列表item: " + restoreListItemBean);
            this.saveItem(restoreListItemBean);
        }
    }

    @Override
    public void persistentOMListEntities(List<OneMomentEntity> entities) {
        Gson gson = new Gson();
        for (OneMomentEntity entity : entities){
            RestoreListItemBean restoreListItemBean = new RestoreListItemBean();
            restoreListItemBean.setArticleType(MyConstants.ARTICLE_TYPE_ONEMOMENT);
            restoreListItemBean.setArticleId(entity.getId());
            restoreListItemBean.setRestoreDate(Long.parseLong(UtilTime.get8StringDate(new Date())));
            restoreListItemBean.setArticleInfo(gson.toJson(entity));
            Log.d(TAG, "将一刻列表item转为持久化列表item: " + restoreListItemBean);
            this.saveItem(restoreListItemBean);
        }
    }

    @Override
    public void persistentGKListEntities(List<GuokrNewsEntity> entities) {
        Gson gson = new Gson();
        for (GuokrNewsEntity entity : entities){
            RestoreListItemBean restoreListItemBean = new RestoreListItemBean();
            restoreListItemBean.setArticleType(MyConstants.ARTICLE_TYPE_GUOKR);
            restoreListItemBean.setArticleId(entity.getId());
            restoreListItemBean.setRestoreDate(Long.parseLong(UtilTime.get8StringDate(new Date())));
            restoreListItemBean.setArticleInfo(gson.toJson(entity));
            Log.d(TAG, "将guokr列表item转为持久化列表item: " + restoreListItemBean);
            this.saveItem(restoreListItemBean);
        }
    }


}
