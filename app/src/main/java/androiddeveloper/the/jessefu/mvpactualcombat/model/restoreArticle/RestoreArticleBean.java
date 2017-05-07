package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreArticle;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017-04-23.
 * 文章详情,用于持久化
 *
 */

@Entity(nameInDb = "ARTICLE_DETTAIL")
public class RestoreArticleBean implements Serializable{
    @Transient
    private static final long serialVersionUID = 1000;

    /**date为存储时间*/
    private Long date;

    @Id(autoincrement = false)
    private Long articleId;
    @NotNull
    private String articleType;
    @NotNull
    private String artticleDetail;

    public RestoreArticleBean() {
    }

    @Keep
    public RestoreArticleBean(Long date, Long articleId,
            @NotNull String articleType, @NotNull String artticleDetail) {
        this.date = date;
        this.articleId = articleId;
        this.articleType = articleType;
        this.artticleDetail = artticleDetail;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArtticleDetail() {
        return artticleDetail;
    }

    public void setArtticleDetail(String artticleDetail) {
        this.artticleDetail = artticleDetail;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RestoreArticleBean{" +
                "date='" + date + '\'' +
                ", articleId=" + articleId +
                ", articleType='" + articleType + '\'' +
                ", artticleDetail='" + artticleDetail + '\'' +
                '}';
    }
}
