package androiddeveloper.the.jessefu.mvpactualcombat.util;

import android.content.Context;
import android.net.ConnectivityManager;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;

/**
 * Created by Jesse Fu on 2017/3/22 0022.
 */

public class UtilManager {
    private static ConnectivityManager mConnectivityManager;
    /***/
    public static boolean getNetworkState(){
        boolean flag = false;
        mConnectivityManager = (ConnectivityManager) BaseApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (mConnectivityManager != null){
            if (mConnectivityManager.getActiveNetworkInfo() != null){
                flag = mConnectivityManager.getActiveNetworkInfo().isAvailable();
            }
        }
        return flag;
    }
}
