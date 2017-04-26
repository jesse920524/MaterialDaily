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

    //douban baseUri
    String YIKE_BASE = "https://moment.douban.com/";

    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";

    /**
     * 饭否section
     *
     * 饭否url拼接规则:
     *
     * 获取每日精选:FANFOU_HEADER + FANFOU_TEST_DATE + FANFOU_DAILY + FANFOU_FOOTER;
     * example: http://blog.fanfou.com/digest/json/2017-01-01.daily.json;
     *
     * 获取每周精选:FANFOU_HEADER + FANFOU_TEST_WEEK + FANFOU_WEEKLY + FANFOU_FOOTER;
     * exmaple: http://blog.fanfou.com/digest/json/2017-04-03.weekly.json;
     *
     * */
    String FANFOU_HEADER = "http://blog.fanfou.com/digest/json/";
    String FANFOU_DAILY = ".daily";
    String FANFOU_WEEKLY = ".weekly";
    String FANFOU_FOOTER = ".json";
    String FANFOU_TEST_DATE = "2017-01-01";
    String FANFOU_TEST_WEEK = "2017-04-03";


    int DEFAULT_TIME_OUT = 5;//默认超时
    int DEFAULT_DELAY_TIME = 30000;

    String THEME_ID = "theme_id";//作为key
    String THEME_NAME = "theme_name";//作为key
    String ARTICLE_ID = "article_id";//for key
    String ARTICLE_TITLE = "article_title";//for key
    String IMAGE_URL = "image_url";
    String SERIALIZABLE_ITEM = "serializable_item";

    //文章类型
    String ARTICLE_TYPE = "article_type";
    String ARTICLE_TYPE_ZHIHU  = "article_type_zhihu";
    String ARTICLE_TYPE_ZHIHU_LATEST = "article_type_zhihu_latest";
    String ARTICLE_TYPE_ZHIHU_PAST = "article_type_zhihu_past";
    String ARTICLE_TYPE_ONEMOMENT = "article_type_onemoment";

    String USER_SETTINGS = "user_settings";//设置sharedpreference

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
