package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class LargePicActivity extends AppCompatActivity {

    private static final String TAG = LargePicActivity.class.getSimpleName();

    private String imageUrl;
    @BindView(R2.id.pv_large_pic)
    PhotoView mPhotoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_pic);
        ButterKnife.bind(this);
        getArgs();
        initViews();
    }

    private void getArgs() {
        Intent intent = getIntent();
        if (intent != null){
            imageUrl = intent.getStringExtra(MyConstants.IMAGE_URL);
        }
    }

    private void initViews() {

        //主要的语句---将当前Activity的View和自己定义的Key绑定起来
        //ViewCompat.setTransitionName(mPhotoView, MyConstants.IMAGE_URL);

        Glide.with(BaseApplication.getContext())
                .load(imageUrl)
                .asBitmap()
                .into(mPhotoView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
