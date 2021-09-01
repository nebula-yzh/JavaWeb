package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TestHttpServletRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet方法！");
        //i.getRequestURI() 获取请求的资源路径
        System.out.println("请求的资源路径：" + request.getRequestURI());
//      ii.getRequestURL() 获取请求的统一资源定位符（绝对路径）
        System.out.println("请求的统一资源定位符(绝对路径)" + request.getRequestURL());
//      iii.getRemoteHost() 获取客户端的 ip 地址
        System.out.println("客户端的ip地址：" + request.getRemoteHost());
//      iv.getHeader()     获取请求头
        System.out.println("获取请求头："+request.getHeader("User-Agent"));
//      vii.getMethod() 获取请求的方式 GET 或 POST
        System.out.println("获取请求的方式："+request.getMethod());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
