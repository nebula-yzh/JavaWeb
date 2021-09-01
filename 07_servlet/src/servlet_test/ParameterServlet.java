package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------doGet----------");
        //v.getParameter() 获取请求的参数
        System.out.println("获取请求的参数username："+ request.getParameter("username"));
        System.out.println("获取请求的参数password："+ request.getParameter("password"));
//      vi.getParameterValues() 获取请求的参数（多个值的时候使用）(用于复选框或下拉列表多个值)
        System.out.println("获取请求的参数hobbies："+ Arrays.asList(request.getParameterValues("hobby")));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8,从而解决POST请求中文乱码问题
        request.setCharacterEncoding("UTF-8");
        System.out.println("-----------doPost----------");
        //v.getParameter() 获取请求的参数
        System.out.println("获取请求的参数username："+ request.getParameter("username"));
        System.out.println("获取请求的参数password："+ request.getParameter("password"));
//      vi.getParameterValues() 获取请求的参数（多个值的时候使用）(用于复选框或下拉列表多个值)
        System.out.println("获取请求的参数hobbies："+ Arrays.asList(request.getParameterValues("hobby")));

    }
}
