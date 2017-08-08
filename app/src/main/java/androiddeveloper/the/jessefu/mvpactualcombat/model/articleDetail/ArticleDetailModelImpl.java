package androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.listener.OnDataLoadedListener;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodsZhihu;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by Jesse Fu on 2017/3/3 0003.
 */

public class ArticleDetailModelImpl implements IArticleDetailModel {

    private static final String TAG = ArticleDetailModelImpl.class.getSimpleName();

//    private Subscriber<ArticleDetailBean> subscriber;
    private Observer<ArticleDetailBean> observer;

    @Override
    public void getArticleDetail(final OnDataLoadedListener  listener, String id) {
        /*subscriber = new Subscriber<ArticleDetailBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取文章详情 omCompleted: ");
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, "获取文章详情 onError: " + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onNext(ArticleDetailBean articleDetailBean) {
                Log.d(TAG, "获取文章详情 onNext: " + articleDetailBean);
                listener.onSuccessZH(articleDetailBean);
            }
        };*/

        observer = new Observer<ArticleDetailBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(@NonNull ArticleDetailBean articleDetailBean) {
                Log.d(TAG, "获取文章详情 onNext: " + articleDetailBean);
                listener.onSuccessZH(articleDetailBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "获取文章详情 onError: " + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "获取文章详情 omCompleted: ");
            }
        };
        HttpMethodsZhihu.getInstance().getArticleDetail(observer, id);
    }

}
