package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.Intent;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface WebviewContract {

    interface IWebviewView extends BaseView<IWebviewPresenter>{

        //加载知乎文章详情
        void getZhihuArticleDetail(ArticleDetailBean articleDetailBean);

        //加载一刻文章详情
        void getOneMomentDetail(OneMomentDetailBean oneMomentDetailBean);

        String getArticleId(Intent intent);
        String getArticleType(Intent intent);
        Intent getActivityIntent();

        void setImageLoadMode(boolean loadMode);
    }
    interface IWebviewPresenter extends BasePresenter{
        void getData(String id, String type);

        //检查是否无图模式
        boolean checkNoPicMode();
    }
}
