package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-20.
 * EventBus 事件
 * from MainActivity -> OneMomentFragment
 */

public class EventRandomOneMomentArticle extends BaseEvent{


    private EventRandomOneMomentArticle() {
    }

    private EventRandomOneMomentArticle(String msg) {
        super(msg);
    }

    public static EventRandomOneMomentArticle newInstance(String msg){
        return new EventRandomOneMomentArticle(msg);
    }
}
