package androiddeveloper.the.jessefu.mvpactualcombat.biz.largePic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Jesse Fu on 2017/3/20 0020.
 */

public class RxSaveImg {

    public static Observable<Uri> saveImgGetPathObservable(final Context context, final String url){
        return Observable.create(new Observable.OnSubscribe<Bitmap>(){

            @Override
            public void call(Subscriber<? super Bitmap> subscriber) {
                Bitmap bitmap = null;
                try {
                    bitmap = Glide.with(context)
                            .load(url)
                            .asBitmap()
                            .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                if (bitmap == null){
                    subscriber.onError(new Exception("无法下载到图片"));
                }
                subscriber.onNext(bitmap);
                subscriber.onCompleted();
            }
        }).flatMap(new Func1<Bitmap, Observable<Uri>>() {
            @Override
            public Observable<Uri> call(Bitmap bitmap) {
                String appName = context.getResources().getString(R.string.app_name);
                File appDir = new File(Environment.getExternalStorageDirectory(), appName);
                if (!appDir.exists()){
                    Log.d("mkdir", "mkdir exec");
                    appDir.mkdir();
                }
                String fileName = appName + System.currentTimeMillis() + ".jpg";

                File file = new File(appDir, fileName);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    assert bitmap != null;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //通知图库更新
                Uri uri = Uri.fromFile(file);
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri);
                context.sendBroadcast(intent);
                return Observable.just(uri);
            }
        }).subscribeOn(Schedulers.io());
    }
}
