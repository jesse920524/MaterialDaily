package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themeNews;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerThemeNewsAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.webView.WebviewActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews.ThemeNewsEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemeNewsActivity extends BaseActivity implements ThemeNewsContract.IThemeNewsView,SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = ThemeNewsActivity.class.getSimpleName();

    private ThemeNewsContract.IThemeNewsPresenter presenter;

    @BindView(R2.id.tb_themenews)
    Toolbar mToolbar;
    @BindView(R2.id.layout_themenews_swiper)
    SwipeRefreshLayout mSwiper;
    @BindView(R2.id.rv_themenews)
    RecyclerView mRecyclerView;
    @BindView(R2.id.layout_themenews_ctb)
    CollapsingToolbarLayout ctb;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerThemeNewsAdapter mAdapter;

    private String themeName = new String();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme_news);
        ButterKnife.bind(this);

        initViews();
        presenter = new ThemeNewsPresenter(this);
        presenter.start();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    /**
     * Activity.this
     */
    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void initViews() {
        //initToolbar

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ThemeNewsActivity.this.finish();
                }
            });
        }

       /* setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("aaaaaa");*/


        //init swipeRefreshLayout
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);
        mSwiper.setColorSchemeColors(MyConstants.COLORS);

        //init recyclerview
        linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(ThemeNewsActivity.this, WebviewActivity.class);
                ThemeNewsEntity entity = (ThemeNewsEntity) adapter.getData().get(position);
                Log.d(TAG, String.valueOf(entity));
                intent.putExtra(MyConstants.ARTICLE_ID, String.valueOf(entity.getId()));
                intent.putExtra(MyConstants.ARTICLE_TITLE, entity.getTitle());
                startActivity(intent);
            }
        });
        mAdapter = new RecyclerThemeNewsAdapter(R.layout.item_news, null);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        presenter.start();
    }

    @Override
    public void getData(List<ThemeNewsEntity> entities) {
        mAdapter.setNewData(entities);
    }

    @Override
    public void showLoading() {
        mSwiper.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        mSwiper.setRefreshing(false);
    }

    /**接收从context传递来的themeId*/
    @Override
    public int getThemeId() {
        int themeId = 9999;
        Intent intent = getIntent();
        if (intent != null){
            themeId = intent.getIntExtra(MyConstants.THEME_ID, 9999);
            themeName = intent.getStringExtra(MyConstants.THEME_NAME);

            Log.d(TAG, "获取context传来的themeId : " + themeId);
            Log.d(TAG, "获取context传来的themeName : " + themeName);

            mToolbar.setTitle(themeName);

        }
        return themeId;
    }

    @Override
    public void setPresenter(ThemeNewsContract.IThemeNewsPresenter presenter) {
        this.presenter = presenter;
    }
}
