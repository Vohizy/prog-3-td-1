package app.prog.model;

<<<<<<< HEAD:src/main/java/app/prog/model/Book.java

=======
import jakarta.persistence.*;
>>>>>>> dev:src/main/java/app/prog/model/BookEntity.java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD:src/main/java/app/prog/model/Book.java
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
=======
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> dev:src/main/java/app/prog/model/BookEntity.java
    private int id;
    private String title;
    private String author;
    private Integer pageNumber;
    private LocalDate releaseDate;

    public boolean hasAuthor() {
        return author != null;
    }

}
