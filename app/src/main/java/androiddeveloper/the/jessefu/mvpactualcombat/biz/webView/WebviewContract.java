package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.Intent;

import java.io.Serializable;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail.GuokrNewsDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.RestoreArticleBean;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface WebviewContract {

    interface IWebviewView extends BaseView<IWebviewPresenter>{

        //加载知乎文章详情
        void getZhihuArticleDetail(ArticleDetailBean articleDetailBean);

        //加载一刻文章详情
        void getOneMomentDetail(OneMomentDetailBean oneMomentDetailBean);

        //加载果壳文章详情
        void getGuokrNewsDetail(String bean);

        String getArticleId(Intent intent);
        String getArticleType(Intent intent);
        Intent getActivityIntent();

        void setImageLoadMode(boolean loadMode);

        void showErrorSnack();
    }
    interface IWebviewPresenter extends BasePresenter{
        void getData(String id, String type);

        //检查是否无图模式
        boolean checkNoPicMode();

        //分享
        void share(String type, String url, String title);

        //检查文章类型合法性
        boolean checkArticleType(String type);

        //持久化文章,根据type区分不同类型
        <T extends Serializable> void saveArticle(T t, String type);

        //取出已持久化的文章
        RestoreArticleBean getArticleFromDb(Long id);
    }
}
