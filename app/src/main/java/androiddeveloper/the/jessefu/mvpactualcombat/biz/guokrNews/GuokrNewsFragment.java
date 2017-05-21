package androiddeveloper.the.jessefu.mvpactualcombat.biz.guokrNews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.adapter.RecyclerGuokrNewsAdapter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.webView.WebviewActivity;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import androiddeveloper.the.jessefu.mvpactualcombat.event.EventRandomGuokrArticle;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public class GuokrNewsFragment extends BaseFragment implements GuokrNewsContract.GuokrNewsView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = GuokrNewsFragment.class.getSimpleName();

    private View mRoot;
    @BindView(R2.id.layout_gn_swipe)
    SwipeRefreshLayout mSwiper;
    @BindView(R2.id.rv_gn)
    RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerGuokrNewsAdapter mRecyclerViewAdapter;

    private GuokrNewsContract.GuokrNewsPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_guokr_news, container, false);
        ButterKnife.bind(this, mRoot);
        initViews(mRoot);
        presenter = new GuokrNewsPresenter(this);
        presenter.start();
        return mRoot;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 随机文章*/
    @Subscribe
    public void onEventRandomArticle(EventRandomGuokrArticle event){
        try{
            GuokrNewsEntity entity = mRecyclerViewAdapter.getData().get((int) (Math.random()*mRecyclerViewAdapter.getData().size()));
            Intent intent = new Intent(getActivity(), WebviewActivity.class);
            intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
            intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_GUOKR);
            startActivity(intent);
        }catch (Exception e){
            BaseApplication.showToast("noting to show");
        }

                ;
    }
    private void initViews(View view) {
        mSwiper.setColorSchemeColors(ActivityCompat.getColor(getActivity(), R.color.colorAccent));
        mSwiper.setOnRefreshListener(this);
        mSwiper.setProgressViewOffset(false, 0, 200);

        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerViewAdapter = new RecyclerGuokrNewsAdapter(R.layout.item_guokr, null);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                GuokrNewsEntity entity = (GuokrNewsEntity) adapter.getData().get(position);
                Intent intent = new Intent(getActivity(), WebviewActivity.class);
                intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
                intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_GUOKR);
                startActivity(intent);
            }
        });
        mRecyclerViewAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    @Override
    public void setPresenter(GuokrNewsContract.GuokrNewsPresenter presenter) {
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

    public static GuokrNewsFragment newInstance(String arg){
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.FRAGMENT_ARGUMENNT, arg);
        GuokrNewsFragment instance = new GuokrNewsFragment();
        instance.setArguments(bundle);
        return instance;
    }

    @Override
    public void onRefresh() {
        presenter.start();
    }

    @Override
    public void showData(List<GuokrNewsEntity> entities) {
        if (entities.size() > 0){
            mRecyclerViewAdapter.setNewData(entities);
            mRecyclerViewAdapter.loadMoreComplete();
        }else{
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_empty, null);
            mRecyclerViewAdapter.setEmptyView(view);
        }

    }

    @Override
    public void showError(String errMsg) {
        BaseApplication.showToast(errMsg);
    }

    @Override
    public void toWebActivity(Context c, GuokrNewsEntity entity) {
        Intent intent = new Intent(c, WebviewActivity.class);
        intent.putExtra(MyConstants.ARTICLE_TYPE, MyConstants.ARTICLE_TYPE_GUOKR);
        intent.putExtra(MyConstants.SERIALIZABLE_ITEM, entity);
        c.startActivity(intent);
    }

    @Override
    public void getDataError(String errMsg) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_empty, null);
        mRecyclerViewAdapter.setEmptyView(view);
    }
}
