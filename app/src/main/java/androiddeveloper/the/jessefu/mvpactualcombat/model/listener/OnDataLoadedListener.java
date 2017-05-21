package androiddeveloper.the.jessefu.mvpactualcombat.model.listener;

import androiddeveloper.the.jessefu.mvpactualcombat.model.articleDetail.ArticleDetailBean;
import androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail.OneMomentDetailBean;

/**
 * Created by Jesse Fu on 2017-04-24.
 */

public interface OnDataLoadedListener {

    void onSuccessZH(ArticleDetailBean articleDetailBean);

    void onSuccessOM(OneMomentDetailBean oneMomentDetailBean);

    void onError(String errMsg);
}
