package top.ppnt.jfinal.swaager.api.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.Okv;
import com.jfinal.template.Engine;

import top.ppnt.jfinal.swaager.api.services.SwaggerService;

/**
 * Swagger UI Controller
 */
public class SwaggerController extends Controller {
  private final String DEFAULT_STYLE = "layui";
  private final Set<String> STYLE_SET = new HashSet<String>(Arrays.asList("layui,default".split(",")));
  private static final String RESOURCE_BASE_PATH = "/META-INF/resources/swagger/";
  private static Engine engine = Engine.use().setBaseTemplatePath(RESOURCE_BASE_PATH);

  @Inject
  private SwaggerService swaggerService;

  static {
    engine.setToClassPathSourceFactory();
  }

  /**
   * api页面
   */
  public void index() {
    String style = getPara(0, DEFAULT_STYLE);
    style = style == null || !STYLE_SET.contains(style.trim()) ? DEFAULT_STYLE : style.trim();
    renderHtml(engine.getTemplate(style + "/index.html").renderToString(null));
  }

  /**
   * 获取所有api接口
   */
  public void api(String timestrap) {
    HttpServletRequest httpServletRequest = getRequest();
    String serverName = httpServletRequest.getServerName();
    int serverPort = httpServletRequest.getServerPort();

    Okv allApi = swaggerService.api(serverName, serverPort);
    renderJson(allApi);
  }
}