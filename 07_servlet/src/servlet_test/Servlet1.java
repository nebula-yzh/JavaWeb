package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("into servlet1");
        String username = request.getParameter("username");
        System.out.println("获取用户参数:"+username);
        request.setAttribute("key1","servlet1的章");
        //请求转发地址
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");
        //转发
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
