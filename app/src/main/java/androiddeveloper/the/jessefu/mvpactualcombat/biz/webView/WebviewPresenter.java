package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.anotations.HttpRequest;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.IArticleDetailModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.IOneMomentDetailModel;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailModelImpl;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilConnection;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class WebviewPresenter implements WebviewContract.IWebviewPresenter, ArticleDetailModelImpl.onLoadedListener, OneMomentDetailModelImpl.onDataLoadedListener {

    private static final String TAG = WebviewPresenter.class.getSimpleName();

    private SharedPreferences sp;

    private WebviewContract.IWebviewView view;
    private IArticleDetailModel modelZhihuArticle;
    private IOneMomentDetailModel modelOneMomentDetail;

    //share func
    private String shareArticleType;
    private String shareUrl;
    private String shareTitle;

    public WebviewPresenter(WebviewContract.IWebviewView view) {
        //获取sharedPreference,判断是否无图模式
        sp = BaseApplication.getContext().getSharedPreferences(MyConstants.USER_SETTINGS, MODE_PRIVATE);
        this.view = view;
        modelZhihuArticle = new ArticleDetailModelImpl();
        modelOneMomentDetail = new OneMomentDetailModelImpl();
        view.setPresenter(this);

    }


    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        view.showLoading();
        getData(view.getArticleId(view.getActivityIntent()), view.getArticleType(view.getActivityIntent()));
    }

    /**发送http请求获取文章详情,需要文章id*/
    @HttpRequest(httpMethod = "get")
    @Override
    public void getData(String receivedId, String receivedType) {
        Log.d(TAG, "getZhihuArticleDetail: " + receivedId + " " + receivedType);
        if (receivedType.equals(MyConstants.ARTICLE_TYPE_ZHIHU_LATEST)){
            modelZhihuArticle.getArticleDetail(this, receivedId);
        }else if (receivedType.equals(MyConstants.ARTICLE_TYPE_ZHIHU_PAST)){
            modelZhihuArticle.getArticleDetail(this, receivedId);
        }else if (receivedType.equals(MyConstants.ARTICLE_TYPE_ONEMOMENT) ){
            modelOneMomentDetail.getOneMomentDetailBean(this, receivedId);
        }

    }

    @Override
    public boolean checkNoPicMode() {
        return sp.getBoolean("no_pic_mode", false)?true : false;
    }

    @Override
    public void share(String type, String url, String title) {
        if (!checkArticleType(type)){
            BaseApplication.showToast("error");
            return;
        }

        try{
            Intent shareIntent = new Intent(Intent.ACTION_SEND).setType("text/plain");
            StringBuilder sb = new StringBuilder();
            sb.append("分享自 『Material Daily』:");
            sb.append("\n").append(title).append(" ");

            switch (type){
                case MyConstants.ARTICLE_TYPE_ZHIHU_LATEST:
                case MyConstants.ARTICLE_TYPE_ZHIHU_PAST:
                    sb.append(url);
                    break;
                case MyConstants.ARTICLE_TYPE_ONEMOMENT:
                    sb.append(url);
                    break;
            }
            sb.append("\t\t\t");
            shareIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            ((AppCompatActivity)view).startActivity(Intent.createChooser(shareIntent, "to: "));
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public boolean checkArticleType(String type) {
        if (type.equals(MyConstants.ARTICLE_TYPE_ONEMOMENT)
                ||type.equals(MyConstants.ARTICLE_TYPE_ZHIHU_LATEST)
                ||type.equals(MyConstants.ARTICLE_TYPE_ZHIHU_PAST))
            return true;
        return false;
    }

    @Override
    public void onSuccess(ArticleDetailBean articleDetailBean) {
        view.dismissLoading();
        view.getZhihuArticleDetail(articleDetailBean);
    }

    @Override
    public void onError() {
        view.dismissLoading();
        if (!UtilConnection.getNetworkState()){
            view.showErrorSnack();
        }
    }

    @Override
    public void onSuccess(OneMomentDetailBean bean) {
        view.dismissLoading();
        view.getOneMomentDetail(bean);
    }

    @Override
    public void onError(String errMsg) {
        view.dismissLoading();
    }
}
