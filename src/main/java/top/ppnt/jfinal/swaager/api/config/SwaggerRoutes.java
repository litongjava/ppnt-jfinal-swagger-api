package top.ppnt.jfinal.swaager.api.config;

import com.jfinal.config.Routes;

import top.ppnt.jfinal.swaager.api.controller.SwaggerController;
import top.ppnt.jfinal.swaager.api.controller.SwaggerDefaultController;

/**
 * swagger 路由
 */
public class SwaggerRoutes extends Routes {

  @Override
  public void config() {
    add("/swagger", SwaggerController.class);
    add("/swagger/default", SwaggerDefaultController.class);
  }
}
