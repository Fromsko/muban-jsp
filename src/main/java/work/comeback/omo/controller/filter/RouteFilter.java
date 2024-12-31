package work.comeback.omo.controller.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;

@WebFilter(urlPatterns = {"/*"}, filterName = "RouteFilter", asyncSupported = true, description = "RouteFilter")
public class RouteFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RouteFilter.class);
    private HashMap<String, String> routePathList;

    @SuppressWarnings("unchecked")
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();

        routePathList = (HashMap<String, String>) servletContext.getAttribute("routePathList");
    }

    private boolean hasMatchPath(String mPath) {
        // 匹配路径
        if (routePathList != null) {
            for (String path : routePathList.keySet()) {
                if (path.contains(mPath)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String routePath = req.getServletPath();

        if (hasMatchPath(routePath)) {
            logger.info("matched path: {}", routePath);
            String nextRoute = this.routePathList.get(routePath);
            request.getRequestDispatcher(nextRoute).forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }
}
