package frontend;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Frontend extends HttpServlet {


    private String time = "";
    private String timeEnd = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        time = req.getParameter("time");
        timeEnd = req.getParameter("timeEnd");

        resp.setContentType("text/html;charset=utf-8");

        Map<String, Object> pageVariables = new HashMap<>();
/*        pageVariables.put("time", time == null ? "" : time);
        pageVariables.put("timeEnd", timeEnd == null ? "" : timeEnd);*/

        System.out.println(time + " " + timeEnd);
        System.out.println("Пост запрос!!!");
        resp.getWriter().println(PageGenerator.getPage("form.html", pageVariables));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", time == null ? "" : time);

        System.out.println("Джет запрос!!!");
        resp.getWriter().println(PageGenerator.getPage("form.html", pageVariables));
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
