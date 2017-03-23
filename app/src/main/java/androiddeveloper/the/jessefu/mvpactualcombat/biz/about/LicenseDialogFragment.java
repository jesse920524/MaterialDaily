package androiddeveloper.the.jessefu.mvpactualcombat.biz.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jesse Fu on 2017/3/23 0023.
 */

public class LicenseDialogFragment extends DialogFragment {
    private static final String TAG = LicenseDialogFragment.class.getSimpleName();

    @BindView(R2.id.tv_dialog_license_title)
    TextView mTitle;
    @BindView(R2.id.wv_dialog_license)
    WebView mWebView;
    @BindView(R2.id.btn_dialog_license_confirm)
    Button mBtnConfirm;

    View mRoot;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.dialog_license, container, false);
        ButterKnife.bind(this, mRoot);
        initViews(mRoot);
        return mRoot;
    }

    private void initViews(View view) {
        String url = "file:///android_asset/html/license.html";
        mWebView.loadUrl(url);
    }

    @OnClick(R2.id.btn_dialog_license_confirm)
    void onClickConfirm(){
        this.dismiss();
    }
}
