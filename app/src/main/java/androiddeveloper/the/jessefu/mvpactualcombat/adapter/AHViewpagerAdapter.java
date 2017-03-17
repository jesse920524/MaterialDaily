package androiddeveloper.the.jessefu.mvpactualcombat.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androiddeveloper.the.jessefu.mvpactualcombat.biz.lastestNews.LatestNewsFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.oneMoment.OneMomentFragment;
import androiddeveloper.the.jessefu.mvpactualcombat.biz.pastNews.PastNewsFragment;

/**
 * Created by Jesse Fu on 2017/2/19.
 */

public class AHViewpagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private Fragment currentFragment;


    public AHViewpagerAdapter(FragmentManager fm) {
        super(fm);

        fragmentList.clear();

        fragmentList.add(LatestNewsFragment.newInstance("0"));
        //fragmentList.add(ThemeFragment.newInstance("1"));
        fragmentList.add(OneMomentFragment.newInstance("1"));
        fragmentList.add(PastNewsFragment.newInstance("2"));


        currentFragment = fragmentList.get(0);


    }

    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {

        if (getCurrentFragment() != object){
            currentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

    /**get current fragment*/
    public Fragment getCurrentFragment(){
        return currentFragment;
    }
}
