package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themeNews;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */
@Entity
public class ThemeNewsEntity {

    @Id
    private Long ID;

    private int type;

    private int id;

    private String title;

    private String images;

    @Generated(hash = 852593560)
    public ThemeNewsEntity(Long ID, int type, int id, String title, String images) {
        this.ID = ID;
        this.type = type;
        this.id = id;
        this.title = title;
        this.images = images;
    }

    @Generated(hash = 2104459602)
    public ThemeNewsEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
