package androiddeveloper.the.jessefu.mvpactualcombat.model.latestNews;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Jesse Fu on 2017/2/24 0024.
 */
@Entity(
        nameInDb = "ZHIHU_LATEST_STORY"
)
public class LatestNewsStoryEntity {



    /**
     * images : ["http://pic3.zhimg.com/c132c867feb6f92dd8f0614881bfb172.jpg"]
     * type : 0
     * id : 9241280
     * ga_prefix : 022222
     * title : 小事 · 明明知道是凶手
     * multipic : true
     */
    @Id(autoincrement = true)
    private Long _id;

    private int type;

    private int id;

    private String gaPrefix;

    private String title;

    private boolean multipic;

    private String images;

    //@Generated(hash = 883095815)
    @Keep
    public LatestNewsStoryEntity(Long _id, int type, int id, String gaPrefix, String title,
                                 boolean multipic, String images) {
        this._id = _id;
        this.type = type;
        this.id = id;
        this.gaPrefix = gaPrefix;
        this.title = title;
        this.multipic = multipic;
        this.images = images;
    }

    //@Generated(hash = 1663032640)
    @Keep
    public LatestNewsStoryEntity() {
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

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public boolean getMultipic() {
        return this.multipic;
    }
}
