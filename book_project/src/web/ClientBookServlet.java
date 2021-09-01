package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 根据价格区间处理分页功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了前台价格查询分页功能");
        //1 获取请求的参数 pageNo  pageSize min max
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        //2 调用 BookService.page(pageNo，pageSize)：Page 对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        //保证每次请求都带着min和max
        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        if(request.getParameter("min")!=null){
            sb.append("&min=").append(request.getParameter("min"));
        }
        if(request.getParameter("max")!=null){
            sb.append("&max=").append(request.getParameter("max"));
        }
        //设置url分页请求地址
        page.setUrl(sb.toString());
        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);
        //4 请求转发
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    /**
     * 处理分页功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了前台的ClientBookServlet程序");
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用 BookService.page(pageNo，pageSize)：Page 对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置url分页请求地址
        page.setUrl("client/bookServlet?action=page");
        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);
        //4 请求转发
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
