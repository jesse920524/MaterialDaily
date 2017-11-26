package androiddeveloper.the.jessefu.mvpactualcombat.base;

/**
 * Created by Jesse Fu on 2017/2/19.
 */

public interface BaseView<T> {

    void setPresenter(T mPresenter);

    void showLoading();

    void dismissLoading();
}
