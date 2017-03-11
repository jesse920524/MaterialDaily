package androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods.HttpMethodsZhihu;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class ArticleDetailModelImpl implements IArticleDetailModel {

    private static final String TAG = ArticleDetailModelImpl.class.getSimpleName();

    private Subscriber<ArticleDetailBean> subscriber;

    @Override
    public void getArticleDetail(final onLoadedListener loadedListener, String id) {
        subscriber = new Subscriber<ArticleDetailBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取文章详情 omCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "获取文章详情 onError: " + e.getMessage());
            }

            @Override
            public void onNext(ArticleDetailBean articleDetailBean) {
                Log.d(TAG, "获取文章详情 onNext: " + articleDetailBean);
                loadedListener.onSuccess(articleDetailBean);
            }
        };
        HttpMethodsZhihu.getInstance().getArticleDetail(subscriber, id);
    }

    public interface onLoadedListener{
        void onSuccess(ArticleDetailBean articleDetailBean);
        void onError();
    }
}
