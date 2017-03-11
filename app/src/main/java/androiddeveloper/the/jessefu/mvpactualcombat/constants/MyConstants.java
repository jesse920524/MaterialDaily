package androiddeveloper.the.jessefu.mvpactualcombat.constants;

import android.support.v4.content.ContextCompat;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;

/**
 * Created by Jesse Fu on 2017/2/19.
 * MyConstants作为常量池,存储所有public static final值.
 */

public interface MyConstants {
    //fragment参数
    String FRAGMENT_ARGUMENNT = "fragment_argument";

    //知乎baseUri
    String ZHIHU_URI = "http://news-at.zhihu.com/";
    //Gank.io baseUri
    String GANK_URI = "http://gank.io/";


    int DEFAULT_TIME_OUT = 5;//默认超时
    int DEFAULT_DELAY_TIME = 30000;

    String THEME_ID = "theme_id";//作为key
    String THEME_NAME = "theme_name";//作为key
    String ARTICLE_ID = "article_id";//for key
    String ARTICLE_TITLE = "article_title";//for key
    String IMAGE_URL = "image_url";

    String SP_SETTINGS = "sp_settings";//设置sharedpreference

    int[] COLORS = new int[]{ContextCompat.getColor(BaseApplication.getContext(), R.color.red_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.green_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.blue_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.yellow_500)};

    int[] RAND_BACKGROUND_COLORS = new int[]{
            ContextCompat.getColor(BaseApplication.getContext(), R.color.red_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.orange_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.yellow_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.green_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.cyan_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.blue_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.purple_500),

            ContextCompat.getColor(BaseApplication.getContext(), R.color.darkred),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.darkorange),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.greenyellow),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.darkgreen),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.darkcyan),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.darkblue),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.purple_700),

            ContextCompat.getColor(BaseApplication.getContext(), R.color.grey_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.brown_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.bluegrey_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.teal_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.steelblue),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.black),
    };


}
