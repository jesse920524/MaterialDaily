package androiddeveloper.the.jessefu.mvpactualcombat.biz.settings;

import android.content.SharedPreferences;
import android.support.v7.preference.Preference;
import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class SettingPresenter implements SettingsContract.ISettingsPresenter {

    private static final String TAG = SettingPresenter.class.getSimpleName();
    private SettingsContract.ISettingsView view;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SettingPresenter(SettingsContract.ISettingsView view) {
        this.view = view;
    }

    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {
        sp = BaseApplication.getContext().getSharedPreferences(MyConstants.USER_SETTINGS,MODE_PRIVATE);
        editor = sp.edit();
    }

    @Override
    public void setNoPicMode(Preference preference) {
        editor.putBoolean("no_pic_mode", preference.getSharedPreferences().getBoolean("no_pic_mode", false));
        editor.apply();
    }

    @Override
    public void setHideFunction(Preference preference) {
        editor.putBoolean("hide_function", preference.getSharedPreferences().getBoolean("hide_function", false));
        editor.apply();
    }

    @Override
    public void clearCache() {

        view.showClearCacheResult();


    }

    @Override
    public void setHideFab(Preference preference) {
        editor.putBoolean("hide_fab", preference.getSharedPreferences().getBoolean("hide_fab", false));
        editor.apply();
    }


}
