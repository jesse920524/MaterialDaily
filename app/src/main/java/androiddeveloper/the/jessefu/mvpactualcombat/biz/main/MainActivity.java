package androiddeveloper.the.jessefu.mvpactualcombat.biz.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
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

import org.greenrobot.eventbus.EventBus;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.AHViewpagerAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.about.AboutActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls.GankGirlsActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews.LatestNewsFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews.PastNewsFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.settings.SettingsActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themes.ThemeFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

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

    private boolean hideFunctionEnabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        new MainPresenter(this);
        presenter.start();
        initPermissions();
    }

    @Override
    protected void onResume() {
        super.onResume();
         hideFunctionEnabled = getSharedPreferences("user_settings", MODE_PRIVATE).getBoolean("hide_function", false);
        Log.d(TAG, "隐藏功能开启: " + hideFunctionEnabled);
        if (hideFunctionEnabled){
            mIvDrive.setVisibility(View.VISIBLE);
        }else{
            mIvDrive.setVisibility(View.GONE);
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
        //mToolbar.setTitle("今日");

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


        //mBottomNavigation = (AHBottomNavigation) findViewById(R.id.bn_main);

        mNavAdapter = new AHBottomNavigationAdapter(this, R.menu.menu_bottom_navigation);
        mNavAdapter.setupWithBottomNavigation(mBottomNavigation);

        //set background color
        //mBottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.colorPrimary));

        //mBottomNavigation.setAccentColor(R.color.colorAccent);
        //mBottomNavigation.setInactiveColor(R.color.colorAccent);



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
                                mFAB.setImageResource(R.mipmap.ic_shuffle_white_24dp);
                                mFAB.setVisibility(View.VISIBLE);
                                fabStatus = 0;
                                break;
                            case 1:
                                mTitle.setText(R.string.title_one_moment);
                                mFAB.setImageResource(R.mipmap.ic_settings_white_24dp);
                                mFAB.setVisibility(View.INVISIBLE);
                                fabStatus = 1;
                                break;
                            case 2:
                                mTitle.setText(R.string.title_past);
                                mFAB.setImageResource(R.mipmap.ic_search_white_24dp);
                                mFAB.setVisibility(View.VISIBLE);
                                fabStatus = 2;
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
                        /**随机文章
                         * LatestNewsFragment会收到事件*/
                        EventBus.getDefault().post("fab0");
                        break;
                    case 1:
                        break;
                    case 2:
                        showDatePickDialog();
                        break;
                    default:
                        BaseApplication.showToast("curr status: error!!!");
                        break;
                }
            }
        });

    }

    @OnClick(R2.id.iv_main_menu)
    void onClickMenu(){
        mPopupMenu.show();
    }

    @OnClick(R2.id.iv_main_drive)
    void onClickDrive(){
        toGankGirlsActivity();
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

    @Override
    public void onBackPressed() {
        /**
         * 判断滑动位置? 滚回顶部 : 退出程序*/
        //super.onBackPressed();
        if (currentFragment instanceof LatestNewsFragment){

            if (((LatestNewsFragment) currentFragment).getRecyclerViewPosition(((LatestNewsFragment) currentFragment).linearLayoutManager) != 0){
                ((LatestNewsFragment) currentFragment).recyclerViewSmoothScroll();
                mBottomNavigation.restoreBottomNavigation();
            }else{
                finish();
            }


        }else if (currentFragment instanceof ThemeFragment){
            if (((ThemeFragment) currentFragment).getRecyclerViewPosition(((ThemeFragment) currentFragment).gridLayoutManager) != 0){
                ((ThemeFragment) currentFragment).recyclerViewSmoothScroll();
                mBottomNavigation.restoreBottomNavigation();
            }else{
                finish();
            }
        }else if(currentFragment instanceof PastNewsFragment){
            if (((PastNewsFragment) currentFragment).getRecyclerViewPosition(((PastNewsFragment) currentFragment).linearLayoutManager) != 0){
                ((PastNewsFragment) currentFragment).recyclerViewSmoothScroll();
                mBottomNavigation.restoreBottomNavigation();
            }else{
                finish();
            }
        }else{
            finish();
        }
    }

    @Override
    public void setPresenter(MainContract.IMainPresenter presenter) {
        this.presenter = presenter;
    }

    /**android6.0动态获取权限方法,使用了开源类库permissionGen*/
    public void initPermissions() {
        //测试mPermissions权限库
        PermissionGen.with(MainActivity.this)
                .addRequestCode(100)
                .permissions(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                        /*Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_NETWORK_STATE,
                        Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS*/
                ).request();
        //JPushInterface.requestPermission(FirstActivity.this);
    }
    /**
     * 6.0权限请求结果*/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionGen.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }

    @PermissionSuccess(requestCode=100)
    public void successGetPermission(){
        //Toast.makeText(FirstActivity.this, "权限获取成功", Toast.LENGTH_SHORT).show();
        //Dlog.debug("open camera success");

    }
    @PermissionFail(requestCode=200)
    public void failGetPermission(){

        //Toast.makeText(this,"权限获取失败",Toast.LENGTH_SHORT).show();

    }
}

