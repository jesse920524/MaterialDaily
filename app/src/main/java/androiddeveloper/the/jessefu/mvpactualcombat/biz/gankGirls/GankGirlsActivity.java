package androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.jude.swipbackhelper.SwipeBackHelper;
import com.tbruyelle.rxpermissions2.RxPermissions;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsActivity extends AppCompatActivity {
    private static final String TAG = GankGirlsActivity.class.getSimpleName();

    private GankGirlsFragment gankGirlsFragment;

    @BindView(R2.id.tb_gankgirls)
    Toolbar mToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_girls);
        ButterKnife.bind(this);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeEdgePercent(0.2f)
                .setSwipeSensitivity(0.5f);

        initViews();
        checkPermission();
    }

    private void initViews() {

        initFragment();
        mToolbar.setTitle("福利");
        mToolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    /**初始化fragment*/
    private void initFragment() {
        gankGirlsFragment = GankGirlsFragment.newInstance("arg");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.layout_gankgirls_container, gankGirlsFragment)
                .commit();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void initPermissions(){
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean){
                            dialog.dismiss();
                        }else{
                            finish();
                        }
                    }
                });
    }
    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            showRequestPermissionAlertDialog();
            Log.d(TAG, "check exec");
        }
    }

    private AlertDialog dialog;
    private void showRequestPermissionAlertDialog() {
        dialog = new AlertDialog.Builder(this)
                .setTitle("about permission")
                .setIcon(R.mipmap.ic_app_launcher)
                .setMessage("\n如果您需要把图片下载到本地的功能,\n请允许WRITE_EXTERNAL_STORAGE权限!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        initPermissions();
                    }
                }).create();
        dialog.show();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }
}
