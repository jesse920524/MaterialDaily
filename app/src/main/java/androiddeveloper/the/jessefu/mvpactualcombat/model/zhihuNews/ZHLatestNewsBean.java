package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jesse Fu on 2017/2/22.
 * JavaBean--知乎日报最新消息
 */

public class ZHLatestNewsBean {

    /**
     * date : 20170222
     * stories : [{"images":["http://pic3.zhimg.com/c132c867feb6f92dd8f0614881bfb172.jpg"],"type":0,"id":9241280,"ga_prefix":"022222","title":"小事 · 明明知道是凶手"},{"images":["http://pic4.zhimg.com/d26fbaaa7cafa663006a875f08583533.jpg"],"type":0,"id":9241361,"ga_prefix":"022221","title":"奥斯卡 · 《月光男孩》，政治正确的胜利还是电影语言的成功？"},{"images":["http://pic2.zhimg.com/44ec391290b09d1e4536ccf9dd4fd4e1.jpg"],"type":0,"id":9242610,"ga_prefix":"022220","title":"我有一个主意，政府别收税了，就一直印钱吧"},{"images":["http://pic3.zhimg.com/aa18a9095d93dc0cb4176f8318f45f86.jpg"],"type":0,"id":9242429,"ga_prefix":"022220","title":"为什么注册会计师听起来就没有医生和律师那么厉害呢？"},{"images":["http://pic4.zhimg.com/03bf513ab464790dd15dfacf22c3faab.jpg"],"type":0,"id":9242246,"ga_prefix":"022218","title":"总把方向盘往死里打，会打出问题吗？"},{"title":"我只认识红彤彤的北极贝，你说的北寄贝是什么？","ga_prefix":"022217","images":["http://pic3.zhimg.com/1f5db890689909f306e3d1eeca21c1a2.jpg"],"multipic":true,"type":0,"id":9241686},{"images":["http://pic4.zhimg.com/3899a01122ece22f00d29c1c3d717ebf.jpg"],"type":0,"id":9241656,"ga_prefix":"022216","title":"《名利场》说「好莱坞已死」，但问题不只是「浪费」"},{"images":["http://pic2.zhimg.com/f24a5e1cc36af0a4cf1ef18d66cb69a1.jpg"],"type":0,"id":9241391,"ga_prefix":"022215","title":"社交网络都在做个性化推荐，这是我在 Facebook 的经验"},{"images":["http://pic4.zhimg.com/5c60cfc152d728ec0742a4ff16257007.jpg"],"type":0,"id":9241776,"ga_prefix":"022214","title":"很想写小说，但阅历不够怎么办？"},{"images":["http://pic3.zhimg.com/2a0e970abb0a657b13198b29fdf2e97e.jpg"],"type":0,"id":9241353,"ga_prefix":"022213","title":"杨振宁、姚期智成为中国科学院院士，是件大好事"},{"images":["http://pic4.zhimg.com/fdd9f1feba07d0dc2fc535c5080bad0b.jpg"],"type":0,"id":9241415,"ga_prefix":"022212","title":"这家改变了全球消费零售行业的公司，遇上了首次收购失败"},{"images":["http://pic1.zhimg.com/59164240feaf13a58b2da9af41c8a860.jpg"],"type":0,"id":9224639,"ga_prefix":"022212","title":"大误 · 还是中文有用"},{"images":["http://pic2.zhimg.com/09721b254a594c9ac3051d4ef24eecb5.jpg"],"type":0,"id":9240735,"ga_prefix":"022210","title":"这两份经典法式甜品，只要好好搅拌就不会烘焙失败"},{"images":["http://pic2.zhimg.com/4dad67dec8b2edc066a73eaf90766a71.jpg"],"type":0,"id":9238850,"ga_prefix":"022209","title":"解决痘痘问题，医院和美容院有什么区别？"},{"title":"组装一台电脑，我学到的是一百种知识技能","ga_prefix":"022208","images":["http://pic4.zhimg.com/e817d5f1bf2a8cd55df03a7db0c9ada3.jpg"],"multipic":true,"type":0,"id":9199628},{"images":["http://pic1.zhimg.com/6662ea1984f3f96a5679c08c0bfe2c24.jpg"],"type":0,"id":9239359,"ga_prefix":"022207","title":"想把 1080p 的显示器变成视网膜屏，往后一躺就行了"},{"images":["http://pic4.zhimg.com/7e27ae3089bc39a195906ccc3cf56d1b.jpg"],"type":0,"id":9239412,"ga_prefix":"022207","title":"等一下\u2026\u2026谁说 14 周岁以上的女性就是「妇女」？"},{"images":["http://pic3.zhimg.com/719324c4b300434656dc83574fd2100a.jpg"],"type":0,"id":9240258,"ga_prefix":"022207","title":"看看情人节收到的巧克力，有没有长出一层白霜？"},{"images":["http://pic4.zhimg.com/eb9abafac8f56537b2eb38988b6ca37f.jpg"],"type":0,"id":9237216,"ga_prefix":"022206","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/e278c03dc1bb2ca1c80879b53c51e58a.jpg","type":0,"id":9241353,"ga_prefix":"022213","title":"杨振宁、姚期智成为中国科学院院士，是件大好事"},{"image":"http://pic1.zhimg.com/b5a755386744c3d0e0091ebd37a32e7c.jpg","type":0,"id":9241415,"ga_prefix":"022212","title":"这家改变了全球消费零售行业的公司，遇上了首次收购失败"},{"image":"http://pic2.zhimg.com/67f949b2ef91c9167513a263f3490abd.jpg","type":0,"id":9199628,"ga_prefix":"022208","title":"组装一台电脑，我学到的是一百种知识技能"},{"image":"http://pic2.zhimg.com/22942f9f2b0e017cd2c4dc5adf7fe5b9.jpg","type":0,"id":9238850,"ga_prefix":"022209","title":"解决痘痘问题，医院和美容院有什么区别？"},{"image":"http://pic3.zhimg.com/80efb6e89e999361f71daeb696bd729e.jpg","type":0,"id":9239412,"ga_prefix":"022207","title":"等一下\u2026\u2026谁说 14 周岁以上的女性就是「妇女」？"}]
     */

    @SerializedName("date")
    private String date;
    @SerializedName("stories")
    private List<StoriesBean> stories;
    @SerializedName("top_stories")
    private List<TopStoriesBean> topStories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<TopStoriesBean> topStories) {
        this.topStories = topStories;
    }

    @Override
    public String toString() {
        return "ZHLatestNewsBean{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", topStories=" + topStories +
                '}';
    }


    public static class StoriesBean {

        /**
         * images : ["http://pic3.zhimg.com/c132c867feb6f92dd8f0614881bfb172.jpg"]
         * type : 0
         * id : 9241280
         * ga_prefix : 022222
         * title : 小事 · 明明知道是凶手
         * multipic : true
         */

        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;
        @SerializedName("ga_prefix")
        private String gaPrefix;
        @SerializedName("title")
        private String title;
        @SerializedName("multipic")
        private boolean multipic;
        @SerializedName("images")
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGaPrefix() {
            return gaPrefix;
        }

        public void setGaPrefix(String gaPrefix) {
            this.gaPrefix = gaPrefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "StoriesBean{" +
                    "type=" + type +
                    ", id=" + id +
                    ", gaPrefix='" + gaPrefix + '\'' +
                    ", title='" + title + '\'' +
                    ", multipic=" + multipic +
                    ", images=" + images +
                    '}';
        }
    }

    public static class TopStoriesBean {
        /**
         * image : http://pic3.zhimg.com/e278c03dc1bb2ca1c80879b53c51e58a.jpg
         * type : 0
         * id : 9241353
         * ga_prefix : 022213
         * title : 杨振宁、姚期智成为中国科学院院士，是件大好事
         */

        @SerializedName("image")
        private String image;
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private int id;
        @SerializedName("ga_prefix")
        private String gaPrefix;
        @SerializedName("title")
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGaPrefix() {
            return gaPrefix;
        }

        public void setGaPrefix(String gaPrefix) {
            this.gaPrefix = gaPrefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "TopStoriesBean{" +
                    "image='" + image + '\'' +
                    ", type=" + type +
                    ", id=" + id +
                    ", gaPrefix='" + gaPrefix + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
