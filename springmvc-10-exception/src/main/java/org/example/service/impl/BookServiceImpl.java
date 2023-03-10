package org.example.service.impl;

import org.example.controller.Code;
import org.example.dao.BookDao;
import org.example.domain.Book;
import org.example.exception.BusinessException;
import org.example.exception.SystemException;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;
    @Override
    public boolean save(Book book) {
        bookDao.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        bookDao.update(book);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        bookDao.delete(id);
        return true;
    }

    @Override
    public Book getById(Integer id) {
        if (id == 1)
            throw new BusinessException(Code.BUSINESS_ERR,"haha");

        //将可能出现的异常进行包装，转换成自定义异常
        try {
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR,"服务器访问超时，请重试",e);
        }


        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
