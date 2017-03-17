package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMomentDetail;

/**
 * Created by Jesse Fu on 2017/3/16 0016.
 */

public interface IOneMomentDetailModel {

    void getOneMomentDetailBean(OneMomentDetailModelImpl.onDataLoadedListener loadedListener, String id);
}
