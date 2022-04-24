package top.ppnt.jfinal.swaager.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 安全信息API注解
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface SecurityApi {

  /**
   * 属性
   */
  String key() default "";

  /**
   * 属性值(多个之间用英文半角逗号隔开)
   */
  String value() default "";
}
