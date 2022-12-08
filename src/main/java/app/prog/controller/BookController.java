package app.prog.controller;
import app.prog.controller.Bookcreat.BookCreat;
import app.prog.service.BookService;

import app.prog.model.Book;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService service;
    private final BookRestMapper mapper;

    @GetMapping("/books")
    public List<BookResponse> getBooks() {
        return service.getBooks().stream()
                .map(mapper::toRest)
                .toList();
    }


    @PostMapping("/books")
    public List<BookResponse> createBooks(@RequestBody List<BookCreat> toCreate) {
        return service.createBooks(toCreate
                        .stream()
                        .map(mapper::toCreat)
                        .toList()).stream()
                .map(mapper::toRest)
                .toList();
    }


    @PutMapping("/books")
    public List<BookResponse> updateBooks(@RequestBody List<BookResponse> toUpdate) {
        return service.updateBooks(toUpdate.stream()
                        .map(mapper::toUpdate)
                        .toList()).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/books/{bookId}")
    public BookResponse deleteBook(@PathVariable Integer bookId) {
        return mapper.toRest(service.deleteBook(bookId));
    }
}
