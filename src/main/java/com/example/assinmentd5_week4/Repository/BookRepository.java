package com.example.assinmentd5_week4.Repository;

import com.example.assinmentd5_week4.Model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);

    List<Book> findBookByCategory(String category);

    List<Book> findBookByAuthor(String author);

    Book findBookByTitle(String title);

}
