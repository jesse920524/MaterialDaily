package androiddeveloper.the.jessefu.mvpactualcombat.biz.webView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
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

    private WebSettings webSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        setUIFlags();//透明状态栏
        ButterKnife.bind(this);
        presenter = new WebviewPresenter(this);
        presenter.start();

        initViews();
    }

    /**状态栏沉浸*/
    private void setUIFlags() {
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            int option =  View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
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
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);//缓存
        webSettings.setAppCacheEnabled(false);//appCache功能


        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCollapsingToolbarLayout.setTitle("");
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
    public void getData(ArticleDetailBean bean) {
        getSupportActionBar().setTitle(receivedTitle);

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

        }

        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/zhihu.css\" type=\"text/css\">";
        String html = "<html><head>" + css + "</head><body>" + bean.getBody() + "</body></html>";
        html = html.replace("<div class=\"img-place-holder\">", "");
        mWebView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);
    }


    /**
     *接收Context传递来的文章id*/
    @Override
    public String getArticleId() {

        Intent intent = getIntent();
        if (intent != null){
            receivedId = intent.getStringExtra(MyConstants.ARTICLE_ID);
            receivedTitle = intent.getStringExtra(MyConstants.ARTICLE_TITLE);
            Log.d(TAG, "received title: " + receivedTitle);
            /*mHeaderView.bindTo(receivedTitle);
            mFloatingHeaderView.bindTo(receivedTitle);*/
        }
        return receivedId;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onStop() {
        super.onStop();
        android.transition.Fade fade = new android.transition.Fade();
        getWindow().setExitTransition(fade);
    }


    @Override
    public void setImageLoadMode(boolean loadMode) {
        /**设置webView是否显示图片*/
        webSettings.setBlockNetworkImage(loadMode);
    }
}
