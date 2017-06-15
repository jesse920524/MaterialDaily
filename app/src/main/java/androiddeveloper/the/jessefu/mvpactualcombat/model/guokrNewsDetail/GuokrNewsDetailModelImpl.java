package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodGuokr;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017-05-01.
 */

public class GuokrNewsDetailModelImpl implements IGuokrDetailModel {
    private static final String TAG = GuokrNewsDetailModelImpl.class.getSimpleName();

    private Subscriber<String> subscriber;

    @Override
    public void getGuokrNewsDetail(final IGuokrDetailModel.OnGuokrNewsDetailLoadedListener listener, final String articleId) {
        subscriber = new Subscriber<String>() {
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
        };
        HttpMethodGuokr.getInstance(true).getGuokrNewsDetail(subscriber, articleId);
    }
}
