package androiddeveloper.the.jessefu.mvpactualcombat.biz.main;

import android.support.v4.app.FragmentManager;

import androiddeveloper.the.jessefu.mvpactualcombat.biz.datePick.DatePickDialogFragment;

/**
 * Created by Jesse Fu on 2017/2/19.
 */

public class MainPresenter implements MainContract.IMainPresenter {

    private MainContract.IMainView view;

    public MainPresenter(MainContract.IMainView view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void showDatePickDialog(FragmentManager fragmentManager) {
        DatePickDialogFragment fragment = new DatePickDialogFragment();
        fragment.show(fragmentManager, "datepick");
    }
}
