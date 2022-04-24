package top.ppnt.jfinal.swaager.api.utils;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Ping E Lee
 *
 */
public class SwaggerUtils {

  /**
   * 字符串转set集合
   * @param value
   * @return
   */
  public static Set<String> toSet(String value) {
    Set<String> result = new LinkedHashSet<>();
    if (value != null) {
      String[] values = value.split(",");
      for (String item : values) {
        if (notBlank(item)) {
          result.add(item.trim());
        }
      }
    }
    return result;
  }

  /**
   * 判断字符串非空
   * @param value
   * @return
   */
  public static boolean notBlank(String value) {
    return value != null && !"".equals(value.trim());
  }
}
