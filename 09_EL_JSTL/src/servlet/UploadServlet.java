package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.先判断上传的数据是否为多段数据（只有是多段数据才包含文件上传表单项）
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建 FileItemFactory工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类 ServletFileUpload类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //解析上传的数据，得到每一个表单项FileItem,使用list集合存放
            try {
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断 每一个表单项是 文件上传 还是 普通表单项
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()) {
                        //true 普通表单项
                        System.out.println("表单项的name属性：" + fileItem.getFieldName());
                        //参数utf-8防止乱码
                        System.out.println("表单项的value属性：" + fileItem.getString("utf-8"));
                    } else {
                        //false 上传文件表单
                        System.out.println("表单项的name属性：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());

                        fileItem.write(new File("D:\\"+fileItem.getName()));
                        System.out.println("文件上传成功！");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        }
    }
}
