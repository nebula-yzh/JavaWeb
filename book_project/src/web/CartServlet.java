package web;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    /**
     * 修改商品数量
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // 获取请求的参数 商品编号 、商品数量
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        int count = WebUtils.parseInt(request.getParameter("count"), 1);
        // 获取 Cart 购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 修改商品数量
            cart.updateCount(id, count);
            // 重定向回原来购物车展示页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        // 1 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 清空购物车
            cart.clear();
            // 重定向回原来购物车展示页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 删除购物车中商品
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 获取购物车对象
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            // 删除购物车商品项
            cart.deleteItem(id);
            // 重定向回原来购物车展示页面
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    /**
     * 商品加入购物车
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        System.out.println("进入添加购物车函数servlet");
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        //根据id得到图书
        Book book = bookService.queryBookById(id);
        //把获取的图书信息转换成CartItem购物车商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用Cart.addItem(CartItem);添加商品项
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
        System.out.println("书："+cart);
        //保存最后一个添加的商品名称，数据回显
        request.getSession().setAttribute("lastName",cartItem.getName());
        // 重定向回原来商品所在的地址页面 "Referer"
        response.sendRedirect(request.getHeader("Referer"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        super.doPost(request, response);
    }
}
