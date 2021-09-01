package service;

import pojo.Book;
import pojo.Page;

import java.util.List;

public interface BookService {
    /**
     * 添加图书功能
     * @param book
     */
    public void addBook(Book book);

    /**
     * 根据id删除书籍
     * @param id
     */
    public void deleteBookById(Integer id);

    /**
     * 修改书籍
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 根据id查询书籍
     * @param id
     * @return
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有书籍
     * @return
     */
    public List<Book> queryBooks();

    /**
     * 查询当前分页对象
     * @param pageNo
     * @param pageSize
     * @return 书本分页对象
     */
    public Page<Book> page(int pageNo, int pageSize);

    /**
     * 根据区间价格查询当前分页对象
     * @param pageNo
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    public Page<Book> pageByPrice(int pageNo,int pageSize,int min,int max);
}
