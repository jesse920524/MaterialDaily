package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-16.
 * 为了实现今日新闻列表页上拉加载更多,
 * 现在知乎日报今日新闻和往期新闻公用一个entity了.
 */

public interface IZHNewsModel {

    /**
     * 获取知乎日报今日新闻*/
    void getLatestNews(onZHNewsStoryEntityLoadedListener loadedListener);

    /**
     * 将今日新闻Bean转为enentiy*/
    List<ZHNewsStoryEntity> convertBean2Entity(ZHLatestNewsBean bean);

    /**
     * 获取知乎日报往期新闻*/
    void getPastNews(onZHNewsStoryEntityLoadedListener loadedListener);

    /**获取知乎日报指定日期新闻*/
    void getSpecificDateNews(onZHNewsStoryEntityLoadedListener listener, String date);
    /**
     * 将往期新闻Bean转为entity*/
    List<ZHNewsStoryEntity> convertBean2Entity(ZHPastNewsBean bean);

    void onDestroy();

    /**知乎日报今日,往期,指定日期新闻的回调*/
    interface onZHNewsStoryEntityLoadedListener{
        void onSuccess(List<ZHNewsStoryEntity> entities);

        void onSuccessMore(List<ZHNewsStoryEntity> entities);

        void onSuccessSpecificDate(List<ZHNewsStoryEntity> entities);

        void onError();

        void onNetworkError();
    }

}
