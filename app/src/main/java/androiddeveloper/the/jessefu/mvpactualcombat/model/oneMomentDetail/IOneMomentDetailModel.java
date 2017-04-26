package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail;

import androiddeveloper.the.jessefu.mvpactualcombat.model.listener.OnDataLoadedListener;

/**
 * Created by Jesse Fu on 2017/3/16 0016.
 */

public interface IOneMomentDetailModel {

    void getOneMomentDetailBean(OnDataLoadedListener listener, String id);
}
