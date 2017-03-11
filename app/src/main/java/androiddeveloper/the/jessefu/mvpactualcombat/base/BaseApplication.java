package androiddeveloper.the.jessefu.mvpactualcombat.base;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import org.greenrobot.greendao.database.Database;

import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.DaoMaster;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.DaoSession;

/**
 * Created by Jesse Fu on 2017/2/12.
 */

public class BaseApplication extends Application {

    private static Context mContext;

    private static DaoSession daoSession;

    private static Toast mToast;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        initGreenDao();
    }


    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "news-db");
        Database db = devOpenHelper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
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
}
