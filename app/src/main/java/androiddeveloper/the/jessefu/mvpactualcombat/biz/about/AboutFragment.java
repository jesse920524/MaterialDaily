package androiddeveloper.the.jessefu.mvpactualcombat.biz.about;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androiddeveloper.the.jessefu.mvpactualcombat.R;

/**
 * Created by Jesse Fu on 2017/3/8 0008.
 */

public class AboutFragment extends PreferenceFragmentCompat implements AboutContract.IAboutView, Preference.OnPreferenceClickListener {

    private static final String TAG = AboutFragment.class.getSimpleName();

    private AboutContract.IAboutPresenter presenter;
    private Toolbar mToolbar;
    private View mRoot;

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
        addPreferencesFromResource(R.xml.fragment_about);
        initViews(getView());
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Subscribe
    public void onEvent(AboutFragment fragment){
        presenter = new AboutPresenter(fragment);
        presenter.start();

    }
    private void initViews(View view) {
        mToolbar = (Toolbar) getActivity().findViewById(R.id.tb_about);

        Preference prefDeveloperName = findPreference("developer_name");
        Preference prefStarMeZhihu = findPreference("star_me_zhihu");
        Preference prefSupportDetail = findPreference("support_detail");
        Preference prefOpenResourceLicense = findPreference("open_resource_license");
        /*prefStarMeZhihu.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                return true;
            }
        });*/

        prefOpenResourceLicense.setOnPreferenceClickListener(this);
        prefStarMeZhihu.setOnPreferenceClickListener(this);
    }

    @Override
    public void setPresenter(AboutContract.IAboutPresenter p) {
        this.presenter = p;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
            case "open_resource_license":
                showOpenLicense();
                break;
            case "star_me_zhihu":
                clipName();
                break;
        }
        return true;
    }

    private void clipName() {
        ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        String authorName = "傅堯";
        ClipData clipData = ClipData.newPlainText("name", authorName);
        clipboardManager.setPrimaryClip(clipData);
        Snackbar.make(mToolbar, "复制到剪贴板成功", Snackbar.LENGTH_SHORT).show();
    }

    private void showOpenLicense() {
        LicenseDialogFragment fragment = new LicenseDialogFragment();
        fragment.show(getActivity().getSupportFragmentManager(), "license");
    }
}
