package androiddeveloper.the.jessefu.mvpactualcombat.biz.settings;

import android.os.Bundle;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androiddeveloper.the.jessefu.mvpactualcombat.R;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.ISettingsView, Preference.OnPreferenceClickListener {
    private static final String TAG = SettingsFragment.class.getSimpleName();

    private SettingsContract.ISettingsPresenter presenter;

    /**
     * Called during {@link #onCreate(Bundle)} to supply the preferences for this fragment.
     * Subclasses are expected to call {@link #setPreferenceScreen(PreferenceScreen)} either
     * directly or via helper methods such as {@link #addPreferencesFromResource(int)}.
     *
     * @param savedInstanceState If the fragment is being re-created from
     *                           a previous saved state, this is the state.
     * @param rootKey            If non-null, this preference fragment should be rooted at the
     *                           {@link PreferenceScreen} with this key.
     */
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        EventBus.getDefault().register(this);
        addPreferencesFromResource(R.xml.fragment_settings);

        findPreference("no_pic_mode").setOnPreferenceClickListener(this);
        findPreference("hide_function").setOnPreferenceClickListener(this);
        findPreference("clear_pic_cache").setOnPreferenceClickListener(this);

        presenter = new SettingPresenter(this);
        presenter.start();
    }

    /**
     * Called when a Preference has been clicked.
     *
     * @param preference The Preference that was clicked.
     * @return True if the click was handled.
     */
    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()){
            case "no_pic_mode":
                boolean b = preference.getSharedPreferences().getBoolean("no_pic_mode", false);
                presenter.setNoPicMode(preference);
                Log.d(TAG, "点击无图模式: " + b);
                break;
            case "hide_function":
                presenter.setHideFunction(preference);
                boolean b1 = preference.getSharedPreferences().getBoolean("hide_function", false);
                break;
            case "clear_pic_cache":
                presenter.clearCache();
                break;
        }
        return true;
    }

    @Subscribe
    public void onEventStartPresenter(SettingsFragment fragment){
        Log.d(TAG, "收到activity传来的消息: 初始化presenter");
        presenter = new SettingPresenter(fragment);
        presenter.start();
    }

    @Override
    public void setPresenter(SettingsContract.ISettingsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showClearCacheResult() {
        //发送事件给activity,activity会显示snackbar
        //EventBus.getDefault().post("清除成功");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
