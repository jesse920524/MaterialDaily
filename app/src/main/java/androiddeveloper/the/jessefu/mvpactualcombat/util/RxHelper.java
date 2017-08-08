package androiddeveloper.the.jessefu.mvpactualcombat.util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017-08-06.
 */

public class RxHelper {

    public static  <T extends Object> Observable<T> shiftSchedulers(Observable<T> observable){
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public class MyDisposableContainer implements DisposableContainer{

        @Override
        public boolean add(Disposable d) {
            return true;
        }

        @Override
        public boolean remove(Disposable d) {
            return true;
        }

        @Override
        public boolean delete(Disposable d) {
            return true;
        }
    }
}
