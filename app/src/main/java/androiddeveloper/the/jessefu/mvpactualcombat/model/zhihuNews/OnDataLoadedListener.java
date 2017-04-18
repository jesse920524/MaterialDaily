package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-16.
 */

public interface OnDataLoadedListener {

    /**知乎日报今日,往期新闻的回调*/
    interface onZHNewsStoryEntityLoadedListener{
        void onSuccess(List<ZHNewsStoryEntity> entities);

        void onSuccessMore(List<ZHNewsStoryEntity> entities);

        void onError();
    }

}
