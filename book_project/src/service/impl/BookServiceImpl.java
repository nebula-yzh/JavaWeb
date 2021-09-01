package service.impl;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import pojo.Book;
import pojo.Page;
import service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDAO bookDAO = new BookDAOImpl();

    @Override
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDAO.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDAO.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDAO.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);


        //求当前页数据的开始索引，从0开始
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页的数据
        List<Book> items = bookDAO.queryForPageItems(begin, pageSize);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDAO.queryForPageTotalCountByPrice(min, max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        //设置总页码数
        page.setPageTotal(pageTotal);

        //设置当前页码
        page.setPageNo(pageNo);

        //求当前页数据的开始索引，从0开始
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页的数据
        List<Book> items = bookDAO.queryForPageItemsByPrice(begin, pageSize, min, max);
        //设置当前页数据
        page.setItems(items);
        return page;
    }

}
