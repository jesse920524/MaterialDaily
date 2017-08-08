package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail;

import android.util.Log;

import androiddeveloper.the.jessefu.mvpactualcombat.model.listener.OnDataLoadedListener;
import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodOneMoment;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Jesse Fu on 2017/3/16 0016.
 */

public class OneMomentDetailModelImpl implements IOneMomentDetailModel {

    private static final String TAG = OneMomentDetailModelImpl.class.getSimpleName();

//    private Subscriber<OneMomentDetailBean> subscriber;
    private Observer<OneMomentDetailBean> observer;
    @Override
    public void getOneMomentDetailBean(final OnDataLoadedListener listener, String id) {
        /*subscriber = new Subscriber<OneMomentDetailBean>() {
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
                listener.onSuccessOM(bean);
            }
        };*/

        observer = new Observer<OneMomentDetailBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull OneMomentDetailBean oneMomentDetailBean) {
                Log.d(TAG, "获取一刻文章详情: onNext() " + oneMomentDetailBean);
                listener.onSuccessOM(oneMomentDetailBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                Log.d(TAG, "获取一刻文章详情: onError()" + e.getMessage());
                listener.onError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "获取一刻文章详情: oCompleted()");
            }
        };
        HttpMethodOneMoment.getInstance().getOneMomentDetail(observer, id);
    }

}
