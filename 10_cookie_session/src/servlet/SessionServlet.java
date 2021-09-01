package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void setSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session对象
        HttpSession session = request.getSession();
        //2.设置session的值
        session.setAttribute("sessionKey","sessionValue");
        response.getWriter().write("已经往session域中保存数据");
    }
    protected void getSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取session对象
        HttpSession session = request.getSession();
        //2.获取session域中的数据
        Object sessionKey = session.getAttribute("sessionKey");
        response.getWriter().write("从 Session 中获取出 key1 的数据是："+ sessionKey);
    }
    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 创建 session对象
        HttpSession session = request.getSession();
        //获取id号
        String sessionId = session.getId();
        response.getWriter().write("session ID："+sessionId+"<br/>");
        //判断是否为新创建
        boolean aNew = session.isNew();
        response.getWriter().write("是否为新建："+String.valueOf(aNew));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
