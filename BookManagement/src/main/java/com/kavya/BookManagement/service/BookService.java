package com.kavya.BookManagement.service;

import com.kavya.BookManagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int idCounter = 1;

    public Book addBook(Book book) {
        book.setId(idCounter++);
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book updateBook(int id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
