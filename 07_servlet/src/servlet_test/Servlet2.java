package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("into servlet2");
        Object key1 = request.getAttribute("key1");
        String username = request.getParameter("username");
        System.out.println("获取用户参数:" + username);
        System.out.println("servlet1的章："+key1);
        System.out.println("执行业务！");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
