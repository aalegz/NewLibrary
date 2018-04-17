package com.service;

/**/
import com.domain.Book;
import com.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book getBookByTitle(String title){
        return repository.findBookByTitle(title);
    }

    //add save method
    public void saveBook(Book book){
        repository.save(book);
    }

    public void updateBookById(int id){
        Book book = repository.getOne(id);

        if (!book.isReadAlready()){
            book.setReadAlready(true);
        }

        repository.saveAndFlush(book);
    }

    public void deleteBookById(int id){
        repository.deleteById(id);
    }

    public List<Book> getBooks(){
          return repository.findAll();
    }

    public List<Book> getBooksOnPage(int page){
        PageRequest request = new PageRequest(page, 10);
        return repository.findAll(request).getContent();
    }

}
