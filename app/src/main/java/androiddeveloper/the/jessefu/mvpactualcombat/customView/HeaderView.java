package androiddeveloper.the.jessefu.mvpactualcombat.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/7 0007.
 * 自定义控件,toolbar中的title
 */

public class HeaderView extends LinearLayout {

    @BindView(R2.id.tv_header_view_title)
    TextView mTitle;

    public HeaderView(Context context) {
        super(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindTo(String title){
        hideOrsetText(mTitle, title);
    }

    private void hideOrsetText(TextView tv, String text) {
        if (text == null || text.equals("")){
            tv.setVisibility(View.GONE);
        }else{
            tv.setText(text);
        }
    }
}
