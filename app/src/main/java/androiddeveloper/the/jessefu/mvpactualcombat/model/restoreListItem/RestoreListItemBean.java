package androiddeveloper.the.jessefu.mvpactualcombat.model.restoreListItem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Jesse Fu on 2017-05-06.
 */
@Entity(nameInDb = "ARTICLE_LIST")
public class RestoreListItemBean implements Serializable {

    @Transient
    private static final long serialVersionUID = 1000;

    //id
    Long articleId;

    //type
    String articleType;

    //date 存储时间
    long restoreDate;
    /**
     * 列表页item详情,可反序列化为ZHNewsStoryEntity||GuokrNewsEntity||OneMomentEntity*/
    String articleInfo;

    public RestoreListItemBean() {
    }

    @Generated(hash = 661189401)
    public RestoreListItemBean(Long articleId, String articleType, long restoreDate,
            String articleInfo) {
        this.articleId = articleId;
        this.articleType = articleType;
        this.restoreDate = restoreDate;
        this.articleInfo = articleInfo;
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

    public long getRestoreDate() {
        return restoreDate;
    }

    public void setRestoreDate(long restoreDate) {
        this.restoreDate = restoreDate;
    }

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo;
    }

    @Override
    public String toString() {
        return "RestoreListItemBean{" +
                "articleId=" + articleId +
                ", articleType='" + articleType + '\'' +
                ", restoreDate=" + restoreDate +
                ", articleInfo='" + articleInfo + '\'' +
                '}';
    }
}
