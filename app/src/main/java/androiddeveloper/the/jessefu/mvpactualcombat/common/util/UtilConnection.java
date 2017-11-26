package androiddeveloper.the.jessefu.mvpactualcombat.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;


/**
 * Created by Jesse Fu on 2017/3/22 0022.
 */

public class UtilConnection {
    private static ConnectivityManager mConnectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    /**
     * 检查网络是否可用*/
    public static boolean getNetworkState(){
        boolean flag = false;
        if (mConnectivityManager != null){
            if (mConnectivityManager.getActiveNetworkInfo() != null){
                flag = mConnectivityManager.getActiveNetworkInfo().isAvailable();
            }
        }
        return flag;
    }

    /**
     * 检查wifi可用*/
    public static boolean getWifiState(){
        boolean flag = false;
        if (mConnectivityManager != null){
            NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
            if (info.getType() == mConnectivityManager.TYPE_WIFI){
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 检查移动网络可用*/
    public static boolean getMobileData(){
        boolean flag = false;
        if (mConnectivityManager != null){
            NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
                if (info.getType() == mConnectivityManager.TYPE_MOBILE){
                    flag = true;
                }
        }
        return flag;
    }

}
