package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-19.
 * 果壳随机文章事件.
 * 由mainActivity -> GuokrNewsFragment
 */

public class EventRandomGuokrArticle extends BaseEvent{

    private EventRandomGuokrArticle() {

    }

    private EventRandomGuokrArticle(String msg){
        super(msg);
    }

    public static EventRandomGuokrArticle newInstance(String msg){
        return new EventRandomGuokrArticle(msg);
    }
}
