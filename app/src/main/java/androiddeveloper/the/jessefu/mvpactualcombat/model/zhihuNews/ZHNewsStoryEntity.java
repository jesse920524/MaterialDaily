package androiddeveloper.the.jessefu.mvpactualcombat.model.zhihuNews;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017/2/28 0028.
 */
@Entity(nameInDb = "STORY_ENTITY")
public class ZHNewsStoryEntity implements Serializable{

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

    private int type;

    @Id(autoincrement = false)
    private Long id;

    private String gaPrefix;

    private String title;

    private boolean multipic;

    private String images;


    public ZHNewsStoryEntity() {
    }


    @Generated(hash = 382254105)
    public ZHNewsStoryEntity(int type, Long id, String gaPrefix, String title,
            boolean multipic, String images) {
        this.type = type;
        this.id = id;
        this.gaPrefix = gaPrefix;
        this.title = title;
        this.multipic = multipic;
        this.images = images;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "ZHNewsStoryEntity{" +
                ", type=" + type +
                ", id=" + id +
                ", gaPrefix='" + gaPrefix + '\'' +
                ", title='" + title + '\'' +
                ", multipic=" + multipic +
                ", images='" + images + '\'' +
                '}';
    }
}
