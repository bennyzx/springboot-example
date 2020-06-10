package cn.eggnetech.eggnetechcaching;

import cn.eggnetech.eggnetechcaching.service.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @name:
 * @description: Created by Benny Zhou on 2020/3/18
 */
@Component
public class EggnetechCachingRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(EggnetechCachingRunner.class);

    private final BookRepository bookRepository;

    public EggnetechCachingRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info(".... Fetching books");
        LOGGER.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        LOGGER.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        LOGGER.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        LOGGER.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        LOGGER.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        LOGGER.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
    }
}
