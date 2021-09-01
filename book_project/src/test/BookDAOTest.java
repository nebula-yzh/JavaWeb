package test;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDAOTest {
    BookDAO bookDAO = new BookDAOImpl();
    @Test
    public void addBook() {
        int i = bookDAO.addBook(new Book(null, "灵域", new BigDecimal(150),
                "逆苍天", 110, 2000, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        int i = bookDAO.deleteBookById(21);
        System.out.println(i);
    }

    @Test
    public void updateBook() {
        bookDAO.updateBook(new Book(21, "灵域", new BigDecimal(150),
                "逆苍天", 110, 2000, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookDAO.queryBookById(21);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookDAO.queryBooks();
        for(Book book:books){
            System.out.println(book);
        }
    }
}