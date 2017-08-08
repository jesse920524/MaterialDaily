package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.jude.swipbackhelper.SwipeBackHelper;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.R2;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import androiddeveloper.the.jessefu.mvpactualcombat.constants.MyConstants;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by Jesse Fu on 2017/3/10 0010.
 */

public class LargePicActivity extends AppCompatActivity implements LargePicContract.ILargePicView {

    private static final String TAG = LargePicActivity.class.getSimpleName();

    private String imageUrl;
    @BindView(R2.id.pv_large_pic)
    PhotoView mPhotoView;
    @BindView(R2.id.tb_largePic)
    Toolbar mToolbar;
    @BindView(R2.id.ib_largePic)
    ImageButton mIbSave;

    private PhotoViewAttacher photoViewAttacher;

    private LargePicContract.ILargePicPrensenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_pic);
        setUIFlags();
        ButterKnife.bind(this);
        //initSwipeBack();
        getIntentArgs();
        initViews();

        presenter =  new LargePicPresenter(this);
        presenter.start();

    }



    /**状态栏沉浸*/
    private void setUIFlags() {
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            int option =  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void setupPhotoAttacher() {
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
                                presenter.saveImg2Gallary();
                                dialogInterface.dismiss();
                            }
                        }).show();
                return true;
            }
        });

        photoViewAttacher.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                presenter.showWidgetsImmediately();
            }

            @Override
            public void onOutsidePhotoTap() {

            }
        });
    }


    @Override
    public String getIntentArgs() {
        String arg = null;
        Intent intent = getIntent();
        if (intent != null){
            arg = intent.getStringExtra(MyConstants.IMAGE_URL);
        }
        return arg;
    }

    private void initViews() {

        //toolbar section
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(BaseApplication.getContext())
                .load(getIntentArgs())
                .into(mPhotoView);

        setupPhotoAttacher();
    }


    @OnClick(R2.id.ib_largePic)
    void onClickSave(){
        presenter.saveImg2Gallary();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_large_pic, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.menu_large_pic_save:
                presenter.saveImg2Gallary();
                break;
            case R.id.menu_large_pic_share:
                presenter.saveImg2Gallary("share");

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //SwipeBackHelper.onDestroy(this);
    }

    @Override
    public void setPresenter(LargePicContract.ILargePicPrensenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showLoading() {

    }
    @Override
    public void dismissLoading() {

    }

    @Override
    public void dismissWidgets() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mToolbar, "alpha", 1.0f, 0.5f, 0.0f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mIbSave, "alpha", 1.0f, 0.5f, 0.0f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(700);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.playTogether(objectAnimator, objectAnimator1);
        animatorSet.start();



    }

    @Override
    public void showWidgets() {
        if (mToolbar.getAlpha() == 0) {
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mToolbar, "alpha", 0.0f, 0.5f, 1.0f);
            ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(mIbSave, "alpha", 0.0f, 0.5f, 1.0f);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(100);
            animatorSet.setInterpolator(new LinearInterpolator());
            animatorSet.playTogether(objectAnimator, objectAnimator1);
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            presenter.dismissWidgets();
                        }
                    }, 1000);
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            animatorSet.start();
        }
    }
}
