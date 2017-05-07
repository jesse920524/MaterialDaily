package androiddeveloper.the.jessefu.mvpactualcombat.event;

/**
 * Created by Jesse Fu on 2017-05-03.
 * 日期选择事件.由DatePickDialogFragment发送给LatesestNewsFragment
 *
 * 判断:若选择的时间大于当天日期,不会加载新数据,给用户提示
 * 若选择的时间小于20130520,不会加载新数据,给用户提示
 */

public class EventOnDatePicked {

    private int selectedDate;

    public EventOnDatePicked(int selectedDate) {
        this.selectedDate = selectedDate;
    }

    public int getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(int selectedDate) {
        this.selectedDate = selectedDate;
    }
}
