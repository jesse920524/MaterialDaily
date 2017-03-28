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

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

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

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            showRequestPermissionAlertDialog();
            Log.d(TAG, "check exec");
        }
    }

    private void showRequestPermissionAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("about permission")
                .setIcon(R.mipmap.ic_app_launcher)
                .setMessage("\n如果您需要把图片下载到本地的功能,\n请允许WRITE_EXTERNAL_STORAGE权限!")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        initPermissions();
                    }
                }).show();
    }
    /**android6.0动态获取权限方法,使用了开源类库permissionGen*/
    public void initPermissions() {
        //测试mPermissions权限库
        PermissionGen.with(GankGirlsActivity.this)
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

    }
    @PermissionFail(requestCode=200)
    public void failGetPermission(){
    }
}
