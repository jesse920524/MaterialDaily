package androiddeveloper.the.jessefu.mvpactualcombat.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;


import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import org.greenrobot.greendao.database.Database;

import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.DaoMaster;
import androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle.DaoSession;


/**
 * Created by Jesse Fu on 2017/2/12.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    private static DaoSession daoSession;

    private static Toast mToast;

    private static RefWatcher mRefWatcher;



    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        initGreenDao();
        initLeakCanary();
    }

    private void initLeakCanary() {
        if(LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }

    private void initGreenDao() {
        try {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "news-db");
            Database db = devOpenHelper.getWritableDb();
            daoSession = new DaoMaster(db).newSession();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static DaoSession getDaoSession(){
        return daoSession;
    }

    public static Context getContext(){
        return mContext;
    }

    /**
     * show Toast short*/
    public static void showToast(String s){
        if (mToast == null){
            mToast = Toast.makeText(mContext, s, Toast.LENGTH_SHORT);
        }else{
            mToast.setText(s);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * show Toast long*/
    public static void showToastLong(String s){
        if (mToast == null){
            mToast = Toast.makeText(mContext, s, Toast.LENGTH_LONG);
        }else{
            mToast.setText(s);
            mToast.setDuration(Toast.LENGTH_LONG);
        }
        mToast.show();
    }

    /**cancel Toast*/
    public static void cancelToast(){
        if (mToast != null){
            mToast.cancel();
        }
    }

    public static RefWatcher getRefWatcher(Context context){
        return mRefWatcher;
    }
}
