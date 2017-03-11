package androiddeveloper.the.jessefu.mvpactualcombat.model.themesNews.themes;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Jesse Fu on 2017/3/1 0001.
 */
@Entity
public class ThemeEntity {

    @Id(autoincrement = false)
    private Long ID;

    private int color;

    private String thumbnail;

    private String description;

    private int id;

    private String name;

    @Generated(hash = 970585355)
    public ThemeEntity(Long ID, int color, String thumbnail, String description,
            int id, String name) {
        this.ID = ID;
        this.color = color;
        this.thumbnail = thumbnail;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1498286330)
    public ThemeEntity() {
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
