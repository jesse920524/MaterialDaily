package androiddeveloper.the.jessefu.mvpactualcombat.biz.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.jakewharton.rxbinding2.view.RxView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.concurrent.TimeUnit;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.service.PersistentService;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.AHViewpagerAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.about.AboutActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls.GankGirlsActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.settings.SettingsActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.event.EventRandomGuokrArticle;
import androiddeveloper.the.jessefu.mvpactualcombat.event.EventRandomOneMomentArticle;
import androiddeveloper.the.jessefu.mvpactualcombat.event.EventShowSnackbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

public class MainActivity extends BaseActivity implements MainContract.IMainView {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainContract.IMainPresenter presenter;

        @BindView(R2.id.tb_main)
        Toolbar mToolbar;
        @BindView(R2.id.tv_main_title)
        TextView mTitle;
        @BindView(R2.id.iv_main_menu)
        ImageView mIvMenu;
        @BindView(R2.id.iv_main_drive)
        ImageView mIvDrive;
        @BindView(R2.id.layout_ctb)
        CollapsingToolbarLayout mCtb;
        @BindView(R2.id.bn_main)
        AHBottomNavigation mBottomNavigation;
        @BindView(R2.id.vp_main)
        AHBottomNavigationViewPager mViewPager;
        @BindView(R2.id.fab_main)
        FloatingActionButton mFAB;

    private PopupMenu mPopupMenu;
    private Menu mMenu;

    private static int fabStatus = 0;


    private AHBottomNavigationAdapter mNavAdapter;
    private Fragment currentFragment;
    private AHViewpagerAdapter mViewpagerAdapter;

    private boolean hideFunctionEnabled;//隐藏功能可用状态
    private boolean hideFab;//浮动按钮可用状态

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        initViews();
        new MainPresenter(this);
        presenter.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideFunctionEnabled = getSharedPreferences(MyConstants.USER_SETTINGS, MODE_PRIVATE).getBoolean("hide_function", false);
        hideFab = getSharedPreferences(MyConstants.USER_SETTINGS, MODE_PRIVATE).getBoolean("hide_fab", false);
        Log.d(TAG, "隐藏功能开启: " + hideFunctionEnabled);
        Log.d(TAG, "浮动按钮隐藏: " + hideFab);
        if (hideFunctionEnabled){
            mIvDrive.setVisibility(View.VISIBLE);
        }else{
            mIvDrive.setVisibility(View.GONE);
        }

        if (hideFab){
            mFAB.setVisibility(View.GONE);
        }else{
            mFAB.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void initViews() {
        //showAnimation();
        initToolbar();
        initBottomNav();
        initViewPager();
        initPopupMenu();

        initRxBinding();
    }

    private void initRxBinding() {
        RxView.clicks(mIvMenu)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        mPopupMenu.show();
                    }
                });

        RxView.clicks(mIvDrive)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        toGankGirlsActivity();
                    }
                });
    }

    private void initPopupMenu() {
        mPopupMenu = new PopupMenu(this, findViewById(R.id.iv_main_menu));
        mMenu = mPopupMenu.getMenu();

        //通过xml文件添加菜单
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, mMenu);

        mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_main_about:
                        //BaseApplication.showToast("clicked menu setting");
                        toAboutActivity();
                        break;
                    case R.id.menu_main_setting:
                        toSettingsActivity();
                }
                return false;
            }
        });
    }

    private void initToolbar() {
        mTitle.setText(R.string.title_today);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void initViewPager() {
        mViewPager.setPagingEnabled(false);//禁止滑动
        mViewPager.setOffscreenPageLimit(4);//
        mViewpagerAdapter = new AHViewpagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mViewpagerAdapter);
        currentFragment = mViewpagerAdapter.getCurrentFragment();
    }

    private void initBottomNav() {

        mNavAdapter = new AHBottomNavigationAdapter(this, R.menu.menu_bottom_navigation);
        mNavAdapter.setupWithBottomNavigation(mBottomNavigation);

        mBottomNavigation.setAccentColor(ActivityCompat.getColor(this, R.color.colorAccent));
        //manage titles
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        //translucent Navigation bar
        mBottomNavigation.setTranslucentNavigationEnabled(true);
        // Use colored navigation with circle reveal effect
        //mBottomNavigation.setColored(true);
        //mBottomNavigation.setColoredModeColors(getResources().getColor(R.color.orange_500), getResources().getColor(R.color.orange_700));
        mBottomNavigation.setSelectedBackgroundVisible(true);

        mBottomNavigation.manageFloatingActionButtonBehavior(mFAB);

        //setListener
        mBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                if (currentFragment == null) {
                    currentFragment = mViewpagerAdapter.getCurrentFragment();
                }

                        mViewPager.setCurrentItem(position, false);
                        currentFragment = mViewpagerAdapter.getCurrentFragment();
                        switch (position){
                            case 0:
                                mTitle.setText(R.string.title_today);


                                if (!hideFab){
                                    mFAB.setImageResource(R.mipmap.ic_search_white_24dp);
                                    mFAB.setVisibility(View.VISIBLE);
                                    fabStatus = 0;
                                }

                                break;
                            case 1:
                                mTitle.setText(R.string.title_one_moment);


                                if (!hideFab){
                                    mFAB.setImageResource(R.mipmap.ic_shuffle_white_24dp);
                                    mFAB.setVisibility(View.VISIBLE);
                                    fabStatus = 1;
                                }
                                break;
                            case 2:
                                mTitle.setText(R.string.title_guokr);
                                if (!hideFab){
                                    mFAB.setImageResource(R.mipmap.ic_shuffle_white_24dp);
                                    mFAB.setVisibility(View.VISIBLE);
                                    fabStatus = 2;
                                }
                                break;
                        }

                        return true;
                }
        });

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fabStatus){
                    case 0:
                        showDatePickDialog();
                        break;
                    case 1:
                        EventBus.getDefault().post(EventRandomOneMomentArticle.newInstance(null));
                        break;
                    case 2:
                        EventBus.getDefault().post(EventRandomGuokrArticle.newInstance(null));
                        break;
                    default:
                        BaseApplication.showToast("curr status: error!!!");
                        break;
                }
            }
        });

    }

   /* @OnClick(R2.id.iv_main_menu)
    void onClickMenu(){
        mPopupMenu.show();
    }*/

    /*@OnClick(R2.id.iv_main_drive)
    void onClickDrive(){
        toGankGirlsActivity();
    }*/


    @Subscribe
    public void onEventShowSnackbar(EventShowSnackbar event){
        Snackbar.make(mBottomNavigation, event.getMsg(), MyConstants.DEFAULT_TIME_OUT)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1024){
            if (resultCode == 200){
                Log.d(TAG, "从日期选择Activity返回数据成功!" + data.getStringExtra("date"));
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showDatePickDialog() {
        presenter.showDatePickDialog(getSupportFragmentManager());
    }

    private void toAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void toGankGirlsActivity() {
        Intent intent = new Intent(MainActivity.this, GankGirlsActivity.class);
        startActivity(intent);
    }

    private void toSettingsActivity() {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }


    private long firstTime;
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000){
            BaseApplication.showToast(getString(R.string.double_click_quit));
            firstTime = secondTime;
        }else{
            finish();
        }

    }

    @Override
    public void setPresenter(MainContract.IMainPresenter mPresenter) {
        this.presenter = mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        startPersistentService();
    }

    private void startPersistentService(){
        Intent intent = new Intent(this, PersistentService.class);
        startService(intent);
    }
}

