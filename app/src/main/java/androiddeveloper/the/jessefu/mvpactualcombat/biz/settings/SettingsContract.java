package androiddeveloper.the.jessefu.mvpactualcombat.biz.settings;

import android.support.v7.preference.Preference;

import androiddeveloper.the.jessefu.mvpactualcombat.base.BasePresenter;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseView;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public interface SettingsContract {

    interface ISettingsView extends BaseView<ISettingsPresenter>{
        //显示清除缓存结果
        void showClearCacheResult();
    }

    interface ISettingsPresenter extends BasePresenter{
        //设置无图模式开关
        void setNoPicMode(Preference preference);

        //设置隐藏功能开关
        void setHideFunction(Preference preference);

        //清除缓存
        void clearCache();

        //隐藏浮动按钮
        void setHideFab(Preference preference);
    }
}
