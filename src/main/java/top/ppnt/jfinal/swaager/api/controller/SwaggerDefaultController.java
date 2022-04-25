package top.ppnt.jfinal.swaager.api.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.template.Engine;

/**
 * @author Ping E Lee
 *
 */
@Path("swagger/default")
public class SwaggerDefaultController extends Controller {
  private static final String RESOURCE_BASE_PATH = "/META-INF/resources/swagger/";
  private static Engine engine = Engine.use().setBaseTemplatePath(RESOURCE_BASE_PATH);

  static {
    engine.setToClassPathSourceFactory();
  }

  /**
   * api页面
   */
  public void index() {
    renderHtml(engine.getTemplate("default" + "/index.html").renderToString(null));
  }
}