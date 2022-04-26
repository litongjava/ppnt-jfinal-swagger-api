package top.ppnt.jfinal.swaager.api.controller;

import javax.servlet.http.HttpServletRequest;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Okv;
import com.jfinal.template.Engine;

import top.ppnt.jfinal.swaager.api.services.SwaggerService;

/**
 * Swagger UI Controller
 */
@Path("swagger")
public class SwaggerController extends Controller {
  private static final String RESOURCE_BASE_PATH = "/META-INF/resources/swagger/";
  private static Engine engine = Engine.use().setBaseTemplatePath(RESOURCE_BASE_PATH);

  @Inject
  private SwaggerService swaggerService;

  static {
    engine.setToClassPathSourceFactory();
  }

  public void index() {
    // 如果直接写layui出现定位错误,如下所示
    // http://127.0.0.1:8000/jfinal-4.9-ppnt-jfinal-swagger-apilayui
    // 重定向到当前目录下的layui
//    String contextPath = getRequest().getContextPath();
//    String requestURI = getRequest().getRequestURI();
//    String substring = requestURI.substring(contextPath.length());
//    redirect(substring+"layui");
    renderHtml(engine.getTemplate("layui" + "/index.html").renderToString(null));
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