package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.SharedPreferences;

import androiddeveloper.the.jessefu.mvpactualcombat.anotations.HttpRequest;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.IArticleDetailModel;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class WebviewPresenter implements WebviewContract.IWebviewPresenter, ArticleDetailModelImpl.onLoadedListener {

    private static final String TAG = WebviewPresenter.class.getSimpleName();

    private SharedPreferences sp;

    private WebviewContract.IWebviewView view;
    private IArticleDetailModel model;

    public WebviewPresenter(WebviewContract.IWebviewView view) {
        //获取sharedPreference,判断是否无图模式
        sp = BaseApplication.getContext().getSharedPreferences(MyConstants.USER_SETTINGS, MODE_PRIVATE);
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
    public boolean checkNoPicMode() {
        return sp.getBoolean("no_pic_mode", false)?true : false;
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
