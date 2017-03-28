package androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews;

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

import java.util.List;
import java.util.Random;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerLatestAdatper;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.webView.WebviewActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews.LatestNewsStoryEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017/2/21.
 */

public class LatestNewsFragment extends BaseFragment implements LatestNewsContract.ILNView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = BaseFragment.class.getSimpleName();

    private LatestNewsContract.ILNPresenter presenter;
    View mRoot;

    @BindView(R2.id.rv_ln)
    RecyclerView mRecyclerView;
    @BindView(R2.id.layout_ln_swipe)
    SwipeRefreshLayout mSwiper;

    private RecyclerLatestAdatper mRecyclerAdapter;
    public LinearLayoutManager linearLayoutManager;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_latest_news, container, false);
        ButterKnife.bind(this, mRoot);
        EventBus.getDefault().register(this);
        initViews();
        new LatestNewsPresenter(this);
        presenter.start();
        Log.d(TAG, "onCreateview");
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
                LatestNewsStoryEntity entity = (LatestNewsStoryEntity) adapter.getData().get(position);
                Log.d(TAG, String.valueOf(entity));
               /* intent.putExtra(MyConstants.ARTICLE_ID, String.valueOf(entity.getId()));
                intent.putExtra(MyConstants.ARTICLE_TITLE, entity.getTitle());*/
                intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
                intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_ZHIHU_LATEST);//传递文章类型
                startActivity(intent);
            }
        });
        mRecyclerAdapter = new RecyclerLatestAdatper(R.layout.item_news, null);
        mRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        //init SwipeRefreshLayout


        mSwiper.setColorSchemeColors(ActivityCompat.getColor(getActivity(), R.color.colorAccent));
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);

    }


    @Override
    public void setPresenter(LatestNewsContract.ILNPresenter presenter) {
        this.presenter = presenter;
    }

    public static LatestNewsFragment newInstance(String arg){
        LatestNewsFragment instance = new LatestNewsFragment();
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

    /**将presenter获取的数据显示到recyclerView上*/
    @Override
    public void getData(List<LatestNewsStoryEntity> latestNewsStoryEntityList) {

        mRecyclerAdapter.setNewData(latestNewsStoryEntityList);

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
        mRecyclerAdapter.setEmptyView(view);
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

    @Subscribe
    public void onEvent(String data){
        if (data.equals("fab0")){
            /**generate random item*/
            int dataSize = mRecyclerAdapter.getData().size();
            int random = new Random().nextInt(dataSize);
            LatestNewsStoryEntity entity = mRecyclerAdapter.getData().get(random);

            Intent intent = new Intent(getActivity(), WebviewActivity.class);
            /*intent.putExtra(MyConstants.ARTICLE_ID, String.valueOf(entity.getId()));
            intent.putExtra(MyConstants.ARTICLE_TITLE, entity.getTitle());*/

            intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
            intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_ZHIHU_LATEST);//传递文章类型
            startActivity(intent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
