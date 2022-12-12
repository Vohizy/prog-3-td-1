package app.prog.controller;
import app.prog.controller.Bookcreat.BookCreat;
import app.prog.controller.mapper.BookRestMapper;
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
    public List<BookResponse> createBookse(@RequestBody List<BookCreat> toCreate) {
        return service.createBooks(toCreate
                        .stream()
                        .map(mapper::toCreat)
                        .collect(Collectors.toList())).stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }


    @PutMapping("/books")
    public List<BookResponse> updateBooks(@RequestBody List<BookResponse> toUpdate) {
        return service.updateBooks(toUpdate.stream()
                        .map(mapper::toUpdate)
                        .collect(Collectors.toList())).stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/books/{bookId}")
    public BookResponse deleteBook(@PathVariable Integer bookId) {
        return mapper.toRest(service.deleteBook(bookId));
    }
}
