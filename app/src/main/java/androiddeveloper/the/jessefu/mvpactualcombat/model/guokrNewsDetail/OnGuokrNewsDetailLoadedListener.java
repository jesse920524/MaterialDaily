package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

/**
 * Created by Jesse Fu on 2017-05-01.
 */

public interface OnGuokrNewsDetailLoadedListener {

    void onSuccess(String detailBean);

    void onError(String errMsg);
}
