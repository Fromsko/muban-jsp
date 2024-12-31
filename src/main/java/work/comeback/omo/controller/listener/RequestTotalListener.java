package work.comeback.omo.controller.listener;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSessionListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestTotalListener implements ServletRequestListener, HttpSessionListener, ServletContextListener {
    // 上下文创建
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        List<String> timeList = new ArrayList<>();
        List<Number> valueList = new ArrayList<>();
        sce.getServletContext().setAttribute("timeList", timeList);
        sce.getServletContext().setAttribute("valueList", valueList);
    }

    // 请求创建
    @SuppressWarnings("unchecked")
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext servletContext = sre.getServletContext();
        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        // 获取请求路径
        String requestPath = httpServletRequest.getRequestURL().toString();

        if (requestPath.contains("/api/guard/getTotal")) {
            return;
        }

        // 使用 getAttribute 获取并转换类型，添加 @SuppressWarnings 禁用警告
        List<String> timeList = (List<String>) servletContext.getAttribute("timeList");
        if (timeList == null) {
            timeList = new ArrayList<>();
            servletContext.setAttribute("timeList", timeList);
        }

        List<Number> valueList = (List<Number>) servletContext.getAttribute("valueList");
        if (valueList == null) {
            valueList = new ArrayList<>();
            servletContext.setAttribute("valueList", valueList);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String time = simpleDateFormat.format(date);

        if (!timeList.contains(time)) {
            timeList.add(time);
            valueList.add(1);
            servletContext.setAttribute("timeList", timeList);
            servletContext.setAttribute("valueList", valueList);
        } else {
            int index = timeList.indexOf(time);
            int value = (int) valueList.get(index);
            valueList.set(index, value + 1);
            servletContext.setAttribute("valueList", valueList);
        }
    }
}
