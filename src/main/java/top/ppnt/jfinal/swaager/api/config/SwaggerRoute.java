package top.ppnt.jfinal.swaager.api.config;

import com.jfinal.config.Routes;

import top.ppnt.jfinal.swaager.api.controller.SwaggerController;

/**
 * swagger 路由
 */
public class SwaggerRoute extends Routes {

  @Override
  public void config() {
    /*String basePackage="top.ppnt.jfinal.swagger";
    super.scan(basePackage+".controller.");*/
    add("/swagger", SwaggerController.class);
  }
}
