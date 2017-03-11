package androiddeveloper.the.jessefu.mvpactualcombat.base;

/**
 * Created by Jesse Fu on 2017/2/19.
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

    void showLoading();

    void dismissLoading();
}
