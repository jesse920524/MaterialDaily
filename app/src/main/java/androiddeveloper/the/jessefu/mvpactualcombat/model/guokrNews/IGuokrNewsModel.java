package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews;

import java.util.List;

/**
 * Created by Jesse Fu on 2017-04-30.
 */

public interface IGuokrNewsModel {

    void getGuokrNews(OnGuokrNewsLoadedListener listener, String retrieve_type, String category, int limit, int ad);

    //将bean转为entity集合
    List<GuokrNewsEntity> convertBean2Entities(GuokrNewsBean bean);
}
