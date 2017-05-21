package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public interface OnGuokrNewsLoadedListener {

    void onSuccess(List<GuokrNewsEntity> entities);

    void onError(String errMsg);

    void onNetworkError();
}
