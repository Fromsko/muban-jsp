package work.comeback.omo.controller.listener;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class WebListener implements ServletContextListener, HttpSessionListener, ServletRequestListener {
    private static final Logger logger = LoggerFactory.getLogger(WebListener.class);

    // 上下文创建
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("初始化了");
        ServletContext servletContext = sce.getServletContext();

        // 添加路径映射
        HashMap<String, String> routePathList = new HashMap<>();
        routePathList.put("/", "/WEB-INF/views/index.jsp");
        routePathList.put("/admin", "/WEB-INF/views/admin/index.jsp");

        // 写入上下文
        servletContext.setAttribute("routePathList", routePathList);
    }

    // session 创建
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // logger.info("session 创建了");

        // HttpSession session = se.getSession();
        // logger.info("SessionID: {}", session.getId());
        // logger.info("Session创建时间: {}", session.getCreationTime());
    }

    // 请求创建
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // logger.info("request 创建了");
        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String requestPath = request.getRequestURL().toString();

        boolean isGetTotalPath = requestPath.endsWith("getTotal");
        if (!isGetTotalPath) {
            logger.info("RequestURL: {}", request.getRequestURL());
        }
    }

    // 上下文销毁
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("上下文 销毁了");
    }

    // session 销毁
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // logger.info("session 销毁了");
    }

    // 请求销毁
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // logger.info("request 销毁了");
    }
}
