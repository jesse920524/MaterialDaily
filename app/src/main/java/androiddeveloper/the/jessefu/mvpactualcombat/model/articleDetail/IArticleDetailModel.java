package androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail;

import androiddeveloper.the.jessefu.mvpactualcombat.model.listener.OnDataLoadedListener;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface IArticleDetailModel {

    void getArticleDetail(OnDataLoadedListener listener, String id);

    //void saveArticleDetail(ArticleDetailBean bean);




}
