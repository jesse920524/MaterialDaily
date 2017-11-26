package androiddeveloper.the.jessefu.mvpactualcombat.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Jesse Fu on 2017/2/19
 */

public class BaseFragment extends Fragment {
    String s;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         s = getArguments().getString(MyConstants.FRAGMENT_ARGUMENNT);
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
