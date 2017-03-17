package androiddeveloper.the.jessefu.mvpactualcombat.model.gankGirls;

import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017/3/9 0009.
 */

public class GankGirlsEntity implements Serializable{

    @Transient
    private static final long serialVersionUID = 1000;

    private Long ID;

    private String id;

    private String publishAt;

    private String url;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(String publishAt) {
        this.publishAt = publishAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GankGirlsEntity{" +
                "ID=" + ID +
                ", id='" + id + '\'' +
                ", publishAt='" + publishAt + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
