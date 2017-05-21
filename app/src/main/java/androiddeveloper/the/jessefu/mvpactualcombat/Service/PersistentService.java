package androiddeveloper.the.jessefu.mvpactualcombat.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;

/**
 * Created by Jesse Fu on 2017-05-13.
 * 根据已持久化的列表页数据,持久化与其对应的详情页数据
 */

public class PersistentService extends Service {
    private static final String TAG = PersistentService.class.getSimpleName();

    private IPersistentHelper persistentHelper;


    @Override
    public void onCreate() {
        super.onCreate();
        persistentHelper = new PersistentHelperImpl();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        persistentHelper.start();
        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        persistentHelper = null;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
