package androiddeveloper.the.jessefu.mvpactualcombat.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.squareup.leakcanary.RefWatcher;

/**
 * Created by Jesse Fu on 2017/2/12.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    private ConnectivityManager  mConnectivityManager;

    private FragmentManager mFragmentManager;

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//keep screen portrait

        mContext = getActivityContext();

        mRefWatcher = BaseApplication.getRefWatcher(this.getActivityContext());
        mRefWatcher.watch(this);
    }

    /**Activity.this*/
    protected abstract Context getActivityContext();

    public abstract void initViews();

    /***/
    public boolean getNetworkState(){
        boolean flag = false;
        mConnectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mConnectivityManager != null){
            if (mConnectivityManager.getActiveNetworkInfo() != null){
                flag = mConnectivityManager.getActiveNetworkInfo().isAvailable();
            }
        }
        return flag;
    }

    protected FragmentManager getmFragmentManager(){
        return mFragmentManager = getSupportFragmentManager();
    }

    /**
     * 获取屏幕宽度--px*/
    public int getMobileWidth(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int mobileWidth = dm.widthPixels;
        return mobileWidth;
    }

    /**
     * 获取屏幕高度--px*/
    public int getMobileHeight(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int mobileHeight = dm.heightPixels;
        return mobileHeight;
    }

}
