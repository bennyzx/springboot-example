package cn.eggnetech.eggnetechcaching.service.impl;

import cn.eggnetech.eggnetechcaching.bo.Book;
import cn.eggnetech.eggnetechcaching.service.BookRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/18
 */
@Component
public class SimpleBookRepositoryImpl implements BookRepository {
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        long time = 3000L;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
