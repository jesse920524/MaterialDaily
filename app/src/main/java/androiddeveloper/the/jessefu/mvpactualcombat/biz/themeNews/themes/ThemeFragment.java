package androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerThemesAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.themeNews.themeNews.ThemeNewsActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes.ThemeEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */

public class ThemeFragment extends BaseFragment implements ThemeContract.IThemeView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = ThemeFragment.class.getSimpleName();
    private ThemeContract.IThemePresenter presenter;

    View mRoot;

    @BindView(R2.id.layout_themes_swiper)
    SwipeRefreshLayout mSwiper;

    @BindView(R2.id.rv_themes)
    RecyclerView mRecyclerView;


    private RecyclerThemesAdapter recyclerThemesAdapter;
    public GridLayoutManager gridLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_themes, container, false);
        ButterKnife.bind(this, mRoot);
        initViews();
        presenter = new ThemePresenter(this);
        presenter.start();

        return mRoot;
    }

    private void initViews() {
        gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerThemesAdapter = new RecyclerThemesAdapter(R.layout.item_themes, null);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(recyclerThemesAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                /**获取themeId与themeName,
                 * 传递给列表Activity*/
                int themeId;
                String themeName = null;
                ThemeEntity themeEntity = (ThemeEntity) adapter.getItem(position);
                themeId = themeEntity.getId();
                themeName = themeEntity.getName();

                Intent intent = new Intent(getActivity(), ThemeNewsActivity.class);
                intent.putExtra(MyConstants.THEME_ID, themeId);
                intent.putExtra(MyConstants.THEME_NAME, themeName);
                startActivity(intent);
            }
        });


        mSwiper.setOnRefreshListener(this);
        //init SwipeRefreshLayout

        mSwiper.setColorSchemeColors(MyConstants.COLORS);
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);
    }

    @Override
    public void setPresenter(ThemeContract.IThemePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        mSwiper.setRefreshing(true);
    }

    @Override
    public void dismissLoading() {
        mSwiper.setRefreshing(false);
    }

    @Override
    public void getData(List<ThemeEntity> themeEntities) {
        recyclerThemesAdapter.setNewData(themeEntities);

    }

    @Override
    public int getRecyclerViewPosition(GridLayoutManager gridLayoutManager) {
        return gridLayoutManager.findFirstVisibleItemPosition();
    }

    @Override
    public void recyclerViewSmoothScroll() {
        mRecyclerView.smoothScrollToPosition(0);
    }


    public static ThemeFragment newInstance(String arg){
        ThemeFragment instance = new ThemeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.FRAGMENT_ARGUMENNT, arg);
        instance.setArguments(bundle);
        return instance;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        presenter.start();
    }
}
