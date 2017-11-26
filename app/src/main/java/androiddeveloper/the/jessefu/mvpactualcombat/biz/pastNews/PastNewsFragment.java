package androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Date;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerPastNewsAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.webView.WebviewActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews.PastNewsStoryEntity;
import androiddeveloper.the.jessefu.mvpactualcombat.common.util.UtilTime;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public class PastNewsFragment extends BaseFragment implements PastNewsContract.IPastNewsView, SwipeRefreshLayout.OnRefreshListener{
    private static final String TAG = PastNewsFragment.class.getSimpleName();

    private PastNewsContract.IPastNewsPresenter presenter;

    private View mRoot;
    private RecyclerPastNewsAdapter mRecyclerViewAdapter;
    public LinearLayoutManager linearLayoutManager;

    @BindView(R2.id.layout_pn_swipe)
    SwipeRefreshLayout mSwiper;

    @BindView(R2.id.rv_pn)
    RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_past_news, container, false);
        ButterKnife.bind(this, mRoot);
        EventBus.getDefault().register(this);//注册事件接收(日期选择事件)
        initViews();
        new PastNewsPresenter(this);
        presenter.start();
        return mRoot;
    }

    private void initViews() {
        /**
         * 根据网络情况加载本地数据||请求网络数据*/


        //init RecyclerView
        linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getActivity(), WebviewActivity.class);
                PastNewsStoryEntity entity = (PastNewsStoryEntity) adapter.getData().get(position);
                Log.d(TAG, String.valueOf(entity));
                /*intent.putExtra(MyConstants.ARTICLE_ID, String.valueOf(entity.getId()));
                intent.putExtra(MyConstants.ARTICLE_TITLE, entity.getTitle());*/
                intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
                intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_ZHIHU_PAST);
                startActivity(intent);
            }
        });
        mRecyclerViewAdapter = new RecyclerPastNewsAdapter(R.layout.item_news, null);
        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        //init SwipeRefreshLayout
        mSwiper.setColorSchemeColors(ActivityCompat.getColor(getActivity(), R.color.colorAccent));
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);
    }

    @Override
    public void getData(List<PastNewsStoryEntity> pastNewsStoryEntities) {
        mRecyclerViewAdapter.setNewData(pastNewsStoryEntities);
        //mRecyclerViewAdapter.addData(pastNewsStoryEntities);

        mSwiper.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwiper.setEnabled(true);
            }
        }, MyConstants.DEFAULT_DELAY_TIME);
    }

    @Override
    public void getDataError(String errMsg) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_empty, null);
        mRecyclerViewAdapter.setEmptyView(view);
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
    public void recyclerViewSmoothScroll() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    @Override
    public int getRecyclerViewPosition(LinearLayoutManager linearLayoutManager) {
        return linearLayoutManager.findFirstVisibleItemPosition();
    }

    @Override
    public void setPresenter(PastNewsContract.IPastNewsPresenter mPresenter) {
        this.presenter = mPresenter;
    }

    /**
     * 接收并处理消息*/
    @Subscribe
    public void onEvent(String dateInfo){
        showLoading();
        presenter.getYesterdayData(dateInfo);
    }

    public static PastNewsFragment newInstance(String arg){
        PastNewsFragment instance = new PastNewsFragment();
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
        showLoading();
        presenter.getYesterdayData(UtilTime.get8StringDate(new Date()));//刷新的话加载今天的日期,即获取昨天的新闻
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
