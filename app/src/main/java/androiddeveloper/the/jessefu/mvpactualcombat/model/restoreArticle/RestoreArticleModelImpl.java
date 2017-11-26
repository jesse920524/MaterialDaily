package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle;

import android.util.Log;

import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.common.util.UtilTime;

/**
 * Created by Jesse Fu on 2017-04-23.
 */

public class RestoreArticleModelImpl implements IRestoreArticleModel {
    private static final String TAG =  RestoreArticleModelImpl.class.getSimpleName();

    private RestoreArticleBeanDao restoreArticleBeanDao;

    public RestoreArticleModelImpl() {
        restoreArticleBeanDao = BaseApplication.getDaoSession().getRestoreArticleBeanDao();
    }

    @Override
    public RestoreArticleBean queryArticleById(Long id) {
        try{
            RestoreArticleBean queryResult = restoreArticleBeanDao.queryBuilder()
                    .where(RestoreArticleBeanDao.Properties.ArticleId.eq(id))
                    .unique();
            return queryResult;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<RestoreArticleBean> queryList(){
        try{
            List<RestoreArticleBean> list = restoreArticleBeanDao.queryBuilder().list();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveArticle(RestoreArticleBean restoreArticleBean) {
        Log.d(TAG, "saveArticle exec " + restoreArticleBean.getArticleId());

        try{
            if (queryArticleById(restoreArticleBean.getArticleId()) == null){
                restoreArticleBeanDao.insert(restoreArticleBean);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpireArticles(int expireTime) {
        Long expireDate;
        Date d = UtilTime.getSpecifiedBefore(new Date(), expireTime);
        expireDate = Long.parseLong(UtilTime.get8StringDate(d));
        Log.d(TAG, "过期时间: " + expireDate);

        List<RestoreArticleBean> queryResults =  restoreArticleBeanDao.queryBuilder()
                .where(RestoreArticleBeanDao.Properties.Date.le(expireDate))
                .list();
        restoreArticleBeanDao.deleteInTx(queryResults);
    }
}
