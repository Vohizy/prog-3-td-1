package app.prog.controller;
import app.prog.controller.Bookcreat.BookCreat;
import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.service.BookService;
import app.prog.controller.response.BookResponse;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService service;
    private final BookRestMapper mapper;

    @GetMapping("/books")
    public List<BookResponse> getBooks() {
        return service.getBooks().stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @PostMapping("/books")

    public List<BookResponse> createBooks(@RequestBody List<CreateBookResponse> toCreate) {
        List<BookEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createBooks(domain).stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }


    @PutMapping("/books")
    public List<BookResponse> updateBooks(@RequestBody List<UpdateBookResponse> toUpdate) {
        List<BookEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateBooks(domain).stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/books/{bookId}")
    public BookResponse deleteBook(@PathVariable Integer bookId) {
        return mapper.toRest(service.deleteBook(bookId));
    }
}
