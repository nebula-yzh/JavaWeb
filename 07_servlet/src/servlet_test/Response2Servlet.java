package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Response2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理请求：Response2");
        response.getWriter().write("Response2's result!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
