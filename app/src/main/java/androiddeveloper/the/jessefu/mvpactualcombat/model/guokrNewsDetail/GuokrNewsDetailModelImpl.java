package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodGuokr;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;


/**
 * Created by Jesse Fu on 2017-05-01.
 */

public class GuokrNewsDetailModelImpl implements IGuokrDetailModel {
    private static final String TAG = GuokrNewsDetailModelImpl.class.getSimpleName();

//    private Subscriber<String> subscriber;
    private Observer<String> observer;
    @Override
    public void getGuokrNewsDetail(final IGuokrDetailModel.OnGuokrNewsDetailLoadedListener listener, final String articleId) {
        /*subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted exec");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError exec  " + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onNext(String detailBean) {
                Log.d(TAG, "onNext exec  " + detailBean.toString());
                listener.onSuccessGK(detailBean, articleId);
            }
        };*/
        observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d(TAG, "onNext exec  " + s);
                listener.onSuccessGK(s, articleId);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "onError exec  " + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        };
        HttpMethodGuokr.getInstance(true).getGuokrNewsDetail(observer, articleId);
    }
}
