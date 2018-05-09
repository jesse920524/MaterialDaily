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
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/**
 * Created by Jesse Fu on 2017/3/20 0020.
 *
 *
 */

public class RxSaveImg {

    /**根据指定url,将图片下载到本地
     * @param context
     * @param url the target url*/
    public static io.reactivex.Observable<Uri> saveImg(final Context context, final String url){
        io.reactivex.Observable<Uri> observable = io.reactivex.Observable.create(new ObservableOnSubscribe<Bitmap>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Bitmap> e) throws Exception {
                //1.从glide获取图片
                Bitmap bitmap = null;
                try{
                    bitmap = Glide.with(context)
                            .load(url)
                            .asBitmap()
                            .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                            .get();
                }catch (Exception ex){
                    ex.printStackTrace();
                }

                if (bitmap == null){
                    e.onError(new Exception("无法下载图片"));
                }else{
                    e.onNext(bitmap);
                    e.onComplete();
                }
            }
        }).flatMap(new Function<Bitmap, ObservableSource<Uri>>() {
            @Override
            public ObservableSource<Uri> apply(@NonNull Bitmap bitmap) throws Exception {
                //2.将bitmap保存到图库,并获取uri
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

                //3.通知图库更新
                Uri uri = Uri.fromFile(file);
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri);
                context.sendBroadcast(intent);
                return io.reactivex.Observable.just(uri);
            }
        }).subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return observable;
    }
}
