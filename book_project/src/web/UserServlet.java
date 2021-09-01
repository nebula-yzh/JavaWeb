package web;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    //web层只能调用service层
    private UserService userService = new UserServiceImpl();

    /**
     * 处理注销功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //销毁session中用户的登陆信息
        session.invalidate();
        //重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    /**
     * 处理登录的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //登录功能
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //2.调用service，判断用户名密码是否正确,若为null登陆失败
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null) {
            //不正确，返回到登陆页面
            //把错误信息，和回显的表单项信息，保存到request域中
            request.setAttribute("msg", "用户名或密码错误！");
            request.setAttribute("username", username);
            //跳回登陆页面
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            //正确
            //并将用户信息放入session域中
            request.getSession().setAttribute("user", loginUser);
            //跳转到登陆成功页面login_success.jsp
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    /**
     * 处理注册的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        //User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //获取session中的验证码
        String kaptcha_session_key = (String) request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        //删除session域中的验证码
        //request.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        //2.检查验证码是否正确,是否为null
        if (kaptcha_session_key != null && kaptcha_session_key.equalsIgnoreCase(code)) {
            //正确
            //3.检查用户名是否可用
            boolean flag = userService.existsUsername(username);
            if (flag) {
                //不可用，跳回注册页面
                request.setAttribute("msg", "用户名已存在！");
                request.setAttribute("email", email);
                System.out.println("用户名[" + username + "]已存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            } else {
                //可用，调用service保存到数据库，并跳转到注册成功页面
                User user = new User(null, username, password, email);
                userService.registerUser(user);
                //并将用户信息放入session域中
                request.getSession().setAttribute("user", user);
                //跳转到注册成功页面regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            }
        } else {
            //不正确 或为null
            //跳转回注册页面
            //把回显信息，保存到request域中
            request.setAttribute("msg", "验证码错误！");
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/pages/user/regist.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
//        String action = request.getParameter("action");
//        if ("login".equals(action)) {
//            //登录功能
//            login(request,response);
//        } else if ("regist".equals(action)) {
//            //注册功能
//            regist(request,response);
//        }
    }
}
