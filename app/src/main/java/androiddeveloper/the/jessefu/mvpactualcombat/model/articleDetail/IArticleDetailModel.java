package androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface IArticleDetailModel {

    void getArticleDetail(ArticleDetailModelImpl.onLoadedListener loadedListener, String id);

    //void saveArticleDetail(ArticleDetailBean bean);




}
