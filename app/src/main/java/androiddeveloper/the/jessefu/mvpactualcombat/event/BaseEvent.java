package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-10-30.
 */

public abstract class BaseEvent {

    private String msg;

    public BaseEvent(){}

    public BaseEvent(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return this.msg;
    }

}
