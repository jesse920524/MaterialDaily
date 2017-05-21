package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-20.
 * EventBus 事件
 * from MainActivity -> OneMomentFragment
 */

public class EventRandomOneMomentArticle {

    private String msg;

    public EventRandomOneMomentArticle() {
    }

    public EventRandomOneMomentArticle(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
