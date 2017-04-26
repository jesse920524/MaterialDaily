package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.listener.OnDataLoadedListener;
import androiddeveloper.the.jessefu.mvpactualcombat.model.retrofit.httpMethods.HttpMethodOneMoment;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017/3/16 0016.
 */

public class OneMomentDetailModelImpl implements IOneMomentDetailModel {

    private static final String TAG = OneMomentDetailModelImpl.class.getSimpleName();

    private Subscriber<OneMomentDetailBean> subscriber;

    @Override
    public void getOneMomentDetailBean(final OnDataLoadedListener listener, String id) {
        subscriber = new Subscriber<OneMomentDetailBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "获取一刻文章详情: oCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(TAG, "获取一刻文章详情: onError()" + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onNext(OneMomentDetailBean bean) {
                Log.d(TAG, "获取一刻文章详情: onNext() " + bean);
                listener.onSuccess(bean);
            }
        };
        HttpMethodOneMoment.getInstance().getOneMomentDetail(subscriber, id);

    }

}
