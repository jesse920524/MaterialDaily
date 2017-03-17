package androiddeveloper.the.jessefu.mvpactualcombat.model.pastNews;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */
@Entity(nameInDb = "ZHIHU_PAST_STORY")
public class PastNewsStoryEntity implements Serializable{

    @Transient
    private static final long serialVersionUID = 1000;
    /**
     * images : ["http://p4.zhimg.com/7b/c8/7bc8ef5947b069513c51e4b9521b5c82.jpg"]
     * type : 0
     * id : 1747159
     * ga_prefix : 111822
     * title : 深夜食堂 · 我的张曼妮
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

    @Generated(hash = 1943267095)
    public PastNewsStoryEntity(Long _id, int type, int id, String gaPrefix,
            String title, boolean multipic, String images) {
        this._id = _id;
        this.type = type;
        this.id = id;
        this.gaPrefix = gaPrefix;
        this.title = title;
        this.multipic = multipic;
        this.images = images;
    }

    @Generated(hash = 1450140881)
    public PastNewsStoryEntity() {
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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

    public boolean getMultipic() {
        return this.multipic;
    }

    @Override
    public String toString() {
        return "PastNewsStoryEntity{" +
                "_id=" + _id +
                ", type=" + type +
                ", id=" + id +
                ", gaPrefix='" + gaPrefix + '\'' +
                ", title='" + title + '\'' +
                ", multipic=" + multipic +
                ", images='" + images + '\'' +
                '}';
    }
}
