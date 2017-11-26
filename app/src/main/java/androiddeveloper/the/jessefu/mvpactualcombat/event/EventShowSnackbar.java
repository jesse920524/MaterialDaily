package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-21.
 * 显示snackbar
 * 由LatestnewsFragment -> mainActivity
 *
 * 当无网络且成功读取持久化数据时,snackbar提示用户
 */

public class EventShowSnackbar extends BaseEvent{

    private EventShowSnackbar() {

    }

    private EventShowSnackbar(String msg) {
        super(msg);
    }

    public static EventShowSnackbar newInstance(String msg){
        EventShowSnackbar instance = new EventShowSnackbar(msg);
        return instance;
    }
}
