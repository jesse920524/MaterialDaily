package androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsActivity extends AppCompatActivity {
    private static final String TAG = GankGirlsActivity.class.getSimpleName();

    private GankGirlsFragment gankGirlsFragment;

    @BindView(R2.id.tb_gankgirls)
    Toolbar mToolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_girls);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {

        initFragment();
        mToolbar.setTitle("福利");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    /**初始化fragment*/
    private void initFragment() {
        gankGirlsFragment = GankGirlsFragment.newInstance("arg");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.layout_gankgirls_container, gankGirlsFragment)
                .commit();
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
