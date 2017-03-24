package androiddeveloper.the.jessefu.mvpactualcombat.biz.about;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
        Preference prefGithubAddress = findPreference("github_address");

        prefSupportDetail.setOnPreferenceClickListener(this);
        prefOpenResourceLicense.setOnPreferenceClickListener(this);
        prefStarMeZhihu.setOnPreferenceClickListener(this);
        prefGithubAddress.setOnPreferenceClickListener(this);
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
                //clipName();
                followOnZhihu();
                break;
            case "github_address":
                openInBrowser();
                break;
            case "support_detail":
                sendFeedbackEmail();
                break;

        }
        return true;
    }

    /**在浏览器打开github*/
    private void openInBrowser() {
        try{
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://github.com/jesse920524/ZhihuDailyMvp"));
            getActivity().startActivity(intent);
        }catch(Exception e){
            showOpenGithubError();
        }

    }

    /**复制到剪贴板*/
    private void clipName() {
        ClipboardManager clipboardManager = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
        String authorName = "傅堯";
        ClipData clipData = ClipData.newPlainText("name", authorName);
        clipboardManager.setPrimaryClip(clipData);
        Snackbar.make(mToolbar, "复制到剪贴板成功", Snackbar.LENGTH_SHORT).show();
    }

    private void followOnZhihu(){
        try {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://www.zhihu.com/people/jesse920524/")));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showOpenLicense() {
        LicenseDialogFragment fragment = new LicenseDialogFragment();
        fragment.show(getActivity().getSupportFragmentManager(), "license");
    }

    private void sendFeedbackEmail(){
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("设备型号: ")
                    .append(Build.MODEL)
                    .append("\n")
                    .append("SDK版本: ")
                    .append(Build.VERSION.RELEASE)
                    .append("\n")
                    .append(getString(R.string.version_summary));

            Uri uri = Uri.parse("mailto:jesse920524@163.com");
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_msg));
            intent.putExtra(Intent.EXTRA_TEXT, sb.toString());
            startActivity(intent);
        }catch (Exception e){
            showFeedbackError();
        }
    }

    @Override
    public void showFeedbackError() {
        Snackbar.make(mToolbar, "未安装邮件类app", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showOpenGithubError() {
        Snackbar.make(mToolbar, "未安装浏览器", Snackbar.LENGTH_SHORT).show();
    }

}
