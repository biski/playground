package engine.annotations;

import engine.Browser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wojciech on 17.06.17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UseBrowser {
    boolean use() default true;
    Browser.BROWSER_TYPE type() default Browser.BROWSER_TYPE.FIREFOX;
}
