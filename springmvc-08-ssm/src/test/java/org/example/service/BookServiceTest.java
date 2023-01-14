package org.example.service;

import org.example.config.SpringConfig;
import org.example.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Test
    public void testGetById(){
        Book book = bookService.getById(13);
        System.out.println(book);
    }

    @Test
    public void testGetAll(){
        List<Book> all = bookService.getAll();
        System.out.println(all);
    }

    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("testName");
        book.setType("testType");
        book.setDescription("testDescription");

        System.out.println(bookService.save(book));
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setName("testName");
        book.setType("testType666");
        book.setDescription("testDescription");
        book.setId(15);

        System.out.println(bookService.update(book));
    }

    @Test
    public void testDelete(){
        System.out.println(bookService.delete(15));
    }


}
