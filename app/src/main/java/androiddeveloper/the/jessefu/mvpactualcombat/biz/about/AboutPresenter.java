package androiddeveloper.the.jessefu.mvpactualcombat.biz.about;

/**
 * Created by Jesse Fu on 2017/3/8 0008.
 */

public class AboutPresenter implements AboutContract.IAboutPresenter {

    private static final String TAG = AboutPresenter.class.getSimpleName();

    private AboutContract.IAboutView view;

    public AboutPresenter(AboutContract.IAboutView view) {
        this.view = view;
    }


    /**
     * start()方法约定了所有presenter的初始化操作都放在start（）中
     */
    @Override
    public void start() {

    }
}
