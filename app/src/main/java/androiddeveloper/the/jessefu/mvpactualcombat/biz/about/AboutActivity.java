package androiddeveloper.the.jessefu.mvpactualcombat.biz.about;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jude.swipbackhelper.SwipeBackHelper;

import org.greenrobot.eventbus.EventBus;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/7 0007.
 */

public class AboutActivity extends AppCompatActivity {

    private static final String TAG = AboutActivity.class.getSimpleName();

    private AboutFragment aboutFragment;

    @BindView(R2.id.tb_about)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);

        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this)
                .setSwipeEdgePercent(0.2f)
                .setSwipeSensitivity(0.5f);

        initViews();
        initFragment();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }


    private void initFragment() {
        if (aboutFragment == null){
            aboutFragment = new AboutFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.layout_about_frame, aboutFragment)
                    .commit();
            //发送消息给fragment,收到消息时初始化presenter
            EventBus.getDefault().post(aboutFragment);
            //new AboutPresenter(aboutFragment);
        }
    }

    private void initViews() {
        mToolbar.setContentInsetStartWithNavigation(0);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
