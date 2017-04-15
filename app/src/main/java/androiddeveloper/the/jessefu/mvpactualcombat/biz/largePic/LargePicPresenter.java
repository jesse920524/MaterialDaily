package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by Jesse Fu on 2017-04-09.
 */

public class LargePicPresenter implements LargePicContract.ILargePicPrensenter {

    private LargePicContract.ILargePicView view;

    public LargePicPresenter(LargePicContract.ILargePicView view){
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        dismissToolbar();
    }

    @Override
    public void saveImg2Gallary(final String type) {
        Subscription s = RxSaveImg.saveImgGetPathObservable((Context) view, view.getArgs())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Uri>() {
                    @Override
                    public void call(Uri uri) {
                        if (type == "share"){
                            shareImg((Context) view, uri);
                        }else{
                            BaseApplication.showToast("保存成功! \n"
                                    + "路径: "+ uri);
                        }
                    }
                });
    }

    @Override
    public void saveImg2Gallary() {
        saveImg2Gallary(null);
    }

    @Override
    public void shareImg(Context context, Uri imgUri) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imgUri);
        shareIntent.setType("image/*");
        context.startActivity(Intent.createChooser(shareIntent, context.getResources().getText(R.string.share)));
    }

    @Override
    public void showToolbarImmediately() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                view.showToolbar();
            }
        });
    }

    @Override
    public void showToolbar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.showToolbar();
            }
        }, 1500);
    }

    @Override
    public void dismissToolbar() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.dismissToolbar();
            }
        }, 1500);
    }
}
