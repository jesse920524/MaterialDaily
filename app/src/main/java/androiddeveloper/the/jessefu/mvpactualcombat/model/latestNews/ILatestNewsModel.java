package androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/2/24 0024.
 */

public interface ILatestNewsModel {

    //获取最新文章列表
    void getLatestNews(LatestNewsModelImpl.onDataLoadedListener loadedListener);

    //将最新文章列表LatestNewsBean的StoriesBean映射为StoryEntity集合
    List<LatestNewsStoryEntity> convertLatestNewsToStoryEntity(LatestNewsBean latestNewsBean);

    //持久化StoryEntity
    void saveStoryEntity(List<LatestNewsStoryEntity> latestNewsStoryEntityList);

    //得到本地持久化的StoryEntity
    List<LatestNewsStoryEntity> getStoryEntity();

    void deleteStoryEntity();





}
