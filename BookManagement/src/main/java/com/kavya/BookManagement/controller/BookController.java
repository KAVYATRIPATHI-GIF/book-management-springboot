package com.kavya.BookManagement.controller;

import com.kavya.BookManagement.model.Book;
import com.kavya.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // POST /books → Add a book
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // GET /books → Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // PUT /books/{id} → Update book
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id,
                           @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    // DELETE /books/{id} → Delete book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        boolean deleted = bookService.deleteBook(id);
        return deleted ? "Book deleted successfully" : "Book not found";
    }
}
