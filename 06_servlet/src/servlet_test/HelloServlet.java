package servlet_test;

import javax.servlet.*;
import java.io.IOException;

public class HelloServlet implements Servlet{


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 1、可以获取 Servlet 程序的别名 servlet-name 的值
        System.out.println("别名："+servletConfig.getServletName());
        // 2、获取初始化参数 init-param
        System.out.println("初始化参数："+servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getInitParameter("username"));
        // 3、获取 ServletContext 对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service方法是专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("HelloServlet被访问了！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
