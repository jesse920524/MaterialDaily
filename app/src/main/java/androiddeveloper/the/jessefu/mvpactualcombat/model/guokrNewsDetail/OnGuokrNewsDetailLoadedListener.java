package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

/**
 * Created by Jesse Fu on 2017-05-01.
 */

public interface OnGuokrNewsDetailLoadedListener {

    void onSuccessGK(String detailBean, String articleId);

    void onError(String errMsg);
}
