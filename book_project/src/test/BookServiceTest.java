package test;

import org.junit.Test;
import pojo.Book;
import service.BookService;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null, "灵域", new BigDecimal(150),
                "逆苍天", 110, 2000, null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(4, "灵域", new BigDecimal(150),
                "逆苍天", 110, 2000, null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(23);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book:books){
            System.out.println(book);
        }
    }
}