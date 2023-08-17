package com.example.assinmentd5_week4.Controller;

import com.example.assinmentd5_week4.Api.ApiResponse;
import com.example.assinmentd5_week4.Model.Book;
import com.example.assinmentd5_week4.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getAllBooks(){
        return ResponseEntity.status(200).body(bookService.getAllBook());
    }

    @PostMapping("/add")
    public ResponseEntity addNewBook(@RequestBody @Valid Book book){
        bookService.addBook(book);

        return ResponseEntity.status(200).body(new ApiResponse("new book added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @RequestBody @Valid Book book){

        bookService.updateBook(id, book);

        return ResponseEntity.status(200).body(new ApiResponse("Updated the book successfully"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("The book deleted successfully"));
    }

    @GetMapping("/getBook")
    public ResponseEntity getBooks300(){
        return ResponseEntity.status(200).body(bookService.pagesMoreThan300());
    }

    @GetMapping("/getAuth/{author}")
    public ResponseEntity getByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/search/{title}")
    public ResponseEntity searchT(@PathVariable String title){
        return ResponseEntity.status(200).body(bookService.getBookTitle(title));
    }

}
