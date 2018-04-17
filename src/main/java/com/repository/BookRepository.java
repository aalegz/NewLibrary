package com.repository;

import com.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
        Book findBookByTitle(String title);

        /*@Modifying
        @Query("UPDATE book b SET b.is_read=true WHERE b.id = :bookId")
        void updateBookById(@Param("bookId") int id);*/
}
