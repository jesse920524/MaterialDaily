package androiddeveloper.the.jessefu.mvpactualcombat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.leakcanary.RefWatcher;

import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;

/**
 * Created by Jesse Fu on 2017/2/19
 */

public class BaseFragment extends Fragment {
    private String fragmentArgument;

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mRefWatcher = BaseApplication.getRefWatcher(getActivity().getApplicationContext());
        mRefWatcher.watch(this);
        fragmentArgument = getArguments().getString(MyConstants.FRAGMENT_ARGUMENNT);
    }

    /**
     * create a new instance of Fragment*/
    public static BaseFragment newInstance(String arg){
        BaseFragment baseFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyConstants.FRAGMENT_ARGUMENNT, arg);
        baseFragment.setArguments(bundle);
        return baseFragment;
    }
}
