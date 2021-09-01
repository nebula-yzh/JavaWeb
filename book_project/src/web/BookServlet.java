package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用 BookService.page(pageNo，pageSize)：Page 对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        //设置url分页请求地址
        page.setUrl("manager/bookServlet?action=page");
        //3 保存 Page 对象到 Request 域中
        request.setAttribute("page", page);
        //4 请求转发到 pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    /**
     * 处理图书添加功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo+=1;
        // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        // 2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
        // 3、跳到图书列表页面 使用重定向(两次请求)而不是请求转发(一次请求)，使用请求转发会出现bug
        // /manager/bookServlet?action=page
        //request.getRequestDispatcher("/manager/bookServlet?action=page").forward(request, response);
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 处理图书的删除功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        // 1、获取请求的参数 id，图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2、调用 bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        // 3、重定向回图书列表管理页面
        // /book/manager/bookServlet?action=page
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 实现修改操作
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        // 2、调用 BookService.updateBook()修改图书
        bookService.updateBook(book);
        // 3、跳到图书列表页面 使用重定向(两次请求)
        // /manager/bookServlet?action=page
        response.sendRedirect(request.getContextPath() + "/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    /**
     * 获取图书信息，并回显到编辑页面，进行修改图书
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 获取请求的参数图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //2 调用 bookService.queryBookById 查询图书
        Book book = bookService.queryBookById(id);
        //3 保存到图书到 Request 域中
        request.setAttribute("book", book);
        // 4 请求转发到。pages/manager/book_edit.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
    }

    /**
     * 处理查询所有图书的功能
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到 Request 域中
        request.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp 页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
