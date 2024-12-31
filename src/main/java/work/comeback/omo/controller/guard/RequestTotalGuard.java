package work.comeback.omo.controller.guard;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestTotalGuard extends HttpServlet {
    @SuppressWarnings("unchecked")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        // 获取 Context 中的数据
        List<String> timeList = (List<String>) getServletContext().getAttribute("timeList");
        List<Number> valueList = (List<Number>) getServletContext().getAttribute("valueList");

        Map<String, Object> result = new HashMap<>();
        result.put("timeList", timeList);
        result.put("valueList", valueList);

        Gson gson = new Gson();

        String json = gson.toJson(result);
        resp.getWriter().write(json);
    }
}
