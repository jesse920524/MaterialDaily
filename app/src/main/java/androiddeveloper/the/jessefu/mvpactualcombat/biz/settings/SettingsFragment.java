package androiddeveloper.the.jessefu.mvpactualcombat.biz.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements SettingsContract.ISettingsView, Preference.OnPreferenceClickListener {
    private static final String TAG = SettingsFragment.class.getSimpleName();

    private SettingsContract.ISettingsPresenter presenter;

    private Toolbar mToolbar;

    private static final int CLEAR_CACHE_DONE = 1;
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CLEAR_CACHE_DONE:
                    Snackbar.make(mToolbar, R.string.clear_cache_done, Snackbar.LENGTH_SHORT)
                            .show();
                    break;
            }
            super.handleMessage(msg);
        }
    };

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
        addPreferencesFromResource(R.xml.fragment_settings);

        findPreference("hide_function").setOnPreferenceClickListener(this);
        findPreference("no_pic_mode").setOnPreferenceClickListener(this);
        findPreference("clear_pic_cache").setOnPreferenceClickListener(this);
        findPreference("hide_fab").setOnPreferenceClickListener(this);


        mToolbar = (Toolbar) getActivity().findViewById(R.id.tb_settings);

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
            case "hide_fab":
                presenter.setHideFab(preference);
                preference.getSharedPreferences().getBoolean("hide_fab", false);
                break;
        }
        return true;
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
       new Thread(new Runnable() {
           @Override
           public void run() {
               Glide.get(BaseApplication.getContext())
                       .clearDiskCache();
               Message message = Message.obtain();
               message.what = CLEAR_CACHE_DONE;
               mHandler.sendMessage(message);
           }
       }).start();
        Glide.get(BaseApplication.getContext())
                .clearMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
