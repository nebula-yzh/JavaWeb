package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("newServlet get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("newServlet post");
    }
}
