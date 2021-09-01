package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void getCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            //getName返回键
            //getValue返回值
            response.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
            System.out.println(cookie.getName()+"="+cookie.getValue());
        }
    }
    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 创建 Cookie 对象 存入键值对
        Cookie cookie = new Cookie("key1", "value1");
        //2 通知客户端保存Cookie
        response.addCookie(cookie);
        // 1 创建 Cookie 对象
        Cookie cookie1 = new Cookie("key5", "value5");
        // 2 通知客户端保存 Cookie
        response.addCookie(cookie1);
        response.getWriter().write("Cookie 创建成功");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
