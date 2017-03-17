package androiddeveloper.the.jessefu.mvpactualcombat.biz.oneMoment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerOneMomentAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.webView.WebviewActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment.OneMomentEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class OneMomentFragment extends BaseFragment implements OneMomentContract.IOneMomentView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = OneMomentFragment.class.getSimpleName();
    private OneMomentContract.IOneMomentPresenter presenter;

    @BindView(R2.id.layout_om_swiper)
    SwipeRefreshLayout mSwiper;
    @BindView(R2.id.rv_om)
    RecyclerView mRecyclerView;

    private View mRoot;
    private RecyclerOneMomentAdapter mRecyclerViewAdapter;
    public LinearLayoutManager linearLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       mRoot = inflater.inflate(R.layout.fragment_one_moment, container, false);
        ButterKnife.bind(this, mRoot);
        initViews();
        new OneMomentPresenter(this);
        presenter.start();
        return mRoot;
    }

    private void initViews() {
        //init recycerView
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                OneMomentEntity oneMomentEntity = (OneMomentEntity) adapter.getData().get(position);
                toWebActivity(oneMomentEntity);
            }
        });
        mRecyclerViewAdapter = new RecyclerOneMomentAdapter(null);
        mRecyclerViewAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getDataMore();
            }
        });
        mRecyclerView.setAdapter(mRecyclerViewAdapter);


        //init swipe
        mSwiper.setColorSchemeColors(MyConstants.COLORS);
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);

    }


    private void toWebActivity(OneMomentEntity oneMomentEntity) {
        Intent intent = new Intent(getActivity(), WebviewActivity.class);
        intent.putExtra(MyConstants.SERIALIZABLE_ITEM, oneMomentEntity);
        intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_ONEMOMENT);
        startActivity(intent);
    }

    @Override
    public void setPresenter(OneMomentContract.IOneMomentPresenter presenter) {
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
        mSwiper.post(new Runnable() {
            @Override
            public void run() {
                mSwiper.setRefreshing(false);
            }
        });
        //mRecyclerViewAdapter.loadMoreFail();
    }

    public static OneMomentFragment newInstance(String arg){
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.FRAGMENT_ARGUMENNT, arg);
        OneMomentFragment oneMomentFragment = new OneMomentFragment();
        oneMomentFragment.setArguments(bundle);
        return oneMomentFragment;
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    @Override
    public void onRefresh() {
        presenter.start();
    }

    @Override
    public void getData(List<OneMomentEntity> entities) {
        mRecyclerViewAdapter.setNewData(entities);
        mSwiper.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwiper.setEnabled(true);
            }
        }, MyConstants.DEFAULT_DELAY_TIME);
    }

    @Override
    public void getDataMore(final List<OneMomentEntity> entities) {
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRecyclerViewAdapter.addData(entities);
                mRecyclerViewAdapter.loadMoreComplete();
            }
        });
    }

    @Override
    public void getDataError(String errMsg) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_empty, null);
        mRecyclerViewAdapter.setEmptyView(view);
    }

    @Override
    public void getDataMoreError(String errMsg) {
        mRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                mRecyclerViewAdapter.loadMoreFail();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroy();
    }
}
