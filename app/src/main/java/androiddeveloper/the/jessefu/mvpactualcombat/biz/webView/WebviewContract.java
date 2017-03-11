package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public interface WebviewContract {

    interface IWebviewView extends BaseView<IWebviewPresenter>{
        void getData(ArticleDetailBean articleDetailBean);

        String getArticleId();

        void setImageLoadMode(boolean loadMode);
    }
    interface IWebviewPresenter extends BasePresenter{
        void getData();

        //检查是否无图模式
        boolean checkNoPicMode();
    }
}
