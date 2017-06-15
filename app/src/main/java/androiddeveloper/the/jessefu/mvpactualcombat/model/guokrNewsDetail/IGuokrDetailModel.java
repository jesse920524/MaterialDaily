package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

/**
 * Created by Jesse Fu on 2017-05-01.
 */

public interface IGuokrDetailModel {
    //根据id获取果壳文章详情
    void getGuokrNewsDetail(OnGuokrNewsDetailLoadedListener listener, String articleId);

    interface OnGuokrNewsDetailLoadedListener {

        void onSuccessGK(String detailBean, String articleId);

        void onError(String errMsg);
    }
}
