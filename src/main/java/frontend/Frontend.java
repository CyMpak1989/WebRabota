package frontend;

import calculation.Calculation;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Frontend extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post запрос!!!");
        //Обрабатываем от пользователя и вернем post.html
        Map<String, Object> pageVariables = new HashMap<>();
        Calculation calculation = new Calculation();
        calculation.setStartTime(Integer.parseInt(req.getParameter("startHours")), Integer.parseInt(req.getParameter("startMinutes")));
        calculation.setEndTime(Integer.parseInt(req.getParameter("endHours")), Integer.parseInt(req.getParameter("endMinutes")));
        resp.setContentType("text/html;charset=utf-8");
        pageVariables.put("getStartTime", calculation.getStartTime());
        pageVariables.put("getEndTime", calculation.getEndTime());
        pageVariables.put("getRealTime", calculation.getRealTime());
        pageVariables.put("getFinalTime", calculation.getFinalTime());
        resp.getWriter().println(PageGenerator.getPage("post.html", pageVariables));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Get запрос!!!");
        //Обрабатываем запрос на сервер и отдаем index.html
        Map<String, Object> pageVariables = new HashMap<>();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(PageGenerator.getPage("index.html", pageVariables));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
