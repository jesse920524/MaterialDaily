package androiddeveloper.the.jessefu.mvpactualcombat.model.guokrNewsDetail;

import java.io.Serializable;

/**
 * Created by Jesse Fu on 2017-05-01.
 */

public class GuokrNewsDetailBean implements Serializable{

    public GuokrNewsDetailBean() {
    }

    String detail;

    @Override
    public String toString() {
        return "GuokrNewsDetailBean{" +
                "detail='" + detail + '\'' +
                '}';
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
