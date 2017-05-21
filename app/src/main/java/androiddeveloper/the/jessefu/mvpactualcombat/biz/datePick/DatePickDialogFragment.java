package androiddeveloper.the.jessefu.mvpactualcombat.biz.datePick;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.event.EventOnDatePicked;
import androiddeveloper.the.jessefu.mvpactualcombat.util.UtilTime;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jesse Fu on 2017/3/2 0002.
 */

public class DatePickDialogFragment extends DialogFragment {
    private static final String TAG = DatePickDialogFragment.class.getSimpleName();

    private String selectedDate;//记录选择的日期
    private String currDate;//当天日期

    private View mRoot;

    @BindView(R2.id.dp_dialog_datepicker)
    DatePicker mDatePicker;
    @BindView(R2.id.btn_dialog_datepicker_confirm)
    Button mBtnConfirm;
    @BindView(R2.id.btn_dialog_datepicker_back)
    Button mBtnBack;
    @BindView(R2.id.btn_dialog_dtepicker_cancel)
    Button mBtnCancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.dialog_datepicker, container, false);
        ButterKnife.bind(this, mRoot);
        initViews();
        currDate = UtilTime.get8StringDate(new Date());
        return mRoot;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    private void initViews() {
        initDatePicker();

    }

    private void initDatePicker() {

        selectedDate = UtilTime.get8StringDate(new Date());
        int[] ints = UtilTime.getIntArrayDate(selectedDate);
        mDatePicker.init(ints[0], ints[1] -1 , ints[2], new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                selectedDate = UtilTime.getStringFromIntArray(new int[]{i, i1, i2});
            }
        });
    }

    /**
     * 参考: EventOnDatePicked*/
    @OnClick(R2.id.btn_dialog_datepicker_confirm)
    void onClickBtnConfirm(){

        int selecDate = Integer.parseInt(selectedDate);
        EventBus.getDefault().post(new EventOnDatePicked(selecDate));//发送事件给订阅者
        this.dismiss();

    }

    /**
     * 回到今天*/
    @OnClick(R2.id.btn_dialog_datepicker_back)
    void onClickBtnBack(){
        int[] ints = UtilTime.getIntArrayDate(UtilTime.get8StringDate(new Date()));
        mDatePicker.updateDate(ints[0], ints[1] -1 , ints[2]);
    }

    @OnClick(R2.id.btn_dialog_dtepicker_cancel)
    void onClickBtnCancel(){
        this.dismiss();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        selectedDate = null;
    }
}
