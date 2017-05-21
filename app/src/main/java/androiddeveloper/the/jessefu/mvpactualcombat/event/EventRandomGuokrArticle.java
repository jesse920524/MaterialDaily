package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-19.
 * 果壳随机文章事件.
 * 由mainActivity -> GuokrNewsFragment
 */

public class EventRandomGuokrArticle {
    private String msg;

    public EventRandomGuokrArticle() {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
