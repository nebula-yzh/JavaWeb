package web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码问题
        response.setContentType("text/html; charset=utf-8");
        //通过添加隐藏域，将登录与注册servlet抽取为一个servlet
        String action = request.getParameter("action");
        //通过反射执行业务，简化代码，不需要大量的if-else if
        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this, request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
