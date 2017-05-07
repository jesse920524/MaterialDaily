package androiddeveloper.the.jessefu.mvpactualcombat.biz.guokrNews;

import android.content.Context;

import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;
import androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews.GuokrNewsEntity;

import static android.R.attr.category;

/**
 * Created by Jesse Fu on 2017-04-29.
 */

public interface GuokrNewsContract {

    interface GuokrNewsView extends BaseView<GuokrNewsPresenter>{

        void showData(List<GuokrNewsEntity> entities);

        void showError(String errMsg);

        void toWebActivity(Context context, GuokrNewsEntity entity);

        void getDataError(String errMsg);

    }

    interface GuokrNewsPresenter extends BasePresenter{

        void getGuokrNews(String retrieve_type, String category, int limit, int ad);
    }
}
