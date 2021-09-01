package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("到此一游，Response1");
        //设置响应状态码，302表示重定向
        //法一、不推荐使用
//        response.setStatus(302);
//        response.setHeader("Location","http://localhost:8080/07_servlet/response2");
        //法二、推荐使用
        response.sendRedirect("http://localhost:8080/07_servlet/response2");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
