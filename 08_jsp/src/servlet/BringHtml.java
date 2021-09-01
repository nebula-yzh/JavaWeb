package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class BringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        //通过响应的输出回传html页面数据
        PrintWriter writer = response.getWriter();
        //通过响应流，一行一行输出
        writer.write("<!DOCTYPE html>\t\n");
        writer.write("  <html lang = \"en\" >\t\n");
        writer.write("   <head >\t\n");
        writer.write("    <meta charset = \"UTF-8\" >\t\n");
        writer.write("    <title > Title </title >\t\n");
        writer.write("   </head >\t\n");
        writer.write("   <body >\t\n");
        writer.write("        这是html页面数据\t\n");
        writer.write("   </body >\t\n");
        writer.write("  </html >\t\n");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
