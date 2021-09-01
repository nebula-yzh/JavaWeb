package servlet_test;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      字节流 getOutputStream (); 常用于下载（传递二进制数据）
//      字符流 getWriter (); 常用于回传字符串（常用）
//      两个流同时只能使用一个。

        //响应的字符集
//        System.out.println(response.getCharacterEncoding());//默认为(ISO-8859-1)
        //设置字符集 法一、不推荐使用
//        //8 设置服务器的字符集为UTF-(但浏览器显示还是乱码，需要设置浏览器的编码字符集)
//        response.setCharacterEncoding("UTF-8");
//        //设置浏览器的字符集也为UTF-8,通过响应头来设置
//        response.setHeader("Content-Type","text/html; charset=UTF-8");
        //法二、 推荐使用
        //它会同时设置服务器与客户端响应字符集，同时设置响应头
        //此方法要在获取流对象前设置才有效
        response.setContentType("text/html; charset=utf-8");

        //往客户端回传一个字符串(会显示在页面上)
        PrintWriter writer = response.getWriter();
        writer.write("response's content!!!");
        //中文会导致乱码
        writer.write("应志豪");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
