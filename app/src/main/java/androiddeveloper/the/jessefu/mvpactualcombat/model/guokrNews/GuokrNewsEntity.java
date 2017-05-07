package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNews;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017-04-30.
 * 果壳精选列表页实体类
 */

public class GuokrNewsEntity implements Serializable{

    private Long id;

    private String category;

    private String style;

    private String title;

    private String link;

    private String headline_img;

    private double datePicked;


    public GuokrNewsEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHeadline_img() {
        return headline_img;
    }

    public void setHeadline_img(String headline_img) {
        this.headline_img = headline_img;
    }

    public double getDatePicked() {
        return datePicked;
    }

    public void setDatePicked(double datePicked) {
        this.datePicked = datePicked;
    }

    @Override
    public String toString() {
        return "GuokrNewsEntity{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", style='" + style + '\'' +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", headline_img='" + headline_img + '\'' +
                ", datePicked=" + datePicked +
                '}';
    }
}
