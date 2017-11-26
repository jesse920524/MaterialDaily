package androiddeveloper.the.jessefu.mvpactualcombat.constants;

import android.support.v4.content.ContextCompat;

import androiddeveloper.the.jessefu.mvpactualcombat.R;
import androiddeveloper.the.jessefu.mvpactualcombat.base.BaseApplication;

/**
 * Created by Jesse Fu on 2017/2/19.
 * MyConstants作为常量索引,存储所有public static final值.
 */

public class MyConstants {

    private MyConstants(){

    }

    //fragment参数
    public static final String FRAGMENT_ARGUMENNT = "fragment_argument";

    //知乎baseUri
    public static final String ZHIHU_URI = "http://news-at.zhihu.com/";
    //Gank.io baseUri
    public static final String GANK_URI = "http://gank.io/";

    //douban baseUri
    public static final String YIKE_BASE = "https://moment.douban.com/";

    // 豆瓣一刻
    // 根据日期查询消息列表
    // eg:https://moment.douban.com/api/stream/date/2016-08-11
    public static final String DOUBAN_MOMENT = "https://moment.douban.com/api/stream/date/";

    // 获取文章具体内容
    // eg:https://moment.douban.com/api/post/100484
    public static final String DOUBAN_ARTICLE_DETAIL = "https://moment.douban.com/api/post/";

    //果壳api
    /**
     *
     获取果壳精选的文章列表,通过组合相应的参数成为完整的url
     Guokr handpick articles. make complete url by combining params
     public static final String GUOKR_ARTICLES = "http://apis.guokr.com/handpick/article.json?retrieve_type=by_since&category=all&limit=25&ad=1";
     */
    public static final String  GUOKR_URI = "http://apis.guokr.com/";

    /**
     * 果壳文章详情url*/
    public static final String GUOKR_DETAIL = "http://jingxuan.guokr.com/";

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
    public static final String FANFOU_HEADER = "http://blog.fanfou.com/digest/json/";
    public static final String FANFOU_DAILY = ".daily";
    public static final String FANFOU_WEEKLY = ".weekly";
    public static final String FANFOU_FOOTER = ".json";
    public static final String FANFOU_TEST_DATE = "2017-01-01";
    public static final String FANFOU_TEST_WEEK = "2017-04-03";


    public static final int DEFAULT_TIME_OUT = 5000;//默认超时
    public static final int DEFAULT_DELAY_TIME = 30000;

    public static final String THEME_ID = "theme_id";//作为key
    public static final String THEME_NAME = "theme_name";//作为key
    public static final String ARTICLE_ID = "article_id";//for key
    public static final String ARTICLE_TITLE = "article_title";//for key
    public static final String IMAGE_URL = "image_url";
    public static final String SERIALIZABLE_ITEM = "serializable_item";

    //文章类型
    public static final String ARTICLE_TYPE = "article_type";
    public static final String ARTICLE_TYPE_ZHIHU  = "article_type_zhihu";
    public static final String ARTICLE_TYPE_ZHIHU_LATEST = "article_type_zhihu_latest";
    public static final String ARTICLE_TYPE_ZHIHU_PAST = "article_type_zhihu_past";
    public static final String ARTICLE_TYPE_ONEMOMENT = "article_type_onemoment";
    public static final String ARTICLE_TYPE_GUOKR = "article_type_guokr";

    public static final String USER_SETTINGS = "user_settings";//设置sharedpreference

    public static final int[] COLORS = new int[]{ContextCompat.getColor(BaseApplication.getContext(), R.color.red_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.green_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.blue_500),
            ContextCompat.getColor(BaseApplication.getContext(), R.color.yellow_500)};

    public static final int[] RAND_BACKGROUND_COLORS = new int[]{
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
