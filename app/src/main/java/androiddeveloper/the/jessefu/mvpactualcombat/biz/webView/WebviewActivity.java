package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.transition.Fade;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.jude.swipbackhelper.SwipeBackHelper;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews.ZHNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilConnection;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class WebviewActivity extends BaseActivity implements WebviewContract.IWebviewView{

    private static final String TAG = WebviewActivity.class.getSimpleName();

    @BindView(R2.id.tb_web)
    android.support.v7.widget.Toolbar mToolbar;

    @BindView(R2.id.iv_web)
    ImageView mBackdrop;

    @BindView(R2.id.wv_web)
    WebView mWebView;

    @BindView(R2.id.pb_web)
    ProgressBar mProgressBar;

    @BindView(R2.id.layout_web_appbar)
    AppBarLayout mAppbarLayout;

    @BindView(R2.id.layout_web_ctb)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    private WebviewContract.IWebviewPresenter presenter;



    /**接收来自context的文章id与文章标题*/
    private String receivedId;
    private String receivedTitle;
    private String articleUrl;
    private Intent intent;

    private WebSettings webSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        setUIFlags();//透明状态栏
        ButterKnife.bind(this);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeEdgePercent(0.2f)
                .setSwipeSensitivity(0.5f);

        intent = getIntent();//获取收到的intent

        presenter = new WebviewPresenter(this);
        presenter.start();

        initViews();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        mWebView.getScrollY();
        SwipeBackHelper.onDestroy(this);
    }

    /**状态栏沉浸*/
    private void setUIFlags() {
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            int option =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//                    |View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * Activity.this
     */
    @Override
    protected Context getActivityContext() {
        return this.getActivityContext();
    }


    @Override
    public void initViews() {
        webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//能够和js交互
        webSettings.setBlockNetworkImage(presenter.checkNoPicMode());
        //缩放,设置为不能缩放可以防止页面上出现放大和缩小的图标
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDomStorageEnabled(true);//开启DOM api
        webSettings.setAppCacheEnabled(true);//appCache功能
        webSettings.setDatabaseEnabled(true);

        /**
         * 根据网络状态设置不同缓存策略*/
        if (UtilConnection.getNetworkState()){
            webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        }else{
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);//no network, load local
        }

        mWebView.setWebViewClient(new MyWebviewClient());

        mToolbar.setContentInsetStartWithNavigation(0);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //mCollapsingToolbarLayout.setTitle("");
    }



    @Override
    public void setPresenter(WebviewContract.IWebviewPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    //loadData
    @Override
    public void getZhihuArticleDetail(ArticleDetailBean bean) {
        getSupportActionBar().setTitle(receivedTitle);

        articleUrl = bean.getShareUrl();//获取shareUrl

        /**根据sharedpreference取出的值 no_pic_mode,
         * 决定是否加载图片*/
        if (!presenter.checkNoPicMode()){
            Glide.with(this)
                    .load(bean.getImage())
                    .asBitmap()
                    .animate(R.anim.alpha_in)
                    .centerCrop()
                    .into(mBackdrop);
        }else{
            //无图模式则什么也不加载
        }

        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/zhihu.css\" type=\"text/css\">";
        String html = "<html><head>" + css + "</head><body>" + bean.getBody() + "</body></html>";
        html = html.replace("<div class=\"img-place-holder\">", "");
        mWebView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
    }

    @Override
    public void getOneMomentDetail(OneMomentDetailBean oneMomentDetailBean) {
        try {
            getSupportActionBar().setTitle(receivedTitle);

            articleUrl = oneMomentDetailBean.getShortUrl();//get shareUrl
            if (!presenter.checkNoPicMode()) {
                /**豆瓣一刻文章有可能无图,需要在这里判断*/

                if (oneMomentDetailBean.getThumbs().get(0).getMedium().getUrl() != null) {
                    Glide.with(this)
                            .load(oneMomentDetailBean.getThumbs().get(0).getMedium().getUrl())
                            .asBitmap()
                            .animate(R.anim.alpha_in)
                            .centerCrop()
                            .into(mBackdrop);
                }

            } else {
                //无图模式则什么也不加载
            }
        }catch(Exception e){

        }finally {
            String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/yike.css\" type=\"text/css\">";
           /* String html = "<html><head>" + css + "</head><body>" + oneMomentDetailBean.getContent() + "</body></html>";
            html = html.replace("<div class=\"img-place-holder\">", "");*/

            //copy
            String content = oneMomentDetailBean.getContent();

            /**
             * todo :在这里加上网络状态判断和无图模式判断.
             * */

            List<OneMomentDetailBean.PhotosBean> imageList = oneMomentDetailBean.getPhotos();
            for (int i = 0; i < imageList.size(); i++) {
                String old = "<img id=\"" + imageList.get(i).getTagName() + "\" />";
                String newStr = "<img id=\"" + imageList.get(i).getTagName() + "\" "
                        + "src=\"" + imageList.get(i).getMedium().getUrl() + "\"  class=\"thuminfo\" />";
                content = content.replace(old, newStr);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append( "<!DOCTYPE html>\n");
            stringBuilder.append("<html lang=\"ZH-CN\" xmlns=\"http://www.w3.org/1999/xhtml\">\n");
            stringBuilder.append("<head>\n<meta charset=\"utf-8\" />\n");
            stringBuilder.append(css);
            stringBuilder.append("\n</head>\n<body>\n");
            stringBuilder.append("<div class=\"container bs-docs-container\">\n");
            stringBuilder.append("<div class=\"post-container\">\n");
            stringBuilder.append(content);
            stringBuilder.append("</div>\n</div>\n</body>\n</html>");
            mWebView.loadDataWithBaseURL("x-data://base", stringBuilder.toString(), "text/html", "UTF-8", null);

        }



    }


    /**
     *接收Context传递来的文章id*/
    @Override
    public String getArticleId(Intent intent) {

        if (intent != null){

            if (intent.getStringExtra(MyConstants.ARTICLE_TYPE).equals(MyConstants.ARTICLE_TYPE_ZHIHU_LATEST)){
                ZHNewsStoryEntity entity = (ZHNewsStoryEntity) intent.getSerializableExtra(MyConstants.SERIALIZABLE_ITEM);
                receivedId = String.valueOf(entity.getId());
                receivedTitle = entity.getTitle();
            }else if (intent.getStringExtra(MyConstants.ARTICLE_TYPE).equals(MyConstants.ARTICLE_TYPE_ZHIHU_PAST)){
                PastNewsStoryEntity entity = (PastNewsStoryEntity) intent.getSerializableExtra(MyConstants.SERIALIZABLE_ITEM);
                receivedId = String.valueOf(entity.getId());
                receivedTitle = entity.getTitle();
            }else if (intent.getStringExtra(MyConstants.ARTICLE_TYPE).equals(MyConstants.ARTICLE_TYPE_ONEMOMENT)){
                OneMomentEntity entity = (OneMomentEntity) intent.getSerializableExtra(MyConstants.SERIALIZABLE_ITEM);
                receivedId = String.valueOf(entity.getId());
                receivedTitle = entity.getTitle();
            }
            Log.d(TAG, "received title: " + receivedTitle);

        }
        return receivedId;
    }

    @Override
    public String getArticleType(Intent intent) {
        return intent.getStringExtra(MyConstants.ARTICLE_TYPE);
    }

    /**intent传递给presenter*/
    @Override
    public Intent getActivityIntent() {
        return intent;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_web_share:
                presenter.share(getArticleType(intent), articleUrl, receivedTitle);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStop() {
        super.onStop();
        Fade fade = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            fade = new Fade();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setExitTransition(fade);
            }
        }
    }


    @Override
    public void setImageLoadMode(boolean loadMode) {
        /**设置webView是否显示图片*/
        webSettings.setBlockNetworkImage(loadMode);
    }

    @Override
    public void showErrorSnack() {
        Snackbar.make(mWebView, "无法连接到网络", Snackbar.LENGTH_LONG).show();
    }

    class MyWebviewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            view.scrollTo(0, 1000);
            Log.d(TAG, "onPageFinished exec");
        }
    }
}
