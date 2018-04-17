package com.controller;

import com.domain.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("book")
public class BookController {
/*У вас есть всего 1 таблица book. В ней хранится список книг (например, на книжной полке).
Книги на полку можно добавлять (create), брать посмотреть (read), заменять на новый выпуск (update), убирать (delete).*/

    @Autowired
    private BookService bookService;


    @PostMapping(value = "/create", consumes = "application/json")
    public void saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
    }

    @GetMapping(value = "/read/{title}")
    public ResponseEntity<Book> readBook(@PathVariable String title) {
        Book book = bookService.getBookByTitle(title);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public void updateBook(@PathVariable("id") int id) {
        bookService.updateBookById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBookById(id);
    }

    @GetMapping(value = "/show")
    public List<Book> showBooks(){
        return bookService.getBooks();
    }

    @GetMapping(value = "/count/{page}")
    public List<Book> showPage(@PathVariable int page) {
        return bookService.getBooksOnPage(page);
    }

}
