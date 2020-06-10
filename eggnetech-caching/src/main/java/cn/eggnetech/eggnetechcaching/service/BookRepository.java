package cn.eggnetech.eggnetechcaching.service;

import cn.eggnetech.eggnetechcaching.bo.Book;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/18
 */
public interface BookRepository {
    /**
     * Gets book by the specified isbn
     * @param isbn
     * @return
     */
    Book getByIsbn(String isbn);
}
