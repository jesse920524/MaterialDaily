package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import androiddeveloper.the.jessefu.mvpactualcombat.anotations.HttpRequest;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.IArticleDetailModel;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class WebviewPresenter implements WebviewContract.IWebviewPresenter, ArticleDetailModelImpl.onLoadedListener {

    private static final String TAG = WebviewPresenter.class.getSimpleName();

    private WebviewContract.IWebviewView view;
    private IArticleDetailModel model;

    public WebviewPresenter(WebviewContract.IWebviewView view) {
        this.view = view;
        model = new ArticleDetailModelImpl();
        view.setPresenter(this);
    }


    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();
        getData();
    }

    /**发送http请求获取文章详情,需要文章id*/
    @HttpRequest(httpMethod = "get")
    @Override
    public void getData() {

        String id = view.getArticleId();
        model.getArticleDetail(this, id);
    }

    @Override
    public void onSuccess(ArticleDetailBean articleDetailBean) {
        view.dismissLoading();
        view.getData(articleDetailBean);
    }

    @Override
    public void onError() {
        view.dismissLoading();
    }
}
