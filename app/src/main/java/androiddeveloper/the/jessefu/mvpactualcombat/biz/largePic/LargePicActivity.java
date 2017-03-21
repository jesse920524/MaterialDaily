package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class LargePicActivity extends AppCompatActivity {

    private static final String TAG = LargePicActivity.class.getSimpleName();

    private String imageUrl;
    @BindView(R2.id.pv_large_pic)
    PhotoView mPhotoView;

    private PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_pic);
        ButterKnife.bind(this);
        getArgs();
        initViews();

    }

    private void setupPhotoAttacher() {
        photoViewAttacher = new PhotoViewAttacher(mPhotoView);
        photoViewAttacher.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(LargePicActivity.this)
                        .setTitle(getString(R.string.save_img))
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                saveImg2Gallary();
                                dialogInterface.dismiss();
                            }
                        }).show();
                return true;
            }
        });
    }

    //保存到本地
    private void saveImg2Gallary() {
        Subscription s = RxSaveImg.saveImgGetPathObservable(this, imageUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Uri>() {
                    @Override
                    public void call(Uri uri) {
                        BaseApplication.showToast("save success!");
                    }
                });
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

        setupPhotoAttacher();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
