package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-23.
 */

public interface IRestoreArticleModel {

    //查询文章
    RestoreArticleBean  queryArticleById(Long id);

    List<RestoreArticleBean> queryList();

    //持久化文章
    void saveArticle(RestoreArticleBean restoreArticleBean);

    //删除过期文章
    void deleteExpireArticles(int expireTime);
}
