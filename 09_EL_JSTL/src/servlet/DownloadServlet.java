package servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //文件上传步骤
        //1、获取要下载的文件名
        String downloadFileName = "0.jpg";
        // 2、读取要下载的文件内容 (通过 ServletContext 对象可以读取)
        ServletContext servletContext = getServletContext();
        // 获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型：" + mimeType);
        // 4、在回传前，通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        // 5、还要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Disposition 响应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // filename= 表示指定下载的文件名
        //**** response.setHeader("Content-Disposition", "attachment; filename=" + downloadFileName);
        /**
         *  1.若文件名为中文，需要将编码变成utf-8，通过url编码(URLEncoder)，支持谷歌浏览器与IE浏览器，不支持火狐浏览器
         *
         *  2.BASE64编解码 解决火狐浏览器的附件中文名问题
         *  这时候需要把请求头 Content-Disposition: attachment; filename=中文名
         *  编码成为：Content-Disposition: attachment; filename= =?charset?B?xxxxx?=
         *  =?charset?B?xxxxx?= 现在我们对这段内容进行一下说明。
         *
         *  =? 表示编码内容的开始
         *  charset 表示字符集
         *  B 表示 BASE64 编码
         *  xxxx 表示文件名 BASE64 编码后的内容
         *  ?= 表示编码内容的结束
         */
        if(request.getHeader("User-Agent").contains("FireFox")){
            //如果是火狐就用Base64编码
            response.setHeader("Content-Disposition", "attachment; filename=" + "=?utf-8?B?"+
                    new BASE64Encoder().encode("中文.jpg".getBytes(StandardCharsets.UTF_8))+"?=");
        }else{
            //如果不是火狐。谷歌或IE就用URL编码
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("中文.jpg", "utf-8"));
        }

        /*  / 斜杠被服务器解析表示地址为 http://ip:prot/工程名/ 映射 到代码的 Web 目录 */
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        // 获取响应的输出流
        OutputStream outputStream = response.getOutputStream();
        // 3、把下载的文件内容回传给客户端
        // 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
