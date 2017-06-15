package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.model.api.httpMethods.HttpMethodGuokr;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilConnection;
import rx.Subscriber;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public class GuokrNewsModelImpl implements IGuokrNewsModel {
    private static final String TAG = GuokrNewsModelImpl.class.getSimpleName();

    private Subscriber<GuokrNewsBean> subscriber;

    @Override
    public void getGuokrNews(final OnGuokrNewsLoadedListener listener, String retrieve_type, String category, int limit, int ad) {
        subscriber = new Subscriber<GuokrNewsBean>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted exec");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError exec");
                if (!UtilConnection.getNetworkState()){
                    listener.onNetworkError();
                }else{
                    listener.onError(e.getMessage());
                }
            }

            @Override
            public void onNext(GuokrNewsBean guokrNewsBean) {
                Log.d(TAG, "onNext exec " + guokrNewsBean.toString());
                listener.onSuccess(convertBean2Entities(guokrNewsBean));
            }
        };
        HttpMethodGuokr.getInstance().getGuokrNewsList(subscriber, retrieve_type, category, limit, ad);
    }

    @Override
    public List<GuokrNewsEntity> convertBean2Entities(GuokrNewsBean bean) {
        List<GuokrNewsEntity> list = new ArrayList<>();
        for (GuokrNewsBean.ResultBean resultBean : bean.getResult()){
            GuokrNewsEntity entity = new GuokrNewsEntity();
            entity.setId(Long.valueOf(resultBean.getId()));
            entity.setTitle(resultBean.getTitle());
            entity.setCategory(resultBean.getCategory());
            entity.setDatePicked(resultBean.getDatePicked());
            entity.setHeadline_img(resultBean.getHeadlineImg());
            entity.setLink(resultBean.getLink());
            entity.setStyle(resultBean.getStyle());

            list.add(entity);
        }

        return list;
    }
}
