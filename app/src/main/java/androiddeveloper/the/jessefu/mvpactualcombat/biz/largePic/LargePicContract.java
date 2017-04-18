package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.content.Context;
import android.net.Uri;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;

/**
 * Created by Jesse Fu on 2017-04-09.
 */

public interface LargePicContract {
    interface ILargePicView extends BaseView<ILargePicPrensenter>{
        void dismissWidgets();

        void showWidgets();

        void setupPhotoAttacher();

        String getIntentArgs();
    }
    interface ILargePicPrensenter extends BasePresenter{
        void saveImg2Gallary(final String type);

        void saveImg2Gallary();

        void shareImg(Context context, Uri imgUri);

        void showWidgetsImmediately();

        void showWidgets();

        void dismissWidgets();
    }
}
