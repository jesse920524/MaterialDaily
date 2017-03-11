package androiddeveloper.the.jessefu.mvpactualcombat.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Jesse Fu on 2017/2/27 0027.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HttpRequest {
    String description()default "no description";
    String httpMethod()default " ";
}
