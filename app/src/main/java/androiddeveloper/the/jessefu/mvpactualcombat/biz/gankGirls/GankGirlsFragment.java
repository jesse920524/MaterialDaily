package androiddeveloper.the.jessefu.mvpactualcombat.biz.gankGirls;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerGankGirlsAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic.LargePicActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls.GankGirlsEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsFragment extends BaseFragment implements GankGirlsContract.IGankGirlsView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = GankGirlsFragment.class.getSimpleName();

    private GankGirlsContract.IGankGirlsPresenter presenter;
    View mRoot;

    @BindView(R2.id.layout_gankgirls_swipe)
    SwipeRefreshLayout mSwiper;

    @BindView(R2.id.rv_gankgirls)
    RecyclerView mRecyclerView;

    private RecyclerGankGirlsAdapter mRvAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_gank_girls, container, false);
        ButterKnife.bind(this, mRoot);
        initViews();
        new GankGirlsPresenter(this);
        presenter.start();
        return mRoot;
    }

    private void initViews() {

        mSwiper.setColorSchemeColors(ActivityCompat.getColor(getActivity(), R.color.colorAccent));
        mSwiper.setOnRefreshListener(this);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2, GridLayout.VERTICAL, false);
        //StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                GankGirlsEntity entity = (GankGirlsEntity) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), LargePicActivity.class);
                intent.putExtra(MyConstants.IMAGE_URL, entity.getUrl());
                //主要的语句
                //通过makeSceneTransitionAnimation传入多个Pair
                //每个Pair将一个当前Activity的View和目标Activity中的一个Key绑定起来
                //在目标Activity中会调用这个Key
                /*ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(), view, MyConstants.IMAGE_URL);

                // ActivityCompat是android支持库中用来适应不同android版本的
                ActivityCompat.startActivity(getActivity(), intent, activityOptions.toBundle());*/
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions  = ActivityOptions.makeSceneTransitionAnimation(getActivity(),
                            view, "transition");
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        });
        mRvAdapter = new RecyclerGankGirlsAdapter(R.layout.item_gankgirls, null);
        mRvAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mRecyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                            presenter.getData(0,0);
                    }
                });
            }
        });
        mRvAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mRvAdapter);
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        presenter.start();
    }


    @Override
    public void setPresenter(GankGirlsContract.IGankGirlsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {
        mSwiper.post(new Runnable() {
            @Override
            public void run() {
                mSwiper.setRefreshing(true);
            }
        });
    }

    @Override
    public void dismissLoading() {
        if (mSwiper.isRefreshing()){
            mSwiper.post(new Runnable() {
                @Override
                public void run() {
                    mSwiper.setRefreshing(false);
                }
            });
        }
    }

    @Override
    public void getData(final List<GankGirlsEntity> entities) {
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRvAdapter.setNewData(entities);
            }
        });

    }

    @Override
    public void getDataMore(final List<GankGirlsEntity> entities) {
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRvAdapter.addData(entities);
                mRvAdapter.loadMoreComplete();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public static GankGirlsFragment newInstance(String arg){
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.FRAGMENT_ARGUMENNT, arg);
        GankGirlsFragment gankGirlsFragment = new GankGirlsFragment();
        gankGirlsFragment.setArguments(bundle);
        return gankGirlsFragment;
    }
}
