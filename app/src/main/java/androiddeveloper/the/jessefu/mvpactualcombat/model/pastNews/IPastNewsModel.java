package androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */

public interface IPastNewsModel {
    //获取最新文章列表
    void getPastNews(PastNewsModelImpl.onDataLoadedListener loadedListener, String date);

    //将最新文章列表LatestNewsBean的StoriesBean映射为StoryEntity集合
    List<PastNewsStoryEntity> convertBean2Entity(PastNewsBean pastNewsBean);

    //持久化StoryEntity
    void saveStoryEntity(List<PastNewsStoryEntity> entities);

    //得到本地持久化的StoryEntity
    List<PastNewsStoryEntity> getStoryEntity();

    void deleteStoryEntity();
}
