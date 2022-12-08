package app.prog.controller.mapper;

import app.prog.controller.Bookcreat.BookCreat;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public Book toCreat(BookCreat creat){
        return Book.builder()
                .author(creat.getAuthor())
                .title(creat.getTitle())
                .pageNumber(0)
                .build();
    }

    public Book toUpdate(BookResponse update){
        return Book.builder()
                .id(update.getId())
                .title(update.getTitle())
                .author(update.getAuthor())
                .hasAuthor(update.hasAuthor())
                .build();
    }
}
