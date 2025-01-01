package work.comeback.omo.controller.guard;

import com.google.gson.Gson;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

public class RegisteredPageGuard extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 获取 servlet 上下文
        ServletContext servletContext = request.getServletContext();

        HashMap<String, String> routePathList = (HashMap<String, String>) servletContext.getAttribute("routePathList");

        // 设置响应类型为 JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 将数据转为 JSON 格式并发送
        Gson gson = new Gson();
        String json = gson.toJson(routePathList);
        response.getWriter().write(json);
    }
}
