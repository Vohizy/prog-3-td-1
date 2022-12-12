package app.prog.controller.mapper;

import app.prog.controller.Bookcreat.BookCreat;
import app.prog.model.Book;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    public BookResponse toRest(BookEntity domain) {
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
    public BookEntity toDomain(CreateBookResponse rest) {
        return BookEntity.builder()
                .author(rest.getAuthor())
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        return BookEntity.builder()
                .id(rest.getId())
                .author(rest.getAuthor())
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value
                .build();
    }
}
