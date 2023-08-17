package com.example.assinmentd5_week4.Service;

import com.example.assinmentd5_week4.Api.ApiException;
import com.example.assinmentd5_week4.Model.Book;
import com.example.assinmentd5_week4.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Integer id, Book book){
        Book oldBook = bookRepository.findBookById(id);

        if(oldBook == null)
            throw new ApiException("Book id not found");

        oldBook.setTitle(book.getTitle());
        oldBook.setISBN(book.getISBN());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setCategory(book.getCategory());
        oldBook.setNumOfPages(book.getNumOfPages());

        bookRepository.save(oldBook);
    }

    public void deleteBook(Integer id){
        Book deleteBook = bookRepository.findBookById(id);

        if (deleteBook == null)
            throw new ApiException("Book id is wrong");

        bookRepository.delete(deleteBook);
    }

    public List<Book> getBooksCategory(String category){
        List<Book> bookList = bookRepository.findBookByCategory(category);
        if (bookList.isEmpty())
            throw new ApiException("Book not found");

        return bookList;
    }

    public List<Book> pagesMoreThan300(){
        List<Book> findBooks = getAllBook();
        ArrayList<Book> findRequiredBook = new ArrayList<>();
        for (int i = 0; i < findBooks.size(); i++) {
            if (findBooks.get(i).getNumOfPages() > 300)
                findRequiredBook.add(findBooks.get(i));
        }

        if (findRequiredBook.isEmpty())
            throw new ApiException("No book found");

        return findRequiredBook;
    }

    public List<Book> getBooksByAuthor(String author){
        List<Book> authorList = bookRepository.findBookByAuthor(author);

        if (authorList.isEmpty())
            throw new ApiException("No book found");

        return authorList;
    }

    public Book getBookTitle(String title){
        Book searchTitle = bookRepository.findBookByTitle(title);

        if (searchTitle == null)
            throw new ApiException("no book found");

        return searchTitle;
    }
}
