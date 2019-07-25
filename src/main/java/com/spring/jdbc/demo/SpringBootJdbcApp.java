package com.spring.jdbc.demo;

import com.spring.jdbc.demo.model.Book;
import com.spring.jdbc.demo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApp implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(SpringBootJdbcApp.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Autowired
    @Qualifier("jdbcBookRepository")
    private BookRepository bookRepository;

	public static void main(String[] args){
        SpringApplication.run(SpringBootJdbcApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("start application");
        runJdbc();
    }

    private void runJdbc() {
        log.info("Creating tables for testing...");
        //jdbcTemplate.execute("DROP TABLE books IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE books("
                + "id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", new BigDecimal("46.32")),
                new Book("Mkyong in Java", new BigDecimal("1.99")),
                new Book("Getting Clojure", new BigDecimal("37.3")),
                new Book("Head First Android Development", new BigDecimal("41.19"))
        );

        log.info("保存");
        books.forEach(book -> {
            log.info("save...{}",book.getName());
            bookRepository.save(book);
        });
        //count
        log.info("数量：{}" + bookRepository.count());
        //findAll
        log.info("查找左右：{}" + bookRepository.findAll());
        //findById
        Book book = bookRepository.findById(2L).orElseThrow(IllegalArgumentException::new);
        log.info("根据id查询：{}" + book);

    }
}
