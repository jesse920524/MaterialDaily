package androiddeveloper.the.jessefu.mvpactualcombat.model.oneMoment;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017/3/14 0014.
 */

public class OneMomentEntity implements Serializable, MultiItemEntity{

    public static final int TEXT_IMG = 0;//图文
    public static final int TEXT = 1;//文字
    public static final int IMG = 2;//图片

    public enum ArticleType{
        TEXT_IMG("text_img", 0),
        TEXT("text", 1),
        IMG("img", 2);

        private String typeName;
        private int code;
        private ArticleType(String typeName, int code){
            this.typeName = typeName;
            this.code = code;
        }

        public int getCode(){
            return this.code;
        }

        public String getTypeName(){
            return this.typeName;
        }
    }

    @Transient
    private static final long serialVersionUID = 1000;
    //PostBean -- id;
    private Long id;

    //PostBean -- date
    private String date;

    //对应bean字段: PostBean -- column
    private String column;

    // AuthorBean -- name
    private String authorName;

    // AuthorBean -- avatar
    private String authorAvatar;

    // PostBean -- thumbs -- large -- url
    //thumbs是一个list,需要全部解析
    private String img;

    // PostBean -- abstract
    private String description;

    private String title;

    //自定义字段,根据bean的thumb是否多图,description是否为空确定文章类型:图文,文字,多图
    private int itemType;

    public OneMomentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
}
