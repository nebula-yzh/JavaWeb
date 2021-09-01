package dao;

import pojo.Book;

import java.util.List;

public interface BookDAO {
    /**
     * 添加图书
     *
     * @param book
     * @return 返回-1添加不成功，否则返回受影响的行数
     */
    public int addBook(Book book);

    /**
     * 根据id删除图书
     *
     * @param id
     * @return 返回-1删除不成功，否则返回受影响的行数
     */
    public int deleteBookById(Integer id);

    /**
     * 修改图书
     *
     * @param book
     * @return 返回-1修改不成功，否则返回受影响的行数
     */
    public int updateBook(Book book);

    /**
     * 根据id查询图书
     *
     * @param id
     * @return 返回null时查询不成功
     */
    public Book queryBookById(Integer id);

    /**
     * 查询所有图书
     *
     * @return 返回list集合，否侧返回null
     */
    public List<Book> queryBooks();

    /**
     * 查询总图书数
     *
     * @return 返回总记录数
     */
    public Integer queryForPageTotalCount();

    /**
     * 查询每页的图书
     *
     * @param begin
     * @param pageSize
     * @return 返回list集合，否则返回null
     */
    public List<Book> queryForPageItems(int begin, int pageSize);

    /**
     * 查询在某价格区间内的图书数
     *
     * @param min
     * @param max
     * @return
     */
    public Integer queryForPageTotalCountByPrice(int min, int max);

    /**
     * 查询每页的图书
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);

}
