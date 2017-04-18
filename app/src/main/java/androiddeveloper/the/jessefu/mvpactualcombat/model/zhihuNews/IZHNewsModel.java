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
    void getLatestNews(OnDataLoadedListener.onZHNewsStoryEntityLoadedListener loadedListener);

    /**
     * 将今日新闻Bean转为enentiy*/
    List<ZHNewsStoryEntity> convertBean2Entity(ZHLatestNewsBean bean);

    /**
     * 获取知乎日报往期新闻*/
    void getPastNews(OnDataLoadedListener.onZHNewsStoryEntityLoadedListener loadedListener);

    /**
     * 将往期新闻Bean转为entity*/
    List<ZHNewsStoryEntity> convertBean2Entity(ZHPastNewsBean bean);

    void onDestroy();


}
